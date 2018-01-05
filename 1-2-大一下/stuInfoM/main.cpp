#include "header.h"

int main(int argc,const char* argv[]){
    vector <string> arg;
    for(int i=1;i<argc;i++){
        arg.push_back(argv[i]);
    }
    arg.push_back("None");
    if(arg[0]=="None"){
        cout<<"ʹ��˵��:"<<endl<<endl;
        cout.setf(std::ios::left);
        cout.width(25);
        cout<<"insert [����]";
        cout<<setfill(' ')<<setw(75)<<"������� [����]��Ϊ:PUPIL,JUNIOR,SENIOR �ֱ����:Сѧ������ѧ������ѧ��"<<endl<<endl;
        cout.width(25);
        cout.setf(std::ios::left);
        cout<<"search";
        cout<<setfill(' ')<<setw(75)<<"��ѯ����"<<endl<<endl;
        cout.width(25);
        cout.setf(std::ios::left);
        cout<<"show";
        cout<<setfill(' ')<<setw(75)<<"��ʾ���� ��ʾ��������"<<endl<<endl;
        cout.width(25);
        cout.setf(std::ios::left);
        cout<<"edit [ѧ��]";
        cout<<setfill(' ')<<setw(75)<<"�༭���� ����ѧ�ż���"<<endl<<endl;
        cout.width(25);
        cout.setf(std::ios::left);
        cout<<"delete [����] [ѧ��]";
        cout<<setfill(' ')<<setw(75)<<"ɾ������ ��������(ͬ insert)��ѧ�ż���"<<endl<<endl;
        cout.width(25);
        cout.setf(std::ios::left);
        cout<<"count [��ʽ]";
        cout<<setfill(' ')<<setw(75)<<"ͳ������ [��ʽ]��Ϊ:ALL,PUPIL,JUNIOR,SENIOR,SCORE,AVERAGE �ֱ����:��������Сѧ��������ѧ��������ѧ�����������ܳɼ�������ƽ����"<<endl<<endl;
        cout.width(25);
        cout.setf(std::ios::left);
        cout<<"sort [��ʽ]";
        cout<<setfill(' ')<<setw(75)<<"�������� [��ʽ]��Ϊ:ALL,SINGLE �ֱ����:�ܳɼ������Ƴɼ�"<<endl<<endl;
    }else if(arg[0]=="insert"){
        int type;
        if(arg[1]=="PUPIL")
            type=PUPIL;
        else if(arg[1]=="JUNIOR")
            type=JUNIOR;
        else if(arg[1]=="SENIOR")
            type=SENIOR;
        else if(arg[1]=="None"){
            cerr<<"��������:δ����ڶ�������"<<endl;
            exit(4);
        }
        else{
            cerr<<"��������:û�в���["<<arg[1]<<"]"<<endl;
            exit(5);
        }
        writeInfo(type,insertInfo(type));
    }else if(arg[0]=="search"){
        int type,key;
        string value;
        int val;
        cout<<"��ѯ��Χ(��������-Сѧ[0]����ѧ[1]����ѧ[2]):";
        cin>>type;
        while(type!=0&&type!=1&&type!=2){
            cerr<<"�������:������0��1��2,����֮һ"<<endl<<":";
            cin>>type;
        }
        switch(type){
        case PUPIL:
            cout<<"��ѯ����(��������-ѧ��[11]������[12]��Ӣ��ɼ�[13]����ѧ�ɼ�[14]�����ĳɼ�[15]������[51]���Ա�[52]���༶[53]):";
            cin>>key;
            while(key!=11&&key!=12&&key!=13&&key!=14&&key!=15&&key!=51&&key!=52&&key!=53){
                cerr<<"�������:������11��12��13��14��15��51��52��53,����֮һ"<<endl<<":";
                cin>>key;
            }
            break;
        case JUNIOR:
            cout<<"��ѯ����(��������-ѧ��[11]������[12]��Ӣ��ɼ�[13]����ѧ�ɼ�[14]�����ĳɼ�[15]������ɼ�[16]����ʷ�ɼ�[17]������[51]���Ա�[52]���༶[53]):";
            cin>>key;
            while(key!=11&&key!=12&&key!=13&&key!=14&&key!=15&&key!=16&&key!=17&&key!=51&&key!=52&&key!=53){
                cerr<<"�������:������11��12��13��14��15��16��17��51��52��53,����֮һ"<<endl<<":";
                cin>>key;
            }
            break;
        case SENIOR:
            cout<<"��ѯ����(��������-ѧ��[11]������[12]��Ӣ��ɼ�[13]��������Ƴɼ�[18]�������ɼ�[19]������[51]���Ա�[52]���༶[53]��רҵ[54]):";
            cin>>key;
            while(key!=11&&key!=12&&key!=13&&key!=18&&key!=19&&key!=51&&key!=52&&key!=53&&key!=54){
                cerr<<"�������:������11��12��13��18��19��51��52��53��54,����֮һ"<<endl<<":";
                cin>>key;
            }
            break;
        }
        cout<<"��ѯֵ:";
        cin>>value;
        if(key<30){
            val=atoi(value.c_str());
            searchInfo(type,key,val);
        }else
            searchInfo(type,key,value);
    }else if(arg[0]=="show")
        allInfo();
    else if(arg[0]=="edit"){
        if(arg[1]=="None"){
            cerr<<"��������:δ����ڶ�������"<<endl;
            exit(4);
        }
        int id=atoi(arg[1].c_str());
        int cnt=0,hitI=-1,type;
        vector <Student*> p=readInfo(PUPIL);
        vector <Student*> j=readInfo(JUNIOR);
        vector <Student*> s=readInfo(SENIOR);
        vector <unsigned> Ids;
        for(int i=0;i<p.size();i++){
            if(id==p[i]->getId()){
                type=p[i]->get();
                hitI=i;
            }
            else{
                cnt++;
                Ids.push_back(p[i]->getId());
            }
        }
        for(int i=0;i<j.size();i++){
            if(id==j[i]->getId()){
                type=j[i]->get();
                hitI=i;
            }
            else{
                cnt++;
                Ids.push_back(j[i]->getId());
            }
        }
        for(int i=0;i<s.size();i++){
            if(id==s[i]->getId()){
                type=s[i]->get();
                hitI=i;
            }
            else{
                cnt++;
                Ids.push_back(s[i]->getId());
            }
        }
        if(cnt==p.size()+j.size()+s.size())
            cout<<"�޽��"<<endl;
        else{
            Student* stu;
            Student* outStu;

            unsigned Id;
            string Name;
            string Sex;
            unsigned Age;
            string Kurasu;
            unsigned markEn;
            unsigned markMath;
            unsigned markCn;
            unsigned markGeo;
            unsigned markHis;
            string Major;
            unsigned markPgm;
            unsigned markHm;

            bool isE=false;
            int key;
            if(type==PUPIL){
                stu=p[hitI];
                Id=stu->getId();
                Name=stu->getName();
                Sex=stu->getSex();
                Age=stu->getAge();
                Kurasu=stu->getKurasu();
                markEn=stu->getMarkEn();
                markMath=stu->getMarkMath();
                markCn=stu->getMarkCn();
                cout<<"�޸�����(��������-ѧ��[11]������[12]��Ӣ��ɼ�[13]����ѧ�ɼ�[14]�����ĳɼ�[15]������[51]���Ա�[52]���༶[53]):";
                cin>>key;
                while(key!=11&&key!=12&&key!=13&&key!=14&&key!=15&&key!=51&&key!=52&&key!=53){
                    cerr<<"�������:������11��12��13��14��15��51��52��53,����֮һ"<<endl<<":";
                    cin>>key;
                }
                switch(key){
                case ID:
                    do{
                        isE=false;
                        cout<<":";
                        cin>>Id;
                        for(int i=0;i<Ids.size();i++){
                            if(Id==Ids[i]){
                                isE=true;
                                cerr<<"��ѧ���Ѵ���"<<endl;
                            }
                        }
                    }while(isE);
                    break;
                case NAME:
                    cout<<":";
                    cin>>Name;
                    break;
                case SEX:
                    cout<<":";
                    cin>>Sex;
                    while(Sex!="��"&&Sex!="Ů"){
                        cerr<<endl<<"����:�Ա����Ϊ���С���Ů��!"<<endl;
                        cout<<":";
                        cin>>Sex;
                    }
                    break;
                case AGE:
                    cout<<":";
                    cin>>Age;
                    break;
                case KURASU:
                    cout<<":";
                    cin>>Kurasu;
                    break;
                case MARKEN:
                    cout<<":";
                    cin>>markEn;
                    break;
                case MARKMATH:
                    cout<<":";
                    cin>>markMath;
                    break;
                case MARKCN:
                    cout<<":";
                    cin>>markCn;
                    break;
                }
                outStu=new Pupil(Id,Name,Sex,Age,Kurasu,markEn,markMath,markCn);
                delInfo(PUPIL,stu->getId());
                writeInfo(PUPIL,outStu);
            }else if(type==JUNIOR){
                stu=j[hitI];
                Id=stu->getId();
                Name=stu->getName();
                Sex=stu->getSex();
                Age=stu->getAge();
                Kurasu=stu->getKurasu();
                markEn=stu->getMarkEn();
                markMath=stu->getMarkMath();
                markCn=stu->getMarkCn();
                markGeo=stu->getMarkGeo();
                markHis=stu->getMarkHis();
                cout<<"�޸�����(��������-ѧ��[11]������[12]��Ӣ��ɼ�[13]����ѧ�ɼ�[14]�����ĳɼ�[15]������ɼ�[16]����ʷ�ɼ�[17]������[51]���Ա�[52]���༶[53]):";
                cin>>key;
                while(key!=11&&key!=12&&key!=13&&key!=14&&key!=15&&key!=16&&key!=17&&key!=51&&key!=52&&key!=53){
                    cerr<<"�������:������11��12��13��14��15��16��17��51��52��53,����֮һ"<<endl<<":";
                    cin>>key;
                }
                switch(key){
                   case ID:
                        do{
                            isE=false;
                            cout<<":";
                            cin>>Id;
                            for(int i=0;i<Ids.size();i++){
                                if(Id==Ids[i]){
                                    isE=true;
                                    cerr<<"��ѧ���Ѵ���"<<endl;
                                }
                            }
                        }while(isE);
                        break;
                    case NAME:
                        cout<<":";
                        cin>>Name;
                        break;
                    case SEX:
                        cout<<":";
                        cin>>Sex;
                        while(Sex!="��"&&Sex!="Ů"){
                            cerr<<endl<<"����:�Ա����Ϊ���С���Ů��!"<<endl;
                            cout<<":";
                            cin>>Sex;
                        }
                        break;
                    case AGE:
                        cout<<":";
                        cin>>Age;
                        break;
                    case KURASU:
                        cout<<":";
                        cin>>Kurasu;
                        break;
                    case MARKEN:
                        cout<<":";
                        cin>>markEn;
                        break;
                    case MARKMATH:
                        cout<<":";
                        cin>>markMath;
                        break;
                    case MARKCN:
                        cout<<":";
                        cin>>markCn;
                        break;
                    case MARKGEO:
                        cout<<":";
                        cin>>markGeo;
                        break;
                    case MARKHIS:
                        cout<<":";
                        cin>>markHis;
                        break;
                    }
                    outStu=new Junior(Id,Name,Sex,Age,Kurasu,markEn,markMath,markCn,markGeo,markHis);
                    delInfo(JUNIOR,stu->getId());
                    writeInfo(JUNIOR,outStu);
                }else if(type==SENIOR){
                    stu=s[hitI];
                    Id=stu->getId();
                    Name=stu->getName();
                    Sex=stu->getSex();
                    Age=stu->getAge();
                    Kurasu=stu->getKurasu();
                    Major=stu->getMajor();
                    markEn=stu->getMarkEn();
                    markPgm=stu->getMarkPgm();
                    markHm=stu->getMarkHm();
                    cout<<"�޸�����(��������-ѧ��[11]������[12]��Ӣ��ɼ�[13]��������Ƴɼ�[18]�������ɼ�[19]������[51]���Ա�[52]���༶[53]��רҵ[54]):";
                    cin>>key;
                    while(key!=11&&key!=12&&key!=13&&key!=18&&key!=19&&key!=51&&key!=52&&key!=53&&key!=54){
                        cerr<<"�������:������11��12��13��18��19��51��52��53��54,����֮һ"<<endl<<":";
                        cin>>key;
                    }
                    switch(key){
                    case ID:
                        do{
                            isE=false;
                            cout<<":";
                            cin>>Id;
                            for(int i=0;i<Ids.size();i++){
                                if(Id==Ids[i]){
                                    isE=true;
                                    cerr<<"��ѧ���Ѵ���"<<endl;
                                }
                            }
                        }while(isE);
                        break;
                    case NAME:
                        cout<<":";
                        cin>>Name;
                        break;
                    case SEX:
                        cout<<":";
                        cin>>Sex;
                        while(Sex!="��"&&Sex!="Ů"){
                            cerr<<endl<<"����:�Ա����Ϊ���С���Ů��!"<<endl;
                            cout<<":";
                            cin>>Sex;
                        }
                        break;
                    case AGE:
                        cout<<":";
                        cin>>Age;
                        break;
                    case KURASU:
                        cout<<":";
                        cin>>Kurasu;
                        break;
                    case MAJOR:
                        cout<<":";
                        cin>>Major;
                        break;
                    case MARKEN:
                        cout<<":";
                        cin>>markEn;
                        break;
                    case MARKPGM:
                        cout<<":";
                        cin>>markPgm;
                        break;
                    case MARKHM:
                        cout<<":";
                        cin>>markHm;
                        break;
                    }
                    outStu=new Senior(Id,Name,Sex,Age,Kurasu,Major,markEn,markPgm,markHm);
                    delInfo(SENIOR,stu->getId());
                    writeInfo(SENIOR,outStu);
                }
            }
        }else if(arg[0]=="delete"){
            int type,id;
            if(arg[1]=="PUPIL")
                type=PUPIL;
            else if(arg[1]=="JUNIOR")
                type=JUNIOR;
            else if(arg[1]=="SENIOR")
                type=SENIOR;
            else if(arg[1]=="None"){
                cerr<<"��������:δ����ڶ�������"<<endl;
                exit(4);
            }
            else{
                cerr<<"��������:û�в���["<<arg[1]<<"]"<<endl;
                exit(5);
            }
            if(arg[2]=="None"){
                cerr<<"��������:δ�������������"<<endl;
                exit(4);
            }else
                id=atoi(arg[2].c_str());
            delInfo(type,id);
        }else if(arg[0]=="count"){
            int type,key;
            int id;
            string name;
            if(arg[1]=="ALL")
                statNum(ALL);
            else if(arg[1]=="PUPIL")
                statNum(PUPIL);
            else if(arg[1]=="JUNIOR")
                statNum(JUNIOR);
            else if(arg[1]=="SENIOR")
                statNum(SENIOR);
            else if(arg[1]=="SCORE"){
                cout<<"��ѯ��Χ(��������-Сѧ��[0]����ѧ��[1]����ѧ��[2]):";
                cin>>type;
                while(type!=0&&type!=1&&type!=2){
                    cerr<<"�������:������0��1��2,����֮һ"<<endl<<":";
                    cin>>type;
                }
                cout<<"��ѯ����(��������-ѧ��[11]������[51]):";
                cin>>key;
                while(key!=11&&key!=51){
                    cerr<<"�������:������11��51,����֮һ"<<endl<<":";
                    cin>>key;
                }
                switch(key){
                case ID:
                    cout<<":";
                    cin>>id;
                    stat(type,id);
                    break;
                case NAME:
                    cout<<":";
                    cin>>name;
                    stat(type,name);
                    break;
                }
            }
            else if(arg[1]=="AVERAGE"){
                cout<<"��ѯ��Ŀ(��������-Ӣ��[13]����ѧ[14]������[15]������[16]����ʷ[17]���������[18]������[19]):";
                cin>>key;
                while(key!=13&&key!=14&&key!=15&&key!=16&&key!=17&&key!=18&&key!=19){
                    cerr<<"�������:������13��14��15��16��17��18��19,����֮һ"<<endl<<":";
                    cin>>key;
                }
                stat(key);
            }else if(arg[1]=="None"){
                cerr<<"��������:δ����ڶ�������"<<endl;
                exit(4);
            }else{
                cerr<<"��������:û�в���["<<arg[1]<<"]"<<endl;
                exit(5);
            }
        }else if(arg[0]=="sort"){
            if(arg[1]=="ALL"){
                int type;
                cout<<"��ѯ��Χ(��������-Сѧ��[0]����ѧ��[1]����ѧ��[2]):";
                cin>>type;
                while(type!=0&&type!=1&&type!=2){
                    cerr<<"�������:������0��1��2,����֮һ"<<endl<<":";
                    cin>>type;
                }
                vector <Student*> stu=sortAll(type);
                tabHead(type);
                for(int i=0;i<stu.size();i++){
                    printInfo(stu[i],type);
                }
            }else if(arg[1]=="SINGLE"){
                int type,key;
                cout<<"��ѯ��Χ(��������-Сѧ��[0]����ѧ��[1]����ѧ��[2]):";
                cin>>type;
                while(type!=0&&type!=1&&type!=2){
                    cerr<<"�������:������0��1��2,����֮һ"<<endl<<":";
                    cin>>type;
                }
                switch(type){
                case PUPIL:
                    cout<<"��ѯ��Ŀ(��������-Ӣ��ɼ�[13]����ѧ�ɼ�[14]�����ĳɼ�[15]):";
                    cin>>key;
                    while(key!=13&&key!=14&&key!=15){
                        cerr<<"�������:������13��14��15,����֮һ"<<endl<<":";
                        cin>>key;
                    }
                    break;
                case JUNIOR:
                    cout<<"��ѯ��Ŀ(��������-Ӣ��ɼ�[13]����ѧ�ɼ�[14]�����ĳɼ�[15]������ɼ�[16]����ʷ�ɼ�[17]):";
                    cin>>key;
                    while(key!=13&&key!=14&&key!=15&&key!=16&&key!=17){
                        cerr<<"�������:������13��14��15��16��17,����֮һ"<<endl<<":";
                        cin>>key;
                    }
                    break;
                case SENIOR:
                    cout<<"��ѯ��Ŀ(��������-Ӣ��ɼ�[13]��������Ƴɼ�[18]�������ɼ�[19]):";
                    cin>>key;
                    while(key!=13&&key!=18&&key!=19){
                        cerr<<"�������:������13��18��19,����֮һ"<<endl<<":";
                        cin>>key;
                    }
                    break;
                }
                vector <Student*> stu=sortSingle(type,key);
                tabHead(type);
                for(int i=0;i<stu.size();i++)
                    printInfo(stu[i],type);

            }else if(arg[1]=="None"){
                cerr<<"��������:δ����ڶ�������"<<endl;
                exit(4);
            }else{
                cerr<<"��������:û�в���["<<arg[1]<<"]"<<endl;
                exit(5);
            }
        }else{
            cerr<<"��������:û�в���["<<arg[0]<<"]"<<endl;
                exit(5);
        }

    /*vector <Student*> stu=sortSingle(PUPIL,MARKCN);
    tabHead(PUPIL);
    for(int i=0;i<stu.size();i++){
        printInfo(stu[i],PUPIL);
    }*/
    return 0;
}
