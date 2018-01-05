#include <iostream>
using namespace std;
class airCondition{ //定义类airCondition
private:    //声明属性：brand、color、power、state、temp
	string brand;
	string color;
	int power;
	enum {OFF,ON}state;
	int temp;
public: //声明方法：构造函数、开关空调、升温、降温
	airCondition(string,string,int,int);
	void sw(void);
	void tempUp(int);
	void tempDown(int);
};
/*方法实现开始*/
airCondition::airCondition(string iBrand="格力",string iColor="白色",int iPower=2,int iTemp=25){
	cout<<"空调信息："<<endl;
	cout<<"品牌："<<(brand=iBrand)<<endl;
	cout<<"颜色："<<(color=iColor)<<endl;
	cout<<"功率："<<(power=iPower)<<"匹"<<endl;
	cout<<"温度："<<(temp=iTemp)<<"℃"<<endl;
	state=OFF;
}
void airCondition::sw(void){
	if(state){
		state=OFF;
		cout<<"空调已关闭！"<<endl;
	}
	else{
		state=ON;
		cout<<"空调已打开！"<<endl;
	}
}
void airCondition::tempUp(int val=1){
	temp+=val;
	cout<<"温度："<<temp<<"℃"<<endl;
}
void airCondition::tempDown(int val=1){
	temp-=val;
	cout<<"温度："<<temp<<"℃"<<endl;
}
/*方法实现结束*/
int main(){
	airCondition cooler1;   //实例化cooler1
	cooler1.sw();   //打开空调
	cooler1.tempDown(5);    //降温5度
	return 0;
}
