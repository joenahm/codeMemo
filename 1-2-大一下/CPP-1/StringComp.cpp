#include <iostream>
#include <string>
using namespace std;
int main(){
    string str[5];
    cout<<"C++ style version-"<<endl;
    for(int i=0;i<5;i++){
        cin>>str[i];
    }
    for(int i=1;i<5;i++){
        if(str[0].length()<str[i].length()){
            string exc;
            exc=str[0];
            str[0]=str[i];
            str[i]=exc;
        }
    }
    for(int i=3;i>=0;i--){
        if(str[4].length()>str[i].length()){
            string exc;
            exc=str[4];
            str[4]=str[i];
            str[i]=exc;
        }
    }
    cout<<endl<<"max:"<<str[0]<<endl;
    cout<<endl<<"min:"<<str[4]<<endl;
    return 0;
}
