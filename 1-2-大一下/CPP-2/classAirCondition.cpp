#include <iostream>
using namespace std;
class airCondition{ //������airCondition
private:    //�������ԣ�brand��color��power��state��temp
	string brand;
	string color;
	int power;
	enum {OFF,ON}state;
	int temp;
public: //�������������캯�������ؿյ������¡�����
	airCondition(string,string,int,int);
	void sw(void);
	void tempUp(int);
	void tempDown(int);
};
/*����ʵ�ֿ�ʼ*/
airCondition::airCondition(string iBrand="����",string iColor="��ɫ",int iPower=2,int iTemp=25){
	cout<<"�յ���Ϣ��"<<endl;
	cout<<"Ʒ�ƣ�"<<(brand=iBrand)<<endl;
	cout<<"��ɫ��"<<(color=iColor)<<endl;
	cout<<"���ʣ�"<<(power=iPower)<<"ƥ"<<endl;
	cout<<"�¶ȣ�"<<(temp=iTemp)<<"��"<<endl;
	state=OFF;
}
void airCondition::sw(void){
	if(state){
		state=OFF;
		cout<<"�յ��ѹرգ�"<<endl;
	}
	else{
		state=ON;
		cout<<"�յ��Ѵ򿪣�"<<endl;
	}
}
void airCondition::tempUp(int val=1){
	temp+=val;
	cout<<"�¶ȣ�"<<temp<<"��"<<endl;
}
void airCondition::tempDown(int val=1){
	temp-=val;
	cout<<"�¶ȣ�"<<temp<<"��"<<endl;
}
/*����ʵ�ֽ���*/
int main(){
	airCondition cooler1;   //ʵ����cooler1
	cooler1.sw();   //�򿪿յ�
	cooler1.tempDown(5);    //����5��
	return 0;
}
