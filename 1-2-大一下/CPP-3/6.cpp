#include <iostream>
#include <stdlib.h>
const double PI=3.1415926;
using namespace std;
class circle{
public:
    circle(double in_r){
        if(in_r<=0){
            cerr<<"error:r must bigger than 0!"<<endl;
            exit(1);
        }
        else{
            r=in_r;
            square=PI*r*r;
        }
    }
    double getSquare(){return square;}
protected:
    double r;
    double square;
};
class table{
public:
    table(double in_height,string in_color):height(in_height),color(in_color){}
    double getHeight(){return height;}
    string getColor(){return color;}
protected:
    double height;
    string color;
};
class roundtable:public circle,public table{
public:
    roundtable(double new_r,double new_height,string new_color):circle(new_r),table(new_height,new_color){}
    void disp(){
        cout<<"square:"<<circle::getSquare()<<endl<<"height:"<<table::getHeight()<<endl<<"color:"<<table::getColor()<<endl;
    }
};
int main(){
    roundtable rt1(2,10.2,"white");
    rt1.disp();
    exit(0);
}
