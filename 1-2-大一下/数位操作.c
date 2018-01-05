#include <stdio.h>
#include <stdlib.h>
int crash(int val,int key){
	int vals[100],length=0,res=0,temp=1;
	int i=0,j=0;
	while(val){
		if(i<100){
			vals[i]=val-val/10*10;
			val/=10;
			i++;
		}else{
			fprintf(stderr,"error:too much for [array]vals to store!\n");  
			exit(1);
		}
	}
	length=i;
	if(key>length){
		fprintf(stderr,"error:length beyond!\n");
		exit(2);
	}
	for(i=key;i<length;i++)
		vals[i-1]=vals[i];
	for(i=0;i<length-1;i++){
		temp=1;
		for(j=0;j<i;j++)
			temp*=10;
		res+=vals[i]*temp;
	}

	return res;
}
int main(int argc,const char* argv[]){
	printf("%d",crash(6548,3));
	return 0;	
}