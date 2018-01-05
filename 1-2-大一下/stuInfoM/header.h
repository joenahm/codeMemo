#ifndef HEADER_H_INCLUDED
#define HEADER_H_INCLUDED

#include <iostream>
#include <fstream>
#include <iomanip>
#include <vector>
#include <stdlib.h>

using namespace std;

const int PUPIL=0;
const int JUNIOR=1;
const int SENIOR=2;
const int ALL=3;

const int ID=11;
const int AGE=12;
const int MARKEN=13;
const int MARKMATH=14;
const int MARKCN=15;
const int MARKGEO=16;
const int MARKHIS=17;
const int MARKPGM=18;
const int MARKHM=19;

const int NAME=51;
const int SEX=52;
const int KURASU=53;
const int MAJOR=54;




class Student{
protected:
    unsigned id;
    string name;
    string sex;
    unsigned age;
    string kurasu; //class
public:
    Student(unsigned Id,string Name,string Sex,unsigned Age,string Kurasu);
    unsigned getId();
    string getName();
    string getSex();
    unsigned getAge();
    string getKurasu();
    virtual unsigned getMarkEn(){}
    virtual unsigned getMarkMath(){}
    virtual unsigned getMarkCn(){}
    virtual unsigned getMarkGeo(){}
    virtual unsigned getMarkHis(){}
    virtual unsigned getMarkPgm(){}
    virtual unsigned getMarkHm(){}
    virtual string getMajor(){}
    virtual int get(){}
};

class Pupil:public Student{
protected:
    unsigned markEn;
    unsigned markMath;
    unsigned markCn;
public:
    Pupil(unsigned Id,string Name,string Sex,unsigned Age,string Kurasu,unsigned En,unsigned Math,unsigned Cn);
    virtual unsigned getMarkEn();
    unsigned getMarkMath();
    unsigned getMarkCn();
    virtual int get();
};

class Junior:public Pupil{
private:
    unsigned markGeo;
    unsigned markHis;
public:
    Junior(unsigned Id,string Name,string Sex,unsigned Age,string Kurasu,unsigned En,unsigned Math,unsigned Cn,unsigned Geo,unsigned His);
    unsigned getMarkGeo();
    unsigned getMarkHis();
    virtual int get();
};

class Senior:public Student{
private:
    string major;
    unsigned markEn;
    unsigned markPgm;
    unsigned markHm;
public:
    Senior(unsigned Id,string Name,string Sex,unsigned Age,string Kurasu,string Major,unsigned En,unsigned Pgm,unsigned Hm);
    string getMajor();
    virtual unsigned getMarkEn();
    unsigned getMarkPgm();
    unsigned getMarkHm();
    virtual int get();
};

void tabHead(int type);  //��ӡ��ͷ
void printInfo(Student* iOne,int type);  //��ӡ�����̶�����ѧ����Ϣ
void searchInfo(int type,int key,unsigned value);  //���ҵ����̶�����ѧ����Ϣ
void searchInfo(int type,int key,string value);  //���ҵ����̶�����ѧ����Ϣ
vector <Student*> getInfo(int type,unsigned value);  //��ȡ����ѧ����Ϣ
vector <Student*> getInfo(int type,string value);  //��ȡ����ѧ����Ϣ
void allInfo();  //��ӡȫ����Ϣ
void statNum(int type);  //ͳ��ѧ������
void stat(int type,unsigned id);  //ͳ�Ƹ����ܷ�
void stat(int type,string name); //ͳ�Ƹ����ܷ�
void stat(int type);  //ͳ�Ƶ���ƽ����

vector <Student*> sortSingle(int type,int way);  //�����Ƴɼ�����
vector <Student*> sortAll(int type);  //���ܳɼ�����
vector <Student*> readInfo(int type);  //���ļ���ȡ�ض����͵ĵ���ѧ�����ݻ���Ϊvector <Student*>
void writeInfo(int type,Student* stu);  //���ļ�д���ض����͵ĵ���ѧ������
Student* insertInfo(int type);  //����������ض����͵�ѧ������
void delInfo(int type,unsigned id);  //��ѧ��ɾ��ѧ������

#endif // HEADER_H_INCLUDED
