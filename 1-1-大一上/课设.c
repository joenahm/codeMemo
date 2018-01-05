#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <math.h>

#define MAXSIZE 200

void Translate(const char str[], char exp[]);//ת��Ϊ�沨�����ʽ 
double CompValue(const char *exp); //���沨�����ʽ��ֵ 
double CharToDouble(const char *str); //�������ַ�ת��Ϊ������ 
void GetStr(char *str); //��ȡ����ʽ 

int main(void)
 {
     char str[MAXSIZE], exp[MAXSIZE];
     double answer;
    
     GetStr(str);
     Translate(str, exp); 
     answer =  CompValue(exp);
     printf("%g\n",answer);
     
     return 0;
 }

 void GetStr(char *str) //��ȡ����ʽ 
{
     int i = 0;

     while((str[i]=getchar())!='\n')
     	i++;

     str[i++] = '#';
     str[i] = '\0';
 }

 void Translate(const char str[], char exp[]) //ת��Ϊ�沨�����ʽ 
{
     char stack[MAXSIZE];
     int i = 0, k = 0, top = -1; 
     
     while (str[i] != '#')
     {
         if (str[i] == '(') //ֱ�ӽ�'('��ջ 
        {
             stack[++top] = str[i++];
         }
         else if (str[i] == ')') 
         {
             while (top >= 0 && stack[top] != '(') //��'(' ֮ǰ�ķ��ų�ջ�����洢���沨�����ʽ 
            {
                 exp[k++] = stack[top--];
             }
             
             if (top < 0) //'('���㣬���ж����')'
             {
                 puts("'('Not Matched!\n");
                 exp[k++] = '\0';
                 return ;
             }
             top--;//ȥ�� '('
             i++;
         }
         else if (str[i] == '+' || str[i] == '-')
         {
             while (top >= 0 && stack[top] != '(') ////�����'('����'('֮ǰ�ķ��ų�ջ���������з��ų�ջ�����洢���沨�����ʽ 
            {
                 exp[k++] = stack[top--];
             }
             stack[++top] = str[i++]; //���µ����������ջ 
        }
         else if (str[i] == '*' || str[i] == '/') 
         {
             while (top >= 0 && (stack[top] == '*' || stack[top] == '/')) //��'*'��'/'֮ǰ�ķ��ų�ջ�����洢���沨�����ʽ  
            {
                 exp[k++] = stack[top--];
             }
             stack[++top] = str[i++]; //���µ����������ջ
        }
         else
         {
             while ((str[i] >= '0' && str[i] <= '9') || str[i] == '.') //��������ֱ�Ӵ洢���沨�����ʽ
            {
                 exp[k++] = str[i++];
             } 
             exp[k++] = '#'; //����һ���������������ţ��Ա���ȷ��ȡ������ 
        }
     }
     
     while (top >= 0) //��ջ������������Ŵ洢���沨�����ʽ
    {
         if (stack[top] == '(') //�ж����'( 
         {
             puts("'('Not Matched!\n");
             exp[k++] = '\0';
             return ;
         }
         exp[k++] = stack[top--];
     }
     
     exp[k++] = '\0';
 }

 double CompValue(const char *exp) //���沨�����ʽ��ֵ
{
     char tempStr[MAXSIZE];
     double stack[MAXSIZE];
     int i = 0, k = 0, top = -1;
     
     while (exp[i] != '\0')
     {
         if (exp[i] >= '0' && exp[i] <= '9') 
         {
             k = 0;
             while (exp[i] != '#')
             {
                 tempStr[k++] = exp[i++];
             }
             tempStr[k] = '\0';
             stack[++top] = CharToDouble(tempStr);
             i++; //����'#' 
         }
         else
         {
             switch (exp[i++]) //����������ջ�����˳���������� 
            {
                 case '+' : stack[top-1] += stack[top];
                            break;
                 case '-' : stack[top-1] -= stack[top];
                            break;
                 case '*' : stack[top-1] *= stack[top];
                            break;
                 case '/' : if (stack[top] != 0)
                            {
                                   stack[top-1] /= stack[top];
                            }
                            else
                            {
                                   puts("Zero Divisor!\n");
                                return 0;       
                            }
                            break;                              
             }
             top--; //�˳���������� 
        }
     }
     
     return stack[top];
 }

 double CharToDouble(const char *str) //�������ַ���ת��Ϊ������ 
{
     double sumInt = 0, sumDec = 0, e = 1;
     int i = 0;
     
     while (str[i] >= '0' && str[i] <= '9') 
     {
         sumInt = sumInt * 10 + str[i++] - '0';
     }
     
     if (str[i] == '.') //�����С��������С������
    {
         while (str[++i] != '\0')
         {
             sumDec = sumDec * 10 + str[i] - '0';
             e *= 10;
         }
     } 
     
     return sumInt + sumDec / e;
 } 
