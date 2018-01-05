#include <iostream>
#include <stdlib.h>
#include <cmath>
double st(double a,double b,double c){
	double m,s;
	m=(a+b+c)/2;
	s=sqrt(m*(m-a)*(m-b)*(m-c));

	return s;
}
using namespace std;
class Shape{
protected:
  double square;
public:
  Shape():square(0){}
  virtual void Show()=0;
  virtual void Area()=0;
};
class Triangle:public Shape{
private:
  double l1,l2,l3;
public:
  Triangle(double L1,double L2,double L3){
    if(L1>0&&L2>0&&L3>0){
      l1=L1;
      l2=L2;
      l3=L3;
    }else{
      cerr<<"error:(L) must bigger than 0 !"<<endl;
      exit(1);
    }
    square=st(l1,l2,l3);
  }
  void Show(){
    cout<<"l1:"<<l1<<",l2:"<<l2<<",l3:"<<l3<<endl;
    cout<<"square:"<<square<<endl;
  }
  void Area(){
    cout<<"square:"<<square<<endl;
  }
};
class Rectangle:public Shape{
private:
  double l1,l2;
public:
  Rectangle(double L1,double L2){
    if(L1>0&&L2>0){
      l1=L1;
      l2=L2;
    }else{
      cerr<<"error:(L) must bigger than 0 !"<<endl;
      exit(2);
    }
    square=l1*l2;
  }
  void Show(){
    cout<<"l1:"<<l1<<",l2:"<<l2<<endl;
    cout<<"square:"<<square<<endl;
  }
  void Area(){
    cout<<"square:"<<square<<endl;
  }
};
class Circle:public Shape{
private:
  double r;
public:
  Circle(double R){
    if(R>0)
      r=R;
    else{
      cerr<<"error:(R) must bigger than 0 !"<<endl;
      exit(3);
    }
    square=3.1415926*r*r;
  }
  void Show(){
    cout<<"r:"<<r<<endl;
    cout<<"square:"<<square<<endl;
  }
  void Area(){
    cout<<"square:"<<square<<endl;
  }
};
int main(){
    cout<<"5.exe"<<endl;
  Shape* t1=new Triangle(3,4,5);
  t1->Area();
  Rectangle r1(4,5);
  Shape& R1=r1;
  R1.Show();
  Shape* c1=new Circle(1);
  c1->Show();
  exit(0);
}
