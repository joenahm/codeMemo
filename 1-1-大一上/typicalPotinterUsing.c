#include <stdio.h>

#define STRA 10
#define MAXSIZE 100

char* strCmp(char*,char*);
char* strMax(char (*)[MAXSIZE]);
void strSort(char (*)[MAXSIZE]);

int main(){
    char str[STRA][MAXSIZE];
    int i=0,k=0;
    char c;
    for(i=0;i<STRA;i++){
        k=0;
        while((c=getchar())!='\n'){
            str[i][k]=c;
            k++;
        }
        str[i][k]='\0';
    }
    strSort(str);
    for(i=0;i<STRA;i++)
        printf("%s ",str[i] );
    putchar('\n');
    printf("MAX:%s\n",strMax(str));
    return 0;
}

char* strCmp(char *a,char *b){
    int i=0,j=0;
    while(*(a+i)!='\0'){
        i++;
    }
    while(*(b+j)!='\0'){
        j++;
    }
    if(i>j)
        return a;
    else
        return b;
}

char* strMax(char (*a)[MAXSIZE]){
    char (*b)[MAXSIZE];
    int i=0;
    b=a;
    for(i=1;i<STRA;i++){
         b=(char (*)[MAXSIZE])strCmp((char*)b,(char*)(a+i));
    }
    return (char*)b;
}
void strSort(char (*a)[MAXSIZE]){
    int i=0,j=0,k=0;
    char *b=NULL,c[MAXSIZE];
    for(i=0;i<STRA;i++){
        for(j=i+1;j<STRA;j++){
            b=strCmp(a+i,a+j);
            if(b==a+i){
                while((c[k]=a[i][k])!='\0'){
                  k++;
                }
                k=0;
                // while(c[k]!='\0'){
                    // printf("c:%c ",c[k]);
                    // k++;
                // }
                // k=0;
                while(((a[i][k]=a[j][k])!='\0')&&k<MAXSIZE){
                    // printf("%c",a[i][k]);
                    k++;
                }
                // putchar('\n');
                k=0;
                while(((a[j][k]=c[k])!='\0')&&k<MAXSIZE){
                    // printf("jk:%c ",a[j][k]);
                    k++;
                }
                // putchar('\n');
                k=0;
            }
        }
    }
}