#include <iostream>
#include <cmath>
using namespace std;

class Point{    //������Point
private:        //�������ԣ�x,y
    double x;
    double y;
public:         //�������������캯�������
    Point(double,double);
    void distance(Point);
};
Point::Point(double iX,double iY){  //���幹�캯����������������ֵ����������
    x=iX;
    y=iY;
}
void Point::distance(Point p){  //����distance������������ʱ����dis�����Ա�����㴫�����pͬ��ǰ��ľ��룬Ȼ���ӡdis
    double dis;
    dis=sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
    cout<<"distance:"<<dis<<endl;
}

int main(){
    Point p1(3,0),p2(0��4);  //ʵ���������㣺��3��0������0��4��
    p1.distance(p2);        //����p1��distance������������벢���
    return 0;
}
