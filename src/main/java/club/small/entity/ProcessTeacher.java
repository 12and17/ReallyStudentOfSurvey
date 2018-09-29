package club.small.entity;

public class ProcessTeacher {
    //处理教师的账号
    private String processTeacherAccount;
    //处理教师的密码
    private String processTeacherPassword;
    //处理教师的类型
    private String processTeacherType;
    //处理教师的姓名
    private String processTeacherName;
    //处理教师的邮箱
    private String email;

    public ProcessTeacher(String processTeacherAccount, String processTeacherPassword, String processTeacherType, String processTeacherName) {
        this.processTeacherAccount = processTeacherAccount;
        this.processTeacherPassword = processTeacherPassword;
        this.processTeacherType = processTeacherType;
        this.processTeacherName = processTeacherName;
    }

    public ProcessTeacher(String processTeacherAccount, String processTeacherPassword, String processTeacherType, String processTeacherName, String email) {
        this.processTeacherAccount = processTeacherAccount;
        this.processTeacherPassword = processTeacherPassword;
        this.processTeacherType = processTeacherType;
        this.processTeacherName = processTeacherName;
        this.email = email;
    }

    public ProcessTeacher(String processTeacherAccount, String processTeacherType, String processTeacherName) {
        this.processTeacherAccount = processTeacherAccount;
        this.processTeacherType = processTeacherType;
        this.processTeacherName = processTeacherName;
    }

    public String getProcessTeacherAccount() {
        return processTeacherAccount;
    }

    public void setProcessTeacherAccount(String processTeacherAccount) {
        this.processTeacherAccount = processTeacherAccount;
    }

    public String getProcessTeacherPassword() {
        return processTeacherPassword;
    }

    public void setProcessTeacherPassword(String processTeacherPassword) {
        this.processTeacherPassword = processTeacherPassword;
    }

    public String getProcessTeacherType() {
        return processTeacherType;
    }

    public void setProcessTeacherType(String processTeacherType) {
        this.processTeacherType = processTeacherType;
    }

    public String getProcessTeacherName() {
        return processTeacherName;
    }

    public void setProcessTeacherName(String processTeacherName) {
        this.processTeacherName = processTeacherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ProcessTeacher{" +
                "processTeacherAccount='" + processTeacherAccount + '\'' +
                ", processTeacherPassword='" + processTeacherPassword + '\'' +
                ", processTeacherType='" + processTeacherType + '\'' +
                ", processTeacherName='" + processTeacherName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
