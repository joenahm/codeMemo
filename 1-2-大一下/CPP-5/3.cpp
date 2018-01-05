#include <iostream>
#include <stdlib.h>
#include <fstream>
using namespace std;
int main(){
  ofstream outF("prime.txt");
  
  const int SIZE=1000;
  
  int isS=1,num=0;
  for(int i=2;i<=SIZE;i++){
    for(int j=2;j<i;j++){
      if(!(i%j))
	isS=0;
    }
    if(isS){
      num++;
      if(i/10==0){
	for(int i=0;i<6;i++)
	  outF<<" ";
      }else if(i/100==0){
	for(int i=0;i<5;i++)
	  outF<<" ";
      }else{
	for(int i=0;i<4;i++)
	  outF<<" ";
      }
      outF<<i;
      if(num%10==0)
	outF<<endl;
    }
    isS=1;
  }
  outF<<endl;
  
  return 0;
}
