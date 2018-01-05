#include <iostream>
using namespace std;
int isLeap(int year){
	if((year%4==0)&&(year%100!=0)||(year%400==0))
		return 1;
	else
		return 0;
}
int main(){
	int year,month,day,rst=0;
	int monDay[12]={31,28,31,30,31,30,31,31,30,31,30,31};
	cout<<"year:";
	cin>>year;
	if(isLeap(year))
		monDay[1]=29;
	cout<<"month:";
	cin>>month;
	for(int i=0;i<(month-1);i++)
		rst+=monDay[i];
	cout<<"day:";
	cin>>day;
	rst+=day;
	cout<<rst<<endl;

	return 0;
}
