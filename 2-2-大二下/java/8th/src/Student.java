import java.sql.*;
import java.util.Vector;

public class Student extends MySQL<Vector>{
	Student(String user,String password,String dbName){
		super(user,password,dbName);
	}

	protected Vector<StuInfo> getContent(String tableName) {
		ResultSet resource = getRes(tableName);
		Vector<StuInfo> stuInfoVec = new Vector<>();

		try {
			while( resource.next() ){
				StuInfo stuInfo = new StuInfo();
				stuInfo.name = resource.getString("name");
				stuInfo.gender = resource.getString("gender");
				stuInfo.id = resource.getString("id");
				stuInfo.major = resource.getString("major");
				stuInfo.grade = resource.getString("grade");
				stuInfo.kurasu = resource.getString("class");

				stuInfoVec.add(stuInfo);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}

		return stuInfoVec;
	}
	public Vector<StuInfo> getStuInfo(){
		return getContent("student");
	}
}

//仅当做一个结构体来用
class StuInfo{
	public String name;
	public String gender;
	public String id;
	public String major;
	public String grade;
	public String kurasu;
}
