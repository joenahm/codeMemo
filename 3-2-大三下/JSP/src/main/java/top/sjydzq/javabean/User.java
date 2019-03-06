package top.sjydzq.javabean;

import java.io.Serializable;

/**
 * Created by joe on 19-3-6 下午5:41
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    private int id;
    private String name;
    private String password;
    private String realName;
    private String email;
    private int role;
    private int state;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public String getEmail() {
        return email;
    }

    public int getRole() {
        return role;
    }

    public int getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setState(int state) {
        this.state = state;
    }
}
