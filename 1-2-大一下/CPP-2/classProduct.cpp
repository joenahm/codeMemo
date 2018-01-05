#include <iostream>
using namespace std;

class Product{  //定义类Product
private:        //声明属性：名称、价格、数量
    char name[20];
    int price;
    int quantity;
public:         //声明方法：购买、获取信息
    Product(char*,int,int);
   // ~Product();
    void buy(int);
    void get() const;
};
Product::Product(char* iName="the great gatsby",int iPrice=10,int iQuantity=50){//定义构造函数：把接受到的三个信息赋值给三个属性
    int i=0;
    while(name[i]=iName[i])
        i++;
    price=iPrice;
    quantity=iQuantity;
}
void Product::buy(int money){//定义购买方法：如果钱数大于价格，那么数量值就减去钱数和价格的商
    if(money>0&&money>=price)
        quantity-=money/price;
}
void Product::get()const{//定义获取信息方法：打印书名以及剩余数量
    cout<<name<<endl<<"quantity:"<<quantity<<endl;
}

int main(){
    Product p1; //实例化1个对象：p1
    p1.buy(10); //花10元去购买
    p1.get();   //获取商品信息
    p1.buy(25); //花25元去购买
    p1.get();   //获取商品信息

    return 0;
}
