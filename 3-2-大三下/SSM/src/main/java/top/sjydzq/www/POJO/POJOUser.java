package top.sjydzq.www.POJO;

import javax.validation.constraints.NotBlank;

public class POJOUser {
    @NotBlank(message = "请输入用户名")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
