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
class Triangle{
private:
	double l1,l2,l3;
	double square;
public:
	Triangle(double L1=1,double L2=1,double L3=1){
		if(L1>0&&L2>0&&L3>0){
			l1=L1;
			l2=L2;
			l3=L3;
		}else{
			cerr<<"error:(L) must bigger than 0 !"<<endl;
		}
		square=st(l1,l2,l3);
	}
	Triangle(const Triangle& t){
		l1=t.l1;
		l2=t.l2;
		l3=t.l3;
		square=t.square;
	}
	void getSquare() const{
		cout<<square<<endl;
	}
	friend Triangle operator+(const Triangle&,const Triangle&);
};
Triangle operator+(const Triangle& t1,const Triangle& t2){
	Triangle temp;
	temp.l1=t1.l1+t2.l1;
	temp.l2=t1.l2+t2.l2;
	temp.l3=t1.l3+t2.l3;
	temp.square=t1.square+t2.square;

	return temp;
}
int main(){
	Triangle t1(6,8,10),t2(3,4,5);
	t1.getSquare();
	Triangle t3;
	t3=t1+t2;
	t3.getSquare();

	return 0;
}
