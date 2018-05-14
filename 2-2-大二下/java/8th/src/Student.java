import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class Student extends MySQL<Vector>{
	Student(String user,String password,String dbName){
		super(user,password,dbName);
	}

	private Vector<StuInfo> getContentFromRes(ResultSet resource){
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
	protected Vector<StuInfo> getContent(String tableName) {
		ResultSet resource = getRes(tableName);
		Vector<StuInfo> stuInfoVec = getContentFromRes(resource);

		return stuInfoVec;
	}
	public Vector<StuInfo> getStuInfo(){
		return getContent("student");
	}
	public Vector<StuInfo> selectStuInfo(StuInfo info){
        Vector<StuInfo> stuInfoVec = null;
        ResultSet resource = null;
        //这里本应该做，但没有做格式检查
        String sql = "SELECT * FROM student WHERE ";

        boolean isAllBlank = true;
        ArrayList<String> parts = new ArrayList<>();
        if( !info.name.equals("") ){
            isAllBlank = false;
            parts.add("instr(name,'"+info.name+"')>0");
        }
        if( !info.gender.equals("") ){
            isAllBlank = false;
            parts.add("instr(gender,'"+info.gender+"')>0");
        }
        if( !info.id.equals("") ){
            isAllBlank = false;
            parts.add("instr(id,'"+info.id+"')>0");
        }
        if( !info.major.equals("") ){
            isAllBlank = false;
            parts.add("instr(major,'"+info.major+"')>0");
        }
        if( !info.grade.equals("") ){
            isAllBlank = false;
            parts.add("instr(grade,'"+info.grade+"')>0");
        }
        if( !info.kurasu.equals("") ){
            isAllBlank = false;
            parts.add("instr(class,'"+info.kurasu+"')>0");
        }

        if( isAllBlank ){
            resource = getRes("student");
        }else{
            sql = sql + parts.get(0);
            for( int i = 1 ; i < parts.size() ; i++ ){
                sql = sql + " or " + parts.get(i);
            }
            try{
                Statement statement = connection.createStatement();
                resource = statement.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println("信息检索失败\n");
                e.printStackTrace();
            }
        }

        stuInfoVec = getContentFromRes(resource);

        return stuInfoVec;
    }
	public void insertStuInfo(StuInfo info){
	    //这里本应该做，但没有做格式检查
	    String sql = "INSERT INTO student VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,info.name);
            statement.setString(2,info.gender);
            statement.setString(3,info.id);
            statement.setString(4,info.major);
            statement.setString(5,info.grade);
            statement.setString(6,info.kurasu);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("信息插入失败\n");
            e.printStackTrace();
        }
    }
    public void updateStuInfo(StuInfo info){
        //这里本应该做，但没有做格式检查。而且也没有设置id不能改
        String sql = "UPDATE student SET name=?,gender=?,major=?,grade=?,class=? WHERE id=?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,info.name);
            statement.setString(2,info.gender);
            statement.setString(3,info.major);
            statement.setString(4,info.grade);
            statement.setString(5,info.kurasu);
            statement.setString(6,info.id);

            statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println("信息更新失败\n");
            e.printStackTrace();
        }
    }
    public void deleteStuInfo(StuInfo info){
	    String sql = "DELETE FROM student WHERE id=?";
	    try{
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1,info.id);

	        statement.executeUpdate();
        }catch (SQLException e) {
            System.out.println("信息删除失败\n");
            e.printStackTrace();
        }
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
