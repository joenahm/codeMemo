#include <iostream>
#include <stdlib.h>
#include <vector>
#include <fstream>
using namespace std;
vector <int> sort(vector <int> val){
	int temp=0;
	for(int i=0;i<val.size();i++){
		for(int j=i+1;j<val.size();j++){
			if(val[i]>val[j]){
				temp=val[i];
				val[i]=val[j];
				val[j]=temp;
			}
		}
	}

	return val;
}
int main(){
	int buf;
	
	vector <int> inVal;
	
	cout<<"iostream version:"<<endl;
	while(cin>>buf){
		inVal.push_back(buf);
	}
	inVal=sort(inVal);
	for(int i=0;i<inVal.size();i++)
		cout<<inVal[i]<<" ";
	cout<<endl;

	cout<<"fstream version:"<<endl<<"out.txt"<<endl;
	ifstream inF("in.txt");
	ofstream outF("out.txt");
	vector <int> inFVal;
	while(!inF.eof()){
	  inF>>buf;
	  inFVal.push_back(buf);
	}
	inFVal.pop_back();
	inFVal=sort(inFVal);
	for(int i=0;i<inFVal.size();i++)
	  outF<<inFVal[i]<<endl;
	inF.close();
	outF.close();

	return 0;
}
