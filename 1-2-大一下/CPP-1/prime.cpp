#include <iostream>
using namespace std;
const int SIZE=1000;
int main(int argc, char const *argv[])
{
	int isS=1,num=0;
	for(int i=2;i<=SIZE;i++){
		for(int j=2;j<i;j++){
			if(!(i%j))
				isS=0;
		}
		if(isS){
			num++;
			cout<<i<<" ";
		}
		isS=1;
	}

	return 0;
}
