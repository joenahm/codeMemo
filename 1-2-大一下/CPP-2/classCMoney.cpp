class CMoney{   //������CMoney
private:        //�������ԣ�Ԫ���ǡ���
    int yuan,jiao,fen;
public:         //�������캯��
    CMoney(int,int,int);
};
CMoney::CMoney(int y=0,int f=0,int j=0){//���幹�캯�����ڲ������и�ÿ������������ֵ
    yuan=y;
    jiao=j;
    fen=f;
}
