#include <iostream>
using namespace std;
class A{
public:
	A(){cout<<"A"<<endl;}
	A(int i){a=i;cout<<"a="<<a<<endl;}
private:
	int a;
};
class B:virtual public A{
public:
	B(){cout<<"B"<<endl;}
	B(int j){b=j;cout<<"b="<<b<<endl;}
private:
	int b;
};
class C:virtual public A{
public:
	C(){cout<<"C"<<endl;}
	C(int k){c=k;cout<<"c="<<c<<endl;}
private:
	int c;
};
class D:public B,public C{
public:
	D(){}
	D(int i,int j,int k):A(i),B(j),C(k){}
};
int main(){
	D d1,d2(1,2,3);	

	return 0;
}
