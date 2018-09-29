package club.small.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("empty")
public class Empty {
    @Value("false")
    private String imformation;
    private String processTeacherAccount;
    private String processTeacherName;

    public Empty(){

    }

    public Empty(String imformation) {
        this.imformation = imformation;
    }

    public String getProcessTeacherAccount() {
        return processTeacherAccount;
    }

    public void setProcessTeacherAccount(String processTeacherAccount) {
        this.processTeacherAccount = processTeacherAccount;
    }

    public String getProcessTeacherName() {
        return processTeacherName;
    }

    public void setProcessTeacherName(String processTeacherName) {
        this.processTeacherName = processTeacherName;
    }

    public String getImformation() {
        return imformation;
    }

    public void setImformation(String imformation) {
        this.imformation = imformation;
    }
}
