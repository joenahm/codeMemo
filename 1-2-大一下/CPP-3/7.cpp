#include <iostream>
#include <stdlib.h>
using namespace std;
class vehicle{
public:
    vehicle(int in_wheels,double in_weight){
        if(in_wheels>0&&in_weight>0){
            wheels=in_wheels;
            weight=in_weight;
        }else{
            cerr<<"wheels and weight must bigger than 0!"<<endl;
            exit(1);
        }
    }
    int getWheelNum(){return wheels;}
    double getWeight(){return weight;}
protected:
    int wheels;
    double weight;
};
class car:public vehicle{
public:
    car(int new_wheels,double new_weight,int new_passerNum):vehicle(new_wheels,new_weight){
        if(new_passerNum>0)
            passerNum=new_passerNum;
        else{
            cerr<<"the number of passagers must bigger than 0!"<<endl;
            exit(2);
        }
    }
    void disp(){
        cout<<vehicle::getWheelNum()<<" wheels"<<endl<<vehicle::getWeight()<<"kg"<<endl<<passerNum<<"-people-limited"<<endl;
    }
private:
    int passerNum;
};
class truck:public vehicle{
public:
    truck(int new_wheels,double new_weight,int new_passerNum,double new_loadCap):vehicle(new_wheels,new_weight){
        if(new_passerNum>0&&new_loadCap>0){
            passerNum=new_passerNum;
            loadCap=new_loadCap;
        }
        else{
            cerr<<"the number of passagers and the loading capacity must bigger than 0!"<<endl;
            exit(3);
        }
    }
    void disp(){
        cout<<vehicle::getWheelNum()<<" wheels"<<endl<<vehicle::getWeight()<<"kg"<<endl<<passerNum<<"-people-limited"<<endl<<"loading capacity:"<<loadCap<<"kg"<<endl;
    }
private:
    int passerNum;
    double loadCap;
};
int main(){
    car c1(4,1000,5);
    c1.disp();
    truck t1(6,10000,2,2000);
    t1.disp();
    exit(0);
}
