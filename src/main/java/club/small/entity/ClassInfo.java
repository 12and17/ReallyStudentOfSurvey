package club.small.entity;

public class ClassInfo {
    //班级id
    private int classId;
    //班级名称
    private String className;
    //班级含有的信息员数量
    private int messengerNum = 0;

    public ClassInfo(int classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public ClassInfo(int classId, String className, int messengerNum) {
        this.classId = classId;
        this.className = className;
        this.messengerNum = messengerNum;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public int getMessengerNum() {
        return messengerNum;
    }

    public void setMessengerNum(int messengerNum) {
        this.messengerNum = messengerNum;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", messengerNum=" + messengerNum +
                '}';
    }
}
