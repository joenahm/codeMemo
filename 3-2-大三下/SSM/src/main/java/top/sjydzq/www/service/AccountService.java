package top.sjydzq.www.service;

public interface AccountService {
    public boolean transfer(int fromId, int toId, float money);
}
