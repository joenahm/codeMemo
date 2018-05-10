import java.sql.*;

abstract class MySQL<T> {
	private Connection connection;
//	private ResultSet resource;

	MySQL(String user,String password,String dbName){
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=true";

		try {
			Class.forName(driver);

			connection = DriverManager.getConnection(url,user,password);

			if (!connection.isClosed()) {
				System.out.println("数据库连接成功\n");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动没有安装\n");

		} catch (SQLException e) {
			System.out.println("数据库连接失败\n");
			e.printStackTrace();
		}
	}

	ResultSet getRes(String tableName){
		ResultSet resource = null;
		String sql = "select * from `" + tableName + "`;";

		try {
			Statement statement = connection.createStatement();
			resource = statement.executeQuery(sql);
		} catch (SQLException e){
			System.out.println("数据库资源获取失败\n");
			e.printStackTrace();
		}

		return resource;
	}

	void close(){
		try {
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	protected abstract T getContent(String tableName);
}
