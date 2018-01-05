#include <iostream>
using namespace std;

class Account{  //������Account
private:        //��������id��balance
    int id;
    double balance;

public:         //������������ȡ�˺š���ȡ����Ǯ��ȡǮ
    int getId(void);
    double getBalance(void);
    void moneyIn(double amount);
    void moneyOut(double amount);
    Account(int,double);
};
/*����ʵ�ֿ�ʼ*/
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
/*����ʵ�ֽ���*/
int main(){
    Account zhangjian,haha(111,500);    //ʵ��������zhangjian��haha����������haha����ֵ111��500
    cout<<zhangjian.getId()<<":"<<zhangjian.getBalance()<<endl; //���zhangjian���˺ź����
    zhangjian.moneyIn(20);  //��zhangjian��Ǯ20
    zhangjian.moneyOut(10); //ȡǮ10
    cout<<zhangjian.getId()<<":"<<zhangjian.getBalance()<<endl;     //���zhangjian���˺ź����
    cout<<haha.getId()<<":"<<haha.getBalance()<<endl;       //���haha���˺ź����
    haha.moneyOut(20);  //��hahaȡǮ20
    cout<<haha.getId()<<":"<<haha.getBalance()<<endl;   //���zhangjian���˺ź����
    return 0;
}
