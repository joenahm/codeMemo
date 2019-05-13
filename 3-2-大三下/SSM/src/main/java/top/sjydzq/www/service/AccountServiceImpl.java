package top.sjydzq.www.service;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import top.sjydzq.www.dao.AccountDAO;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private DataSourceTransactionManager txManager;

    public DataSourceTransactionManager getTxManager() {
        return txManager;
    }

    public void setTxManager(DataSourceTransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public boolean transfer(int fromId, int toId, float money) {
        TransactionStatus ts = txManager.getTransaction(new DefaultTransactionDefinition());

        boolean status = true;

        try {
            String fromSql = "UPDATE Account SET balance=balance-? WHERE id=?";
            Object[] fromParams = {money, fromId};
            if (accountDAO.update(fromSql, fromParams) <= 0) {
                status = false;
            }

            String toSql = "UPDATE Account SET balance=balance+? WHERE id=?";
            Object[] toParams = {money, toId};
            if (accountDAO.update(toSql, toParams) <= 0) {
                status = false;
            }

            txManager.commit(ts);
        } catch (Exception e) {
            status = false;

            txManager.rollback(ts);
            e.printStackTrace();
            System.err.println("数据库操作出现异常，事务回滚...");
        }

        return status;
    }
}
