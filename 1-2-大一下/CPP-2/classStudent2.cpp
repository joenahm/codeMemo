#include <iostream>
using namespace std;

class Student{  //定义类Student
private:    //声明属性：id、name、grade
    int id;
    string name;
    double grade;
public:     //声明方法：显示信息、获取成绩
    Student(int,string,double);
    void showInfo(void);
    double getGrade(void);
};
/*方法实现开始*/
Student::Student(int iId=0,string iName="无名氏",double iGrade=0.0):id(iId),name(iName),grade(iGrade){}
void Student::showInfo(void){
    cout<<"学号："<<id<<endl<<"姓名："<<name<<endl<<"分数："<<grade<<endl<<endl;
}
double Student::getGrade(void){
    return grade;
}
/*方法实现结束*/
void Sort(Student stu[],int arrLen){    //定义排序函数
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
    Student s[5]={Student(369,"张健",43),Student(),Student(211,"张三",80.5),Student(985,"李四",50),Student(111,"老王",90)}; //实例化对象数组
    Sort(s,5);  //排序
    for(int i=0;i<5;i++){   //输出结果
            s[i].showInfo();
    }
    return 0;
}
