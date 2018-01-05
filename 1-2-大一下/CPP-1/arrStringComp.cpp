#include <iostream>
#include <string.h>
#include <stdio.h>
#include <string>
using namespace std;
int main(){
    char* cStr[5];
    string str[5];

    puts("C style version-\n");
    for(int i=0;i<5;i++){
        cin>>str[i];
    }
    for(int i=0;i<5;i++)
        cStr[i]=(char*)str[i].c_str();
    for(int i=1;i<5;i++){
            char* exc;
            if(strlen(cStr[0])<strlen(cStr[i])){
                exc=cStr[0];
                cStr[0]=cStr[i];
                cStr[i]=exc;
            }

    }
    for(int i=3;i>=0;i--){
            char* exc;
            if(strlen(cStr[4])>strlen(cStr[i])){
                exc=cStr[4];
                cStr[4]=cStr[i];
                cStr[i]=exc;
            }

    }
    puts("\nmax:");
    puts(cStr[0]);
    puts("min:");
    puts(cStr[4]);
    return 0;
}
