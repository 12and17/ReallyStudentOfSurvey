package club.small.entity;

import java.sql.Timestamp;

public class Problem {
    //问题的id
    private int problemId;
    //处理问题教师的账号
    private String messengerAccount;
    //问题的类型
    private String problemType;
    //问题的描述
    private String problemDescribe;
    //问题的处理时间
    private Timestamp processTime;
    //问题的处理教师
    private String processTeacherAccount;
    //问题的处理过程
    private String processCourse;
    //是否已确认
    private int isConfirm;
    //是否已处理
    private int isProcess;
    //提交时间
    private Timestamp submitTime;
    //是否已经分配老师
    private int isAssignmentTeacher;
    //分配老师时间
    private Timestamp assignmentTime;
    //是否回退给学生
    private int isReject;
    //回退时间
    private Timestamp rejectTime;
    //是否同意
    private int isAgree;
    //同意的时间
    private Timestamp agreeTime;
   //是否返回给老师
    private int isToTeacher;
    //返回给老师的时间
    private Timestamp toTeacherTime;
    //自己增加的字段，问题的班级
    private String className;
    //驳回的理由
    private String rejectReason;
    //给老师退回的理由
    private String toTeacherReason;
    //确认的时间
    private Timestamp confirmTime;
    //教师的姓名
    private String teacherName;

    public Problem(){

    }

    public Problem(int problemId, String messengerAccount, String problemType, String problemDescribe, Timestamp processTime, String processTeacherAccount, String processCourse, int isConfirm, int isProcess, Timestamp submitTime, int isAssignmentTeacher, Timestamp assignmentTime, int isReject, Timestamp rejectTime, int isAgree, Timestamp agreeTime, int isToTeacher, Timestamp toTeacherTime, String className, String rejectReason) {
        this.problemId = problemId;
        this.messengerAccount = messengerAccount;
        this.problemType = problemType;
        this.problemDescribe = problemDescribe;
        this.processTime = processTime;
        this.processTeacherAccount = processTeacherAccount;
        this.processCourse = processCourse;
        this.isConfirm = isConfirm;
        this.isProcess = isProcess;
        this.submitTime = submitTime;
        this.isAssignmentTeacher = isAssignmentTeacher;
        this.assignmentTime = assignmentTime;
        this.isReject = isReject;
        this.rejectTime = rejectTime;
        this.isAgree = isAgree;
        this.agreeTime = agreeTime;
        this.isToTeacher = isToTeacher;
        this.toTeacherTime = toTeacherTime;
        this.className = className;
        this.rejectReason = rejectReason;
    }

