import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

class Controller extends MainInterface {
	private Vector<StuInfo> stuInfoVector;

	public void setStudentList(Vector<StuInfo> stuInfo){
		stuInfoVector = stuInfo;

		Vector<String> infoStringVec = new Vector<>();
		for( StuInfo info : stuInfo ){
			String infoString = info.name+" "+info.gender+" "+info.id+" "+info.major+info.grade+info.kurasu;

			infoStringVec.add(infoString);
		}

		studentList.setListData(infoStringVec);
	}

	public Vector<StuInfo> getStuInfoVec(){
		return stuInfoVector;
	}

	void bindButtons(){
		selectButton.addActionListener(new selectBtnClick());
		insertButton.addActionListener(new insertBtnClick());
		updateButton.addActionListener(new updateBtnClick());
		deleteButton.addActionListener(new deleteBtnClick());
	}
	void bindList(){
		studentList.addListSelectionListener(new listSelect());
	}
	void flushInfo(StuInfo stuInfo){
		setName(stuInfo.name);
		setGender(stuInfo.gender);
		setID(stuInfo.id);
		setMajor(stuInfo.major);
		setGrade(stuInfo.grade);
		setKurasu(stuInfo.kurasu);
	}

	class selectBtnClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("我是查询按钮");
		}
	}
	class insertBtnClick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("我是添加按钮");
		}
	}
	class updateBtnClick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("我是修改按钮");
		}
	}
	class deleteBtnClick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("我是删除按钮");
		}
	}
	class listSelect implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			int index = studentList.getSelectedIndex();
			flushInfo(getStuInfoVec().get(index));
		}
	}
}
