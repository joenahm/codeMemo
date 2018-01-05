#include <iostream>
#include <cmath>
using namespace std;

class Point{    //定义类Point
private:        //声明属性：x,y
    double x;
    double y;
public:         //声明方法：构造函数、测距
    Point(double,double);
    void distance(Point);
};
Point::Point(double iX,double iY){  //定义构造函数：把两个参数赋值给两个属性
    x=iX;
    y=iY;
}
void Point::distance(Point p){  //定义distance方法：声明临时变量dis，用以保存计算传入对象p同当前点的距离，然后打印dis
    double dis;
    dis=sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
    cout<<"distance:"<<dis<<endl;
}

int main(){
    Point p1(3,0),p2(0，4);  //实例化两个点：（3，0）、（0，4）
    p1.distance(p2);        //调用p1的distance方法测两点距离并输出
    return 0;
}
