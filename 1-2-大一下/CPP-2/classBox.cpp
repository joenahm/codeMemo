#include <iostream>
using namespace std;

class Box{  //定义Box类
private:    //声明属性：边长、体积、面积
    double a;
    double volume;
    double area;
public:     //声明方法：两类构造函数、改边长方法、求体积方法、求面积方法、显示方法
    Box(void);
    Box(double);
    void seta(double);
    void getvolume(void);
    void getarea(void);
    void disp(void);
};
Box::Box(void){ //没有给值时，给3个属性初始化为0
    a=volume=area=0.0;
}
Box::Box(double iA){//有值时，给边长赋值，并把体积面积初始化为0
    a=iA;
    volume=area=0.0;
}
void Box::seta(double val){
    a=val;
}
void Box::getvolume(void){//求体积算法
    volume=a*a*a;
}
void Box::getarea(void){//求面积算法
    area=6*a*a;
}
void Box::disp(void){//输出体积及面积
    cout<<"体积："<<volume<<endl<<"表面积："<<area<<endl;
}
int main(){
    Box b1,b2(5);   //实例化两个对象：b1，b2；一个不赋初值一个不
    b1.seta(3.2);   //给b1设置边长
    b1.getvolume(); //获取b1体积
    b1.getarea();   //获取b1面积
    b1.disp();      //显示b1信息
    b2.getvolume(); //获取b2体积
    b2.getarea();   //获取b2面积
    b2.disp();      //显示b2信息
    return 0;
}
