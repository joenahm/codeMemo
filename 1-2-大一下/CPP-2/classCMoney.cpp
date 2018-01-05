class CMoney{   //定义类CMoney
private:        //声明属性：元、角、分
    int yuan,jiao,fen;
public:         //声明构造函数
    CMoney(int,int,int);
};
CMoney::CMoney(int y=0,int f=0,int j=0){//定义构造函数：在参数表中给每个变量都赋初值
    yuan=y;
    jiao=j;
    fen=f;
}
