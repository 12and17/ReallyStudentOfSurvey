package club.small.entity;

public class Messenger {
    //信息员的账号
    private String messAccount;
    //信息员的密码
    private String messPassword;
    //信息员所对应的班级id
    private int classId;
    //信息员的班级
    private String className;
    //信息员的邮箱
    private String email;

    public Messenger(String messAccount, String messPassword, int classId, String email) {
        this.messAccount = messAccount;
        this.messPassword = messPassword;
        this.classId = classId;
        this.email = email;
    }

    public String getMessAccount() {
        return messAccount;
    }

    public void setMessAccount(String messAccount) {
        this.messAccount = messAccount;
    }

    public String getMessPassword() {
        return messPassword;
    }

    public void setMessPassword(String messPassword) {
        this.messPassword = messPassword;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Messenger{" +
                "messAccount='" + messAccount + '\'' +
                ", messPassword='" + messPassword + '\'' +
                ", classId=" + classId +
                ", email='" + email + '\'' +
                '}';
    }
}
