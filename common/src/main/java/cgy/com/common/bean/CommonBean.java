package cgy.com.common.bean;

/**
 * Created by ChenGY on 2019-01-11.
 */
public class CommonBean {
    public String name;
    public int id;

    public CommonBean() {
    }

    public CommonBean(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "OneBean{" +
                "name='" + name + '\'' +
                ", num=" + id +
                '}';
    }
}
