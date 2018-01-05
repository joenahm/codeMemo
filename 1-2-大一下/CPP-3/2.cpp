#include <iostream>
using namespace std;
class Animal{
public:
	Animal(){species="Animal";cout<<"Animal 1 ctor"<<endl;}
	Animal(const char* s){species=s;cout<<"Animal 2 ctor"<<endl;}
private:
	string species;
};
class Primate:public Animal{
public:
	Primate():Animal("Primate"){cout<<"Primate 1 ctor"<<endl;}
	Primate(int n):Animal("Primate"){heart_cham=n;cout<<"Primate 2 ctor"<<endl;}
private:
	int heart_cham;
};
class Human:public Primate{
public:
	Human():Primate(){cout<<"Human 1 ctor"<<endl;}
	Human(int c):Primate(c){cout<<"Human 2 ctor"<<endl;}
};
int main(){
	Human Tom;
	Human Jack(4);

	return 0;
}
