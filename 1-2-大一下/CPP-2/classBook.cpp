#include <iostream>
using namespace std;

class Book{ //������Book
private:    //�������ԣ��������۸�����
    string bookname;
    double price;
    int number;
public:     //�������������캯������ʾ��Ϣ���������鷽�������鷽��
    Book(string,double,int);
    void display(void);
    void borrow(void);
    void restore(void);
};
/*������ʵ�ֿ�ʼ*/
Book::Book(string iBookname="�����к�����",double iPrice=32.0,int iNumber=10){
    bookname=iBookname;
    price=iPrice;
    number=iNumber;
}
void Book::display(void){
    cout<<"���ƣ�"<<bookname<<endl<<"�۸�"<<price<<"Ԫ"<<endl<<"������"<<number<<endl;
}
void Book::borrow(void){
    number--;
    cout<<"������"<<number<<endl;
}
void Book::restore(void){
    number++;
    cout<<"������"<<number<<endl;
}
/*������ʵ�ֽ���*/

int main(){
    Book b1;    //ʵ������b1
    b1.display();   //��ʾb1��Ϣ
    b1.borrow();    //����
    b1.restore();   //����

    return 0;
}
