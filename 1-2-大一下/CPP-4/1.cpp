/*with time-format check*/
#include <iostream>
#include <stdlib.h>
using namespace std;
class Time{
private:
	int h,m,s;
public:
	Time(int H=0,int M=0,int S=0){
		if(H>=0&&H<24){
			h=H;
		}else{
			cerr<<"error:(H)invalid input!"<<endl;
			exit(1);
		}

		if(M>=0&&M<60){
			m=M;
		}else{
			cerr<<"error:(M)invalid input!"<<endl;
			exit(2);
		}
		
		if(S>=0&&S<60){
			s=S;
		}else{
			cerr<<"error:(S)invalid input!"<<endl;
			exit(3);
		}
	}
	Time(const Time& t){
		h=t.h;
		m=t.m;
		s=t.s;
	}
	Time operator+(const Time& t){
		Time temp(h,m,s);
		temp.h+=t.h;
		temp.m+=t.m;
		temp.s+=t.s;
		if(temp.s>=60){
			temp.m++;
			temp.s-=60;
		}	

		if(temp.m>=60){
			temp.h++;
			temp.m-=60;
		}

		if(temp.h>=24){
			temp.h-=24;
		}

		return temp;
	}
	Time operator-(const Time& t){
		Time temp(h,m,s);
		temp.h-=t.h;
		temp.m-=t.m;
		temp.s-=t.s;

		return temp;
	}
	void setTime(int H,int M,int S){
		Time temp(H,M,S);
		h=temp.h;
		m=temp.m;
		s=temp.s;
	}
	friend void getTime(const Time&);	
};
void getTime(const Time& t){
	cout<<t.h<<":"<<t.m<<":"<<t.s<<endl;
}
int main(){
	Time t1(10,30,0);
	Time t2(3,0,0);
	Time t3=t1-t2;
	getTime(t3);
	t3.setTime(11,11,0);
	getTime(t3);

	exit(0);
}
