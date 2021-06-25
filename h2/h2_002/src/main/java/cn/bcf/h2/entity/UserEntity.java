package cn.bcf.h2.entity;

public class UserEntity {

    private Integer id;
    private String username;
    private Integer sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                '}';
    }
}
