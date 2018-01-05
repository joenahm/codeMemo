/*
题目描述

Your task is to Calculate the sum of some integers.
输入

Input contains multiple test cases. Each test case contains a integer N, and then N integers follow in the same line. A test case starting with 0 terminates the input and this test case is not to be processed.
输出

For each group of input integers you should output their sum in one line, and with one line of output for each line in input.
样例输入

4 1 2 3 4
5 1 2 3 4 5
0 
样例输出

10
15

 */
#include <stdio.h>
int main(){
	int a=0,c=0,i,s=0;
	
	while(scanf("%d",&a)!=EOF){
		if(a!=0){
			for(i=0;i<a;i++){
				scanf("%d",&c);
				s+=c;
			}
			printf("%d\n",s);
			s=0;
		}else{
			break;
		}	
	}
	
	return 0;
}