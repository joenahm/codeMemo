import javafx.scene.text.Font;

import javax.swing.*;

public abstract class MainInterface {
	private JPanel panel;
	private JLabel authorInfo;
	protected JButton selectButton;
	protected JButton insertButton;
	protected JButton updateButton;
	protected JButton deleteButton;
	protected JList studentList;
	private JTextField nameText;
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private JTextField IDText;
	private JTextField majorText;
	private JTextField gradeText;
	private JTextField classText;
	public void init(){
		initFrame();
		bindButtons();
		bindList();
	}

	abstract void bindButtons();
	abstract void bindList();

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

		authorInfo.setOpaque(true);

		JFrame frame = new JFrame("学籍管理系统");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,480);
		frame.getContentPane().add(panel);
		frame.setResizable(false);
		frame.setVisible(true);

		SwingUtilities.updateComponentTreeUI(frame);
	}
	// setter start
	public void setName(String name){
		nameText.setText(name);
	}
	public void setGender(String gender){
		if( gender.equals("男") ){
			maleRadio.setSelected(true);
			femaleRadio.setSelected(false);
		}else{
			femaleRadio.setSelected(true);
			maleRadio.setSelected(false);
		}
	}
	public void setID(String ID){
		IDText.setText(ID);
	}
	public void setMajor(String major){
		majorText.setText(major);
	}
	public void setGrade(String grade){
		gradeText.setText(grade);
	}
	public void setKurasu(String kurasu){
		classText.setText(kurasu);
	}

	// setter end

	// getter start
	public String getName(){
		return nameText.getText();
	}
	public String getGender(){
		if( maleRadio.isSelected() ){
			return "男";
		}else if( femaleRadio.isSelected() ){
			return "女";
		}else{
			return "";
		}
	}
	public String getID(){
		return IDText.getText();
	}
	public String getMajor(){
		return majorText.getText();
	}
	public String getGrade(){
		return gradeText.getText();
	}
	public String getKurasu(){
		return classText.getText();
	}
	//getter end
}
