package club.small.entity;

public class Leader {
    //领导的账号
    private String leaderAccount;
    //领导的密码
    private String leaderPassword;
    //领导的姓名
    private String leaderName;
    //领导的邮箱
    private String email;

    public Leader(String leaderAccount, String leaderPassword, String leaderName) {
        this.leaderAccount = leaderAccount;
        this.leaderPassword = leaderPassword;
        this.leaderName = leaderName;
    }

    public Leader(String leaderAccount, String leaderPassword, String leaderName, String email) {
        this.leaderAccount = leaderAccount;
        this.leaderPassword = leaderPassword;
        this.leaderName = leaderName;
        this.email = email;
    }

    public String getLeaderAccount() {
        return leaderAccount;
    }

    public void setLeaderAccount(String leaderAccount) {
        this.leaderAccount = leaderAccount;
    }

    public String getLeaderPassword() {
        return leaderPassword;
    }

    public void setLeaderPassword(String leaderPassword) {
        this.leaderPassword = leaderPassword;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Leader{" +
                "leaderAccount='" + leaderAccount + '\'' +
                ", leaderPassword='" + leaderPassword + '\'' +
                ", leaderName='" + leaderName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
