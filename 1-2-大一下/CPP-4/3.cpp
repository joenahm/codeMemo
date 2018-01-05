#include <iostream>
#include <stdlib.h>
using namespace std;
class Point{
private:
	int x,y;	
public:
	Point(int X=0,int Y=0){
			x=X;
			y=Y;
	}
	Point& operator++(){
		x++;
		y++;
		return *this;
	}
	Point operator++(int){
		return Point(x++,y++);
	}
	friend Point& operator--(Point&);
	friend Point operator--(Point&,int);
	void getPos() const{
		cout<<"x:"<<x<<",y:"<<y<<endl;
	}
};
Point& operator--(Point& p){
	p.x--;
	p.y--;
	return p;
}
Point operator--(Point& p,int){
	return Point(p.x--,p.y--);
}
int main(){
	Point p1;
	p1++;
	p1.getPos();
	++p1=Point(0,2);
	p1.getPos();
	--p1=Point(3,0);
	p1.getPos();
	p1--;
	p1.getPos();
	return 0;
}
