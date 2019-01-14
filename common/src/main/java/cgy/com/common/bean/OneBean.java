package cgy.com.common.bean;

/**
 * Created by ChenGY on 2019-01-11.
 */
public class OneBean {
    public String name;
    public String id;

    public OneBean() {
    }

    public OneBean(String name, String id) {
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
