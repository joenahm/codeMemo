#include <iostream>
using namespace std;

class Account{  //定义类Account
private:        //声明属性id、balance
    int id;
    double balance;

public:         //声明方法：获取账号、获取余额、存钱、取钱
    int getId(void);
    double getBalance(void);
    void moneyIn(double amount);
    void moneyOut(double amount);
    Account(int,double);
};
/*方法实现开始*/
int Account::getId(void){
    return id;
}
double Account::getBalance(void){
    return balance;
}
void Account::moneyIn(double amount){
    balance+=amount;
}
void Account::moneyOut(double amount){
    balance-=amount;
}
Account::Account(int iId=123456,double dBalance=0.0){
    id=iId;
    balance=dBalance;
}
/*方法实现结束*/
int main(){
    Account zhangjian,haha(111,500);    //实例化对象zhangjian、haha；并给对象haha赋初值111，500
    cout<<zhangjian.getId()<<":"<<zhangjian.getBalance()<<endl; //输出zhangjian的账号和余额
    zhangjian.moneyIn(20);  //给zhangjian存钱20
    zhangjian.moneyOut(10); //取钱10
    cout<<zhangjian.getId()<<":"<<zhangjian.getBalance()<<endl;     //输出zhangjian的账号和余额
    cout<<haha.getId()<<":"<<haha.getBalance()<<endl;       //输出haha的账号和余额
    haha.moneyOut(20);  //给haha取钱20
    cout<<haha.getId()<<":"<<haha.getBalance()<<endl;   //输出zhangjian的账号和余额
    return 0;
}
