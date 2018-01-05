#include <iostream>
#include <stdlib.h>
const double PI=3.1415926;
class Circle{
public:
    Circle(double);
    double getArea();
protected:
    double r;
    double perimeter;
    double area,b_area;
    static double prosCheck(double value){
        if(value>0)
            return value;
        else{
            std::cerr<<"the value must bigger than 0! but yours is "<<value<<std::endl;
            exit(1);
        }
    }
};
Circle::Circle(double new_r){
    r=prosCheck(new_r);
    area=0;
    perimeter=0;
}
double Circle::getArea(){
    if(!area)
        area=PI*r*r;

    return area;
}

class Cylinder:public Circle{
public:
    Cylinder(double,double);
    double getArea();
    double getVolume();
protected:
    double h;
    double volume;
};
Cylinder::Cylinder(double new_r,double new_h):Circle(new_r){
    h=prosCheck(new_h);
    volume=0;
}
double Cylinder::getArea(){
    if(!area){
        double sArea;
        b_area=PI*r*r;
        perimeter=2*PI*r;
        sArea=perimeter*h;
        area=b_area*2+sArea;
    }

    return area;
}
double Cylinder::getVolume(){
    if(!volume&&getArea())
        volume=b_area*h;

    return volume;
}

int main(){
    Circle ci1(1);
    Cylinder cy1(2,2);
    std::cout<<cy1.getArea()<<std::endl;
    std::cout<<cy1.getVolume()<<std::endl;
    std::cout<<ci1.getArea();
    exit(0);
}
