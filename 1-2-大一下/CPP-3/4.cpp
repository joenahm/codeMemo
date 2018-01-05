#include <iostream>
using namespace std;
class Point{
public:
    Point(int in_x=0,int in_y=0):x(in_x),y(in_y){}
    void setxy(int x0,int y0){x=x0;y=y0;}
    int getx(){return x;}
    int gety(){return y;}
protected:
    int x,y;
};
class Square:public Point{
public:
    Square(int new_x,int new_y,double new_a):Point(new_x,new_y),a(new_a){}
    double getS();
private:
    double a;
    double s;
};
double Square::getS(){
    s=a*a;
    return s;
}
int main(){
    Square s1(1,2,4);
    cout<<s1.getS()<<endl<<s1.getx()<<","<<s1.gety()<<endl;

    return 0;
}
