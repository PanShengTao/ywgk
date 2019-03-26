package cc.lecent.ywgk.data.entity;

/**
 * <pre>
 *     author : ylw
 *     e-mail : bigoatsm@gmail.com
 *     time   : 19-3-7
 *     desc   :
 * </pre>
 */
public class Login {
    // Token
    private String accessToken;
    // 年龄
    private int age;
    // 人脸token
    private String faceToken;
    // 是否第一次登录
    private boolean firstLogin;
    // 手机号码
    private String phoneNo;
    // 1：男  2：女 其他未知
    private int sex;
    // 用户名
    private String userName;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public boolean isFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Login{" +
                "accessToken='" + accessToken + '\'' +
                ", age=" + age +
                ", faceToken='" + faceToken + '\'' +
                ", firstLogin=" + firstLogin +
                ", phoneNo='" + phoneNo + '\'' +
                ", sex=" + sex +
                ", userName='" + userName + '\'' +
                '}';
    }
}
