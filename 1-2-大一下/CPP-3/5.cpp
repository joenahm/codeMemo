#include <iostream>
using namespace std;
class Mammal{
public:
    Mammal():itsAge(2),itsWeight(5){
        cout<<"Mammal constructor..."<<endl;
    }
    ~Mammal(){cout<<"Mammal destructor..."<<endl;}
    int GetAge()const{return itsAge;}
    void SetAge(int age){itsAge=age;}
    int GetWeight()const{return itsWeight;}
    void SetWeight(int weight){itsWeight=weight;}
    void Move(){cout<<"moving.."<<endl;}
    virtual void Speak(){cout<<"speaking.."<<endl;}
    void Sleep(){cout<<"sleeping.."<<endl;}
protected:
    int itsAge;
    int itsWeight;
};
class Dog:public Mammal{
public:
    Dog(string in_type):Mammal(),type(in_type){}
    void Speak(){cout<<"woof!"<<endl;}
    void tWag(){cout<<"tail wagging~"<<endl;}
    void fBeg(){cout<<"begging for food~"<<endl;}
private:
    string type;
};
int main(){
    Dog d1("husky");
    d1.Speak();
    d1.tWag();
    d1.fBeg();

    return 0;
}
