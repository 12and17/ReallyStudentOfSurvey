package club.small.entity;

public class Charge {
    //管理人员的账号
    private String chargeAccount;
    //管理人员的密码
    private String chargePassword;
    //管理人员的姓名
    private String chargeName;
    //管理人员的邮箱
    private String email;

    public Charge(String chargeAccount, String chargePassword, String chargeName) {
        this.chargeAccount = chargeAccount;
        this.chargePassword = chargePassword;
        this.chargeName = chargeName;
    }

    public Charge(String chargeAccount, String chargePassword, String chargeName, String email) {
        this.chargeAccount = chargeAccount;
        this.chargePassword = chargePassword;
        this.chargeName = chargeName;
        this.email = email;
    }

    public String getChargeAccount() {
        return chargeAccount;
    }

    public void setChargeAccount(String chargeAccount) {
        this.chargeAccount = chargeAccount;
    }

    public String getChargePassword() {
        return chargePassword;
    }

    public void setChargePassword(String chargePassword) {
        this.chargePassword = chargePassword;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "chargeAccount='" + chargeAccount + '\'' +
                ", chargePassword='" + chargePassword + '\'' +
                ", chargeName='" + chargeName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
