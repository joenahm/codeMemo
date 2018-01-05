#include <iostream>
#include <vector>
using namespace std;
bool operator<(string a,string b){
  bool res=true;
  if(a.length()>=b.length())
    res=false;
  return res;
}
string getMin1(vector <string> a){
  string min=a[0];
  for(int i=1;i<a.size();i++){
    if(a[i]<min)
      min=a[i];
  }
  return min;
 }
float getMin1(vector <float> a){
  float min=a[0];
  for(int i=1;i<a.size();i++){
    if(a[i]<min)
      min=a[i];
  }
  return min;
}
int getMin1(vector <int> a){
  int min=a[0];
  for(int i=1;i<a.size();i++){
    if(a[i]<min)
      min=a[i];
  }
  return min;
}

template <class T>
T getMin2(vector <T> a){
  T min=a[0];
  for(int i=1;i<a.size();i++){
    if(a[i]<min)
      min=a[i];
  }
  return min;
}
int main(){
  cout<<"6.exe"<<endl;
  vector <string> s;
  s.push_back("aa");
  s.push_back("b");
  s.push_back("ccc");
  cout<<getMin1(s)<<endl;

  vector <float> f;
  f.push_back(1.3);
  f.push_back(0.2);
  f.push_back(5.6);
  cout<<getMin1(f)<<endl;

  vector <int> n;
  n.push_back(4);
  n.push_back(0);
  n.push_back(2);
  cout<<getMin1(n)<<endl;

  cout<<endl;

  vector <string> t;
  t.push_back("asd");
  t.push_back("ffffff");
  t.push_back("cc");
  cout<<getMin2(t)<<endl;

  vector <float> g;
  g.push_back(55.5);
  g.push_back(10.1);
  g.push_back(5.56);
  cout<<getMin2(g)<<endl;

  vector <int> o;
  o.push_back(23);
  o.push_back(3434);
  o.push_back(3);
  cout<<getMin2(o)<<endl;

  return 0;
}