    public Problem(int problemId, String messengerAccount, String problemType, String problemDescribe, Timestamp processTime, String processTeacherAccount, String processCourse, int isConfirm, int isProcess, Timestamp submitTime, int isAssignmentTeacher, Timestamp assignmentTime, int isReject, Timestamp rejectTime, int isAgree, Timestamp agreeTime, int isToTeacher, Timestamp toTeacherTime, String className, String rejectReason, String toTeacherReason, Timestamp confirmTime) {
        this.problemId = problemId;
        this.messengerAccount = messengerAccount;
        this.problemType = problemType;
        this.problemDescribe = problemDescribe;
        this.processTime = processTime;
        this.processTeacherAccount = processTeacherAccount;
        this.processCourse = processCourse;
        this.isConfirm = isConfirm;
        this.isProcess = isProcess;
        this.submitTime = submitTime;
        this.isAssignmentTeacher = isAssignmentTeacher;
        this.assignmentTime = assignmentTime;
        this.isReject = isReject;
        this.rejectTime = rejectTime;
        this.isAgree = isAgree;
        this.agreeTime = agreeTime;
        this.isToTeacher = isToTeacher;
        this.toTeacherTime = toTeacherTime;
        this.className = className;
        this.rejectReason = rejectReason;
        this.toTeacherReason = toTeacherReason;
        this.confirmTime = confirmTime;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getMessengerAccount() {
        return messengerAccount;
    }

    public void setMessengerAccount(String messengerAccount) {
        this.messengerAccount = messengerAccount;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getProblemDescribe() {
        return problemDescribe;
    }

    public void setProblemDescribe(String problemDescribe) {
        this.problemDescribe = problemDescribe;
    }

    public Timestamp getProcessTime() {
        return processTime;
    }

    public void setProcessTime(Timestamp processTime) {
        this.processTime = processTime;
    }

    public String getprocessTeacherAccount() {
        return processTeacherAccount;
    }

    public void setprocessTeacherAccount(String processTeacherAccount) {
        this.processTeacherAccount = processTeacherAccount;
    }

    public String getProcessCourse() {
        return processCourse;
    }

    public void setProcessCourse(String processCourse) {
        this.processCourse = processCourse;
    }

    public int getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(int isConfirm) {
        this.isConfirm = isConfirm;
    }

    public int getIsProcess() {
        return isProcess;
    }

    public void setIsProcess(int isProcess) {
        this.isProcess = isProcess;
    }

    public Timestamp getSumbitTime() {
        return submitTime;
    }

    public void setSumbitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public int getIsAssignmentTeacher() {
        return isAssignmentTeacher;
    }

    public void setIsAssignmentTeacher(int isAssignmentTeacher) {
        this.isAssignmentTeacher = isAssignmentTeacher;
    }

    public Timestamp getAssignmentTime() {
        return assignmentTime;
    }

    public void setAssignmentTime(Timestamp assignmentTime) {
        this.assignmentTime = assignmentTime;
    }

    public int getIsReject() {
        return isReject;
    }

    public void setIsReject(int isReject) {
        this.isReject = isReject;
    }

    public Timestamp getRejectTime() {
        return rejectTime;
    }

    public void setRejectTime(Timestamp rejectTime) {
        this.rejectTime = rejectTime;
    }

    public int getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(int isAgree) {
        this.isAgree = isAgree;
    }

    public Timestamp getAgreeTime() {
        return agreeTime;
    }

    public void setAgreeTime(Timestamp agreeTime) {
        this.agreeTime = agreeTime;
    }

    public int getIsToTeacher() {
        return isToTeacher;
    }

    public void setIsToTeacher(int isToTeacher) {
        this.isToTeacher = isToTeacher;
    }

    public Timestamp getToTeacherTime() {
        return toTeacherTime;
    }

    public void setToTeacherTime(Timestamp toTeacherTime) {
        this.toTeacherTime = toTeacherTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getToTeacherReason() {
        return toTeacherReason;
    }

    public void setToTeacherReason(String toTeacherReason) {
        this.toTeacherReason = toTeacherReason;
    }

    public Timestamp getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Timestamp confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "problemId=" + problemId +
                ", messengerAccount='" + messengerAccount + '\'' +
                ", problemType='" + problemType + '\'' +
                ", problemDescribe='" + problemDescribe + '\'' +
                ", processTime=" + processTime +
                ", processTeacherAccount='" + processTeacherAccount + '\'' +
                ", processCourse='" + processCourse + '\'' +
                ", isConfirm=" + isConfirm +
                ", isProcess=" + isProcess +
                ", submitTime=" + submitTime +
                ", isAssignmentTeacher=" + isAssignmentTeacher +
                ", assignmentTime=" + assignmentTime +
                ", isReject=" + isReject +
                ", rejectTime=" + rejectTime +
                ", isAgree=" + isAgree +
                ", agreeTime=" + agreeTime +
                ", isToTeacher=" + isToTeacher +
                ", toTeacherTime=" + toTeacherTime +
                ", className='" + className + '\'' +
                ", rejectReason='" + rejectReason + '\'' +
                ", toTeacherReason='" + toTeacherReason + '\'' +
                ", confirmTime=" + confirmTime +
                '}';
    }
}
