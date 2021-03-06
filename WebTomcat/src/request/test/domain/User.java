package request.test.domain;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-12:13
 * @Function Description ：
 * 用户的实体类
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHehe() {
        return gender;
    }

    public void setHehe(String gender) {
        this.gender = gender;
    }
}
