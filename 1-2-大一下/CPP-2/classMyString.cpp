#include <iostream>
#include <cstring>
using namespace std;

class MyString{
private:
    char* str;
    bool st;
public:
    MyString(char*);
    MyString(const MyString&,const MyString&);
    ~MyString();
    char* getStr(void);
};
MyString::MyString(char* s=0){
    str=s;
    cout<<str<<endl;
    st=0;
}
MyString::MyString(const MyString& s1,const MyString& s2){
    int oldLen,newLen;
    oldLen=strlen(s1.str);
    newLen=strlen(s2.str);
    int len=oldLen+newLen+1;
    cout<<len<<endl;
    char* temp=new char[len];
    int i=0,j=0;
    while(temp[i]=s1.str[i])
        i++;
    while(temp[i]=s2.str[j]){
        i++;
        j++;
    }
    str=temp;
    st=1;
}
MyString::~MyString(){
    if(st)
        delete[] str;
}
char* MyString::getStr(void){
    return str;
}

int main(){
    MyString s1("aaa"),s2("bbb");
    MyString s3(s1,s2);
    cout<<s3.getStr()<<endl;
    return 0;
}
