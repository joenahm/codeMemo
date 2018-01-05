#include <iostream>
using namespace std;
class A{
public:
	A(int i,int j){a=i;b=j;}
	void move(int x,int y){a+=x;b+=y;}
	void show(){cout<<"("<<a<<","<<b<<")"<<endl;}
private:
	int a,b;
};
class B:private A{
public:
	B(int i,int j,int k,int l):A(i,j){x=k;y=l;}
	void show(){cout<<x<<","<<y<<endl;}
	void fun(){move(3,5);}
	void fl(){A::show();}
private:
	int x,y;
};
int main(){
	A e(1,2);
	e.show();
	B d(3,4,5,6);
	d.fun();
	d.show();
	d.fl();

	return 0;
}
