import java.util.Scanner;

public class LLK {
    Btn[][] btns;

    public static void main(String[] args){
        LLK llk = new LLK();

        llk.initBtns(3,4);

        llk.showBtns();

        Btn[] inputBtns;
        while( (inputBtns=llk.inputProcesser()) != null ){
            llk.link(inputBtns[0], inputBtns[1]);
        }
    }

    void link(Btn btn1, Btn btn2){
        boolean status = false;

        status = adjacent(btn1, btn2);

        if( status ){
            btns[btn1.x()-1][btn1.y()-1].exist(false);
            btns[btn2.x()-1][btn2.y()-1].exist(false);
        }

        showBtns();
    }

    boolean adjacent(Btn btn1, Btn btn2){
        boolean status = false;

        if( btn1.exist() && btn2.exist() ){
            if( ( btn1.x() == btn2.x() )
                    && ( Math.abs(btn1.y()-btn2.y()) == 1 ) ){

                status = true;

            }else if( ( btn1.y() == btn2.y() )
                    && ( Math.abs(btn1.x()-btn2.x()) == 1 ) ){

                status = true;
            }
        }

        return status;
    }

    Btn[] inputProcesser(){
        int xMax = btns.length;
        int yMax = btns[0].length;

        int x1 = getInt("位置1，x: ", xMax);
        int y1 = getInt("位置1，y: ", yMax);

        int x2 = getInt("位置2，x: ", xMax);
        int y2 = getInt("位置2，y: ", yMax);

        Btn[] inputBtns = new Btn[2];

        inputBtns[0] = this.btns[x1-1][y1-1];
        inputBtns[1] = this.btns[x2-1][y2-1];

        return inputBtns;
    }

    int getInt(String tips, int max){
        Scanner scanner = new Scanner(System.in);
        String tempInput;

        System.out.print(tips);
        tempInput = scanner.nextLine();

        while( !tempInput.matches("[0-9]") || Integer.parseInt(tempInput)>max ){
            System.err.println("非法输入！");
            System.out.print(tips);

            tempInput = scanner.nextLine();
        }

        return Integer.parseInt(tempInput);
    }

    void initBtns(int xNum, int yNum){
        btns = new Btn[xNum][yNum];
        int name = 1;

        for( int x = 0 ; x < xNum ; x++ ){
            for( int y = 0 ; y <yNum ; y++ ){
                Btn newBtn = new Btn(x+1,y+1);

                newBtn.name(Integer.toString(name));
                newBtn.exist(true);

                btns[x][y] = newBtn;

                name++;
            }
        }

        System.out.printf("按钮初始化成功, %d x %d\n\n", xNum, yNum);
    }

    void showBtns(){
        int rowNum = 1;

        for( int y = 0 ; y < btns[0].length ; y++ ){
            for( int x = 0 ; x < btns.length ; x++ ){
                Btn btn = btns[x][y];

                if( btn.x() == btns.length ) {
                    rowNum++;
                }

                if( btn.exist() ){
                    System.out.print(btn.name());
                }else{
                    System.out.print("x");
                }

                if( btn.y() == rowNum ){
                    System.out.print("\t");
                }else{
                    System.out.print("\n");
                }
            }
        }
    }
}

class Btn{
    private boolean existStatus;

    public boolean exist(){
        return this.existStatus;
    }

    public boolean exist(boolean status){
        this.existStatus = status;

        return status;
    }

    private String name;

    public String name(){
        return this.name;
    }

    public String name(String name){
        this.name = name;

        return name;
    }

    private int x,y;

    public Btn(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x(){
        return this.x;
    }
    public int x(int x){
        this.x = x;

        return x;
    }

    public int y(){
        return this.y;
    }
    public int y(int y){
        this.y = y;

        return y;
    }
}
