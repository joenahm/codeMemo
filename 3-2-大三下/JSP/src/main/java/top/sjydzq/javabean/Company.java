package top.sjydzq.javabean;

import java.io.Serializable;

/**
 * Created by joe on 19-3-7 下午5:00
 */
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String area;
    private String size;
    private String type;
    private String brief;
    private int state;
    private int sort;
    private String viewNum;
    private String pic;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getBrief() {
        return brief;
    }

    public int getState() {
        return state;
    }

    public int getSort() {
        return sort;
    }

    public String getViewNum() {
        return viewNum;
    }

    public String getPic() {
        return pic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setViewNum(String viewNum) {
        this.viewNum = viewNum;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
