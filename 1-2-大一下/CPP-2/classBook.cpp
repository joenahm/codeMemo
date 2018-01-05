#include <iostream>
using namespace std;

class Book{ //定义类Book
private:    //声明属性：书名、价格、数量
    string bookname;
    double price;
    int number;
public:     //声明方法：构造函数、显示信息方法、借书方法、还书方法
    Book(string,double,int);
    void display(void);
    void borrow(void);
    void restore(void);
};
/*方法的实现开始*/
Book::Book(string iBookname="人生有何意义",double iPrice=32.0,int iNumber=10){
    bookname=iBookname;
    price=iPrice;
    number=iNumber;
}
void Book::display(void){
    cout<<"名称："<<bookname<<endl<<"价格："<<price<<"元"<<endl<<"数量："<<number<<endl;
}
void Book::borrow(void){
    number--;
    cout<<"数量："<<number<<endl;
}
void Book::restore(void){
    number++;
    cout<<"数量："<<number<<endl;
}
/*方法的实现结束*/

int main(){
    Book b1;    //实例化书b1
    b1.display();   //显示b1信息
    b1.borrow();    //借书
    b1.restore();   //还书

    return 0;
}
