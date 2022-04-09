package mvc.bean;

/**
 * @author ： CodeWater
 * @create ：2022-04-08-21:33
 * @Function Description ：
 * 获取请求参数的实体类，属性名要和请求参数一致！
 */
public class User {
    private Integer id;
    private String username ;
    private String password;
    private Integer age;
    private String sex;
    private String email;
    
    public User(){}
    
    public User( Integer id , String username , String password , Integer age , String sex , String email ){
        this.id = id;
        this.username = username;
        this.password = password ;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
