#include <iostream>
using namespace std;
int* arrSort(int* arr,int arrLen){
    for(int i=0;i<arrLen;i++){
         for(int j=i+1;j<arrLen;j++){
            int exc=0;
            if(arr[i]>arr[j]){
                exc=arr[i];
                arr[i]=arr[j];
                arr[j]=exc;
            }
         }
    }

    return arr;
}
float* arrSort(float* arr,int arrLen){
    for(int i=0;i<arrLen;i++){
         for(int j=i+1;j<arrLen;j++){
            float exc=0.0;
            if(arr[i]>arr[j]){
                exc=arr[i];
                arr[i]=arr[j];
                arr[j]=exc;
            }
         }
    }

    return arr;
}
char* arrSort(char* arr,int arrLen){
    for(int i=0;i<arrLen;i++){
         for(int j=i+1;j<arrLen;j++){
            char exc=0;
            if(arr[i]>arr[j]){
                exc=arr[i];
                arr[i]=arr[j];
                arr[j]=exc;
            }
         }
    }

    return arr;
}
string* arrSort(string* arr,int arrLen){
    for(int i=0;i<arrLen;i++){
         for(int j=i+1;j<arrLen;j++){
            string exc;
            if(arr[i].length()>arr[j].length()){
                exc=arr[i];
                arr[i]=arr[j];
                arr[j]=exc;
            }
         }
    }

    return arr;
}
int main(){
    float a[5];
    for(int i=0;i<5;i++)
        cin>>a[i];
    for(int i=0;i<5;i++)
        cout<<*(arrSort(a,5)+i)<<" ";
    return 0;
}
