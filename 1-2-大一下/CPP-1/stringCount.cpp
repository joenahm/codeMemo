#include <iostream>
#include <string>
using namespace std;
struct Info{
	int letter,number,blank,other;
};
Info strCount(string str){
	int i=0;
	Info strInfo;
	strInfo.letter=0;
	strInfo.number=0;
	strInfo.blank=0;
	strInfo.other=0;

	char* cStr=(char*)str.c_str();
	while(cStr[i]){
		if((cStr[i]>='a'&&cStr[i]<='z')||(cStr[i]>='A'&&cStr[i]<='Z'))
			strInfo.letter++;
		else if(cStr[i]>='0'&&cStr[i]<='9')
			strInfo.number++;
		else if(cStr[i]==' ')
			strInfo.blank++;
		else
			strInfo.other++;
		i++;
	}

	return strInfo;
}
int main(){
	Info ss;
	string s="abxc  11!_";
	ss=strCount(s);
	cout<<"string:"<<s<<endl;
	cout<<"letter(s):"<<ss.letter<<endl;
	cout<<"number(s):"<<ss.number<<endl;
	cout<<"blank(s):"<<ss.blank<<endl;
	cout<<"other(s):"<<ss.other<<endl;
	return 0;
}
