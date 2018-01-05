#include <iostream>
using namespace std;

class Student{  //������Student
private:    //�������ԣ�id��name��grade
    int id;
    string name;
    double grade;
public:     //������������ʾ��Ϣ����ȡ�ɼ�
    Student(int,string,double);
    void showInfo(void);
    double getGrade(void);
};
/*����ʵ�ֿ�ʼ*/
Student::Student(int iId=0,string iName="������",double iGrade=0.0):id(iId),name(iName),grade(iGrade){}
void Student::showInfo(void){
    cout<<"ѧ�ţ�"<<id<<endl<<"������"<<name<<endl<<"������"<<grade<<endl<<endl;
}
double Student::getGrade(void){
    return grade;
}
/*����ʵ�ֽ���*/
void Sort(Student stu[],int arrLen){    //����������
    for(int i=0;i<arrLen;i++){
         for(int j=i+1;j<arrLen;j++){
            Student exc;
            if(stu[i].getGrade()>stu[j].getGrade()){
                exc=stu[i];
                stu[i]=stu[j];
                stu[j]=exc;
            }
         }
    }
}

int main(){
    Student s[5]={Student(369,"�Ž�",43),Student(),Student(211,"����",80.5),Student(985,"����",50),Student(111,"����",90)}; //ʵ������������
    Sort(s,5);  //����
    for(int i=0;i<5;i++){   //������
            s[i].showInfo();
    }
    return 0;
}
