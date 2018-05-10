import java.util.Vector;

public class Launcher {
	public static void main(String[] args){
		Student studentDB = new Student("joe","00001011","joe_student");
		Vector<StuInfo> stuInfo = studentDB.getStuInfo();

		Controller mainForm = new Controller();
		mainForm.init();
		mainForm.setStudentList(stuInfo);
	}
}
