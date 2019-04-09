package top.sjydzq.javabean;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by 11620 on 2019/4/9 9:07
 */
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String realName;
    private String gender;
    private Date birthday;
    private String currentLocation;
    private String residentLocation;
    private String phone;
    private String email;
    private String intention;
    private String experience;
    private String avatar;

    public int getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getResidentLocation() {
        return residentLocation;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getIntention() {
        return intention;
    }

    public String getExperience() {
        return experience;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setResidentLocation(String residentLocation) {
        this.residentLocation = residentLocation;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
