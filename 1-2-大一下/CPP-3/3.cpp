#include <iostream>
using namespace std;
class Person{
public:
    Person(unsigned in_id=0,string in_name="no_name"):id(in_id),name(in_name){};
    virtual void setInfo(){};
    virtual void display(){};
protected:
    unsigned id;
    string name;
};

class Student:public Person{
public:
    Student(unsigned in_id=0,string in_name="no_name"):Person(in_id,in_name),kurasu(0),grade(0){};
    void setInfo(unsigned,unsigned);
    void display();
private:
    unsigned kurasu;
    unsigned grade;
};
void Student::setInfo(unsigned new_kurasu,unsigned new_grade){
    kurasu=new_kurasu;
    grade=new_grade;
}
void Student::display(){
    cout<<"id:"<<id<<endl<<"name:"<<name<<endl<<"class:"<<kurasu<<endl<<"grade:"<<grade<<endl<<endl;
}

class Teacher:public Person{
public:
    Teacher(unsigned in_id=0,string in_name="no_name"):Person(in_id,in_name),title("no_title"),department("no_department"){};
    void setInfo(string,string);
    void display();
private:
    string title;
    string department;
};
void Teacher::setInfo(string new_title,string new_department){
    title=new_title;
    department=new_department;
}
void Teacher::display(){
    cout<<"id:"<<id<<endl<<"name:"<<name<<endl<<"title:"<<title<<endl<<"department:"<<department<<endl<<endl;
}

int main(){
    Student s1(201607369,"张健");
    s1.setInfo(4,23);
    s1.display();
    Teacher t1(201101011,"老王");
    t1.setInfo("班主任","计算机学院");
    t1.display();
    return 0;
}
