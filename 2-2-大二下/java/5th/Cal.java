import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Cal {
	private String myInfo = "软件164 张梦圆 的计算器";
	private Stack<Double> numberStack;
	private char operTemp = 'n';
    private JFrame frame;
    private JPanel panel;
    private JButton numBtn7;
    private JButton numBtn4;
    private JButton numBtn1;
    private JButton numBtn0;
    private JButton numBtn8;
    private JButton numBtn9;
    private JButton numBtn5;
    private JButton numBtn6;
    private JButton numBtn2;
    private JButton numBtn3;
    private JButton eqlBtn;
    private JButton addBtn;
    private JButton sbtBtn;
    private JButton mlpBtn;
    private JButton dvdBtn;
    private JTextField textField;
	private JButton modBtn;
	private JButton powBtn;
	private JButton logXYButton;
	private JButton clearBtn;
	private JButton pointBtn;


	public static void main(String[] args) {
		new Cal().run();
	}

	private void run(){
		bindBtns();

	    initFrame();

	    numberStack = new Stack<Double>();
    }

    private void bindBtns(){
	    numBtn0.addActionListener(new Input('0'));
	    numBtn1.addActionListener(new Input('1'));
	    numBtn2.addActionListener(new Input('2'));
	    numBtn3.addActionListener(new Input('3'));
	    numBtn4.addActionListener(new Input('4'));
	    numBtn5.addActionListener(new Input('5'));
	    numBtn6.addActionListener(new Input('6'));
	    numBtn7.addActionListener(new Input('7'));
	    numBtn8.addActionListener(new Input('8'));
	    numBtn9.addActionListener(new Input('9'));
	    pointBtn.addActionListener(new Input('.'));

	    clearBtn.addActionListener(new Clear());

	    addBtn.addActionListener(new Add());
	    sbtBtn.addActionListener(new Subtract());
	    mlpBtn.addActionListener(new Multiply());
	    dvdBtn.addActionListener(new Divide());
	    modBtn.addActionListener(new Mod());
	    powBtn.addActionListener(new Power());
	    logXYButton.addActionListener(new Log());

	    eqlBtn.addActionListener(new Equal());

    }
    private JMenuBar initMenuBar(){
	    JMenuItem aboutMI = new JMenuItem("关于");
	    aboutMI.addActionListener(new ShowAboutInfo());

	    JMenuItem exitMI = new JMenuItem("退出");
	    exitMI.addActionListener(new Exit());
	    exitMI.setAccelerator(KeyStroke.getKeyStroke("control E"));

	    JMenu functionMenu = new JMenu("功能");
	    functionMenu.add(aboutMI);
	    functionMenu.add(exitMI);

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.add(functionMenu);

	    return menuBar;
    }
    private void initFrame(){
	    String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
	    try {
		    UIManager.setLookAndFeel(lookAndFeel);
	    } catch (ClassNotFoundException e) {
		    e.printStackTrace();
	    } catch (InstantiationException e) {
		    e.printStackTrace();
	    } catch (IllegalAccessException e) {
		    e.printStackTrace();
	    } catch (UnsupportedLookAndFeelException e) {
		    e.printStackTrace();
	    }

	    textField.setHorizontalAlignment(JTextField.RIGHT);
	    textField.setDisabledTextColor(Color.DARK_GRAY);
	    textField.setText(myInfo);
	    textField.addKeyListener(new ClearDefaultText());
	    textField.addKeyListener(new Simulate());
	    textField.requestFocus();

	    numBtn0.setFocusable(false);
	    numBtn1.setFocusable(false);
	    numBtn2.setFocusable(false);
	    numBtn3.setFocusable(false);
	    numBtn4.setFocusable(false);
	    numBtn5.setFocusable(false);
	    numBtn6.setFocusable(false);
	    numBtn7.setFocusable(false);
	    numBtn8.setFocusable(false);
	    numBtn9.setFocusable(false);
	    pointBtn.setFocusable(false);
	    addBtn.setFocusable(false);
	    sbtBtn.setFocusable(false);
	    mlpBtn.setFocusable(false);
	    dvdBtn.setFocusable(false);
	    modBtn.setFocusable(false);
	    powBtn.setFocusable(false);
	    logXYButton.setFocusable(false);
	    clearBtn.setFocusable(false);
	    eqlBtn.setFocusable(false);



	    frame = new JFrame("计算器");
	    frame.setJMenuBar(initMenuBar());
	    frame.getContentPane().add(panel);
	    frame.setSize(300,240);
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.addMouseMotionListener(new ClearDefaultText());

	    frame.setVisible(true);
    }

    private boolean checkMaxsize(){
		if( textField.getText().length() < 18){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "不能再计算更长的式子了！", "警告", JOptionPane.WARNING_MESSAGE);
			return false;
		}

    }
    private void showAlert(String info){
	    JOptionPane.showMessageDialog(null, info, "警告", JOptionPane.WARNING_MESSAGE);

    }

    private void pushNumber(){
		String valueStr = textField.getText();
		if( valueStr.length() > 0 ){
			try {
				numberStack.push(Double.parseDouble(valueStr));
//				System.out.println(numberStack.peek());
			}catch (NumberFormatException e){
				showAlert("格式出錯");
			}finally {
				textField.setText("");
			}
		}
    }
    private double cal(double num2, char oper, double num1){
		double result = 0.0;
		switch ( oper ){
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result= num1 * num2;
				break;
			case '/':
				if( num2 == 0 ){
					showAlert("除数不能为0！");
				}else{
					result = num1 / num2;
				}
				break;
			case '%':
				if( num2 == 0 ){
					showAlert("取模数不能为0！");
				}else {
					result = num1 % num2;
				}
				break;
			case '^':
				result = Math.pow(num1,num2);
				break;
			case 'l':
				if( num1 < 0 ){
					showAlert("底数不能为负！");
				}else if( num1 == 1 ){
					showAlert("底数不能为1！");
				}else{
					result =Math.log(num1)/Math.log(num2);
				}
				break;
		}

		return result;
    }
    private void performCal(){
	    if( operTemp != 'n' ){
	    	if( !numberStack.empty() ){
			    double temp = numberStack.pop();
			    if( numberStack.empty() ){
				    numberStack.push(temp);
				    //打扰了，打扰了，告辞！
			    }else{
				    double result = cal(temp,operTemp,numberStack.pop());
				    numberStack.push(result);
				    textField.setText(Double.toString(result));
			    }
		    }
	    }
    }
    private void prepareNextCal(char type){
		operTemp = type;
		textField.setText(Character.toString(type));
    }

    class Input implements ActionListener{
		private char value;

		Input(char value){
			this.value = value;
		}

		public void actionPerformed(ActionEvent e){
			if( checkMaxsize() ) {
				String value = textField.getText();
				if( value.matches("[+*/%^l]")  ) {
					textField.setText("");
				}else if( value.equals("-") ){
					operTemp = '+';
				}

				textField.setText(textField.getText() + this.value);

			}
		}
    }
    class Clear implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	textField.setText("");
	    	operTemp = 'n';
	    	while( !numberStack.empty() ){
	    		numberStack.pop();
		    }
	    }
    }

    class Add implements ActionListener{
		public void actionPerformed(ActionEvent event){
			pushNumber();
			performCal();
			prepareNextCal('+');
		}
	}
	class Subtract implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			pushNumber();
			performCal();
			prepareNextCal('-');
		}
	}
	class Multiply implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			pushNumber();
			performCal();
			prepareNextCal('*');
		}
	}
	class Divide implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			pushNumber();
			performCal();
			prepareNextCal('/');
		}
	}
	class Mod implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			pushNumber();
			performCal();
			prepareNextCal('%');
		}
	}
	class Power implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			pushNumber();
			performCal();
			prepareNextCal('^');
		}
	}
	class Log implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			pushNumber();
			performCal();
			prepareNextCal('l');
		}
	}
	class Equal implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if( operTemp != 'n' ){
				pushNumber();
				performCal();
				operTemp = 'n';
			}

			if( !numberStack.empty() ){
				double result = numberStack.pop();
				textField.setText(Double.toString(result));
			}
		}
	}

	class Simulate implements KeyListener{
		private char buff(KeyEvent e){
			String value = textField.getText();
			String keyString = Character.toString(e.getKeyChar());

			if( !keyString.matches("[^+\\-*/%^l0-9.]") ){
				int index = value.length()-1;
				if( index >=0 ){
					textField.setText(value.substring(0,index));
				}
			}

			return e.getKeyChar();
		}

		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {
			char buffer = buff(e);
			String bufferStr = Character.toString(buffer);

			if( bufferStr.matches("[+\\-*/%^l0-9.]")){
				switch (buffer){
					case '0':
						numBtn0.doClick();
						break;
					case '1':
						numBtn1.doClick();
						break;
					case '2':
						numBtn2.doClick();
						break;
					case '3':
						numBtn3.doClick();
						break;
					case '4':
						numBtn4.doClick();
						break;
					case '5':
						numBtn5.doClick();
						break;
					case '6':
						numBtn6.doClick();
						break;
					case '7':
						numBtn7.doClick();
						break;
					case '8':
						numBtn8.doClick();
						break;
					case '9':
						numBtn9.doClick();
						break;
					case '.':
						pointBtn.doClick();
						break;
					case '+':
						addBtn.doClick();
						break;
					case '-':
						sbtBtn.doClick();
						break;
					case '*':
						mlpBtn.doClick();
						break;
					case '/':
						dvdBtn.doClick();
						break;
					case '%':
						modBtn.doClick();
						break;
					case '^':
						powBtn.doClick();
						break;
					case 'l':
						logXYButton.doClick();
						break;
				}
			}else{
				if( e.getKeyCode() == 10 ){
					eqlBtn.doClick();
				}else if( e.getKeyCode() == 127 ){
					clearBtn.doClick();
				}
			}
		}
	}

    class ShowAboutInfo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JOptionPane.showMessageDialog(null, "制作者：软件164 张梦圆 201607370\nE-mail：joenahm@yeah.net\nGithub：http://github.com/joenahm", "关于", JOptionPane.INFORMATION_MESSAGE);
		}
    }
    class Exit implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
    }
    class ClearDefaultText implements MouseMotionListener,KeyListener{
		private void clearDefaultText(){
			if( textField.getText().matches(myInfo) ){
				textField.setText("");
			}
		}
	    public void mouseDragged(MouseEvent e) {
			clearDefaultText();
	    }
	    public void mouseMoved(MouseEvent e) {
			clearDefaultText();
	    }

	    public void keyTyped(KeyEvent e) {
		    clearDefaultText();
	    }
	    public void keyPressed(KeyEvent e) {
			clearDefaultText();
	    }
	    public void keyReleased(KeyEvent e) {
			clearDefaultText();
	    }
    }
}
