#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <math.h>

#define MAXSIZE 200

void Translate(const char str[], char exp[]);//转换为逆波兰表达式 
double CompValue(const char *exp); //求逆波兰表达式的值 
double CharToDouble(const char *str); //将数字字符转换为浮点数 
void GetStr(char *str); //读取计算式 

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

 void GetStr(char *str) //读取计算式 
{
     int i = 0;

     while((str[i]=getchar())!='\n')
     	i++;

     str[i++] = '#';
     str[i] = '\0';
 }

 void Translate(const char str[], char exp[]) //转换为逆波兰表达式 
{
     char stack[MAXSIZE];
     int i = 0, k = 0, top = -1; 
     
     while (str[i] != '#')
     {
         if (str[i] == '(') //直接将'('入栈 
        {
             stack[++top] = str[i++];
         }
         else if (str[i] == ')') 
         {
             while (top >= 0 && stack[top] != '(') //将'(' 之前的符号出栈，并存储到逆波兰表达式 
            {
                 exp[k++] = stack[top--];
             }
             
             if (top < 0) //'('不足，即有多余的')'
             {
                 puts("'('Not Matched!\n");
                 exp[k++] = '\0';
                 return ;
             }
             top--;//去掉 '('
             i++;
         }
         else if (str[i] == '+' || str[i] == '-')
         {
             while (top >= 0 && stack[top] != '(') ////如果有'('，将'('之前的符号出栈，否则所有符号出栈，并存储到逆波兰表达式 
            {
                 exp[k++] = stack[top--];
             }
             stack[++top] = str[i++]; //将新的运算符号入栈 
        }
         else if (str[i] == '*' || str[i] == '/') 
         {
             while (top >= 0 && (stack[top] == '*' || stack[top] == '/')) //将'*'和'/'之前的符号出栈，并存储到逆波兰表达式  
            {
                 exp[k++] = stack[top--];
             }
             stack[++top] = str[i++]; //将新的运算符号入栈
        }
         else
         {
             while ((str[i] >= '0' && str[i] <= '9') || str[i] == '.') //将浮点数直接存储到逆波兰表达式
            {
                 exp[k++] = str[i++];
             } 
             exp[k++] = '#'; //增加一个浮点数结束符号，以便正确提取浮点数 
        }
     }
     
     while (top >= 0) //将栈中所有运算符号存储到逆波兰表达式
    {
         if (stack[top] == '(') //有多余的'( 
         {
             puts("'('Not Matched!\n");
             exp[k++] = '\0';
             return ;
         }
         exp[k++] = stack[top--];
     }
     
     exp[k++] = '\0';
 }

 double CompValue(const char *exp) //求逆波兰表达式的值
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
             i++; //跳过'#' 
         }
         else
         {
             switch (exp[i++]) //将计算结果入栈，并退出多余的数字 
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
             top--; //退出多余的数字 
        }
     }
     
     return stack[top];
 }

 double CharToDouble(const char *str) //将数字字符串转换为浮点数 
{
     double sumInt = 0, sumDec = 0, e = 1;
     int i = 0;
     
     while (str[i] >= '0' && str[i] <= '9') 
     {
         sumInt = sumInt * 10 + str[i++] - '0';
     }
     
     if (str[i] == '.') //如果含小数，处理小数部分
    {
         while (str[++i] != '\0')
         {
             sumDec = sumDec * 10 + str[i] - '0';
             e *= 10;
         }
     } 
     
     return sumInt + sumDec / e;
 } 
