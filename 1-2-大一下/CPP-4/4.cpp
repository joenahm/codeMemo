#include <iostream>
using namespace std;
class A{
public:
	A(int i){x=i;}
	A(){}
	//void disp()=0;
	virtual void disp()=0; //ֻ�д��麯�����ܲ���������
//private:
protected: //private���͵����Բ��ܱ�����̳�ʹ��
	int x;
};
class B:public A{
public:
	B(int i,int j):A(i),y(j){}
	void disp(){cout<<"x="<<x<<"  y="<<y<<endl;}
private:
	int y;
};
class C:public A{
public:
	C(int i,int j):A(i),z(j){}
	void disp(){cout<<"x="<<x<<"  z="<<z<<endl;}
private:
	int z;
};
int main(){
	//A a(1); �����಻��ʵ����
	B b(2,3);
	C c(2,4);
	A *p[3]={&b,&c};
	for(int i=0;i<2;i++)
        p[i]->disp();
	return 0;
}
