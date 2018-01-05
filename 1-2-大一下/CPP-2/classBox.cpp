#include <iostream>
using namespace std;

class Box{  //����Box��
private:    //�������ԣ��߳�����������
    double a;
    double volume;
    double area;
public:     //�������������๹�캯�����ı߳�������������������������������ʾ����
    Box(void);
    Box(double);
    void seta(double);
    void getvolume(void);
    void getarea(void);
    void disp(void);
};
Box::Box(void){ //û�и�ֵʱ����3�����Գ�ʼ��Ϊ0
    a=volume=area=0.0;
}
Box::Box(double iA){//��ֵʱ�����߳���ֵ��������������ʼ��Ϊ0
    a=iA;
    volume=area=0.0;
}
void Box::seta(double val){
    a=val;
}
void Box::getvolume(void){//������㷨
    volume=a*a*a;
}
void Box::getarea(void){//������㷨
    area=6*a*a;
}
void Box::disp(void){//�����������
    cout<<"�����"<<volume<<endl<<"�������"<<area<<endl;
}
int main(){
    Box b1,b2(5);   //ʵ������������b1��b2��һ��������ֵһ����
    b1.seta(3.2);   //��b1���ñ߳�
    b1.getvolume(); //��ȡb1���
    b1.getarea();   //��ȡb1���
    b1.disp();      //��ʾb1��Ϣ
    b2.getvolume(); //��ȡb2���
    b2.getarea();   //��ȡb2���
    b2.disp();      //��ʾb2��Ϣ
    return 0;
}
