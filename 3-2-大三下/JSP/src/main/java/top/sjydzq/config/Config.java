package top.sjydzq.config;

public abstract class Config {
    public final static String DB_DRIVER = "org.mariadb.jdbc.Driver";
    public final static String DB_URL = "jdbc:mariadb://数据库地址";
    public final static String DB_USERNAME = "用户名";
    public final static String DB_PASSWORD = "密码";
    public final static int DEFAULT_PAGE_NO = 1;
    public final static int DEFAULT_PAGE_SIZE = 8;
}
