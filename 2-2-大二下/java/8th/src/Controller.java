import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

class Controller extends MainInterface {
	private Student studentDB;
	private Vector<StuInfo> stuInfoVector;

	void init(String user,String password,String dbName){
		super.init();

		studentDB = new Student(user,password,dbName);
		flushStuInfoVec();
		flushInfoList();
	}

	private void flushStuInfoVec(){
		stuInfoVector = studentDB.getStuInfo();
	}
	private void flushInfoList(){
		Vector<String> infoStringVec = new Vector<>();
		for( StuInfo info : stuInfoVector ){
			String infoString = info.name+" "+info.gender+" "+info.id+" "+info.major+info.grade+info.kurasu;

			infoStringVec.add(infoString);
		}

		studentList.setListData(infoStringVec);
	}
	private void clearInfo(){
		setName("");
		setGender("");
		setID("");
		setMajor("");
		setGrade("");
		setKurasu("");
	}
	private StuInfo grabInfo(){
		StuInfo stuInfo = new StuInfo();

		stuInfo.name = getName();
		stuInfo.gender = getGender();
		stuInfo.id = getID();
		stuInfo.major = getMajor();
		stuInfo.grade= getGrade();
		stuInfo.kurasu =getKurasu();

		return stuInfo;
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
	private void flushInfo(StuInfo stuInfo){
		setName(stuInfo.name);
		setGender(stuInfo.gender);
		setID(stuInfo.id);
		setMajor(stuInfo.major);
		setGrade(stuInfo.grade);
		setKurasu(stuInfo.kurasu);
	}

	class selectBtnClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stuInfoVector = studentDB.selectStuInfo(grabInfo());

			flushInfoList();
			clearInfo();
		}
	}
	class insertBtnClick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			studentDB.insertStuInfo(grabInfo());

			flushStuInfoVec();
			flushInfoList();
			clearInfo();
		}
	}
	class updateBtnClick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			studentDB.updateStuInfo(grabInfo());

			flushStuInfoVec();
			flushInfoList();
			clearInfo();
		}
	}
	class deleteBtnClick implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		    studentDB.deleteStuInfo(grabInfo());

			flushStuInfoVec();
		    flushInfoList();
		    clearInfo();
		}
	}
	class listSelect implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent e) {
			int index = studentList.getSelectedIndex();
			if( index >= 0 && index < stuInfoVector.size() ) {
				flushInfo(stuInfoVector.get(index));
			}
		}
	}
}
