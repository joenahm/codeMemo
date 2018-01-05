#include <iostream>
using namespace std;
struct Student{
    int num;
    string name;
    string sex;
    float grade;
};
float average(Student* pstu){
    float totGrade=0;
    for(int i=0;i<5;i++)
        totGrade+=pstu[i].grade;
    return totGrade/5;
}
int main(){
    Student stu[5];
    for(int i=0;i<5;i++){
        cout<<"num:";
        cin>>stu[i].num;
        cout<<"name:";
        cin>>stu[i].name;
        cout<<"sex:";
        cin>>stu[i].sex;
        cout<<"grade:";
        cin>>stu[i].grade;
    }
    cout<<"average grade:"<<average(stu)<<endl;
    int fNum=0;
    for(int i=0;i<5;i++){
        if(stu[i].grade<60)
            fNum++;
    }
    cout<<"failed number:"<<fNum<<endl;
    return 0;
}
