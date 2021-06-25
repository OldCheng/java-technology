package main.java.com.test.chain;

public class ApplyModel {

    //申请人名称
    private String applyName;
    //工单类型
    private String type;
    //工单内容
    private String content;
    //涨薪幅度
    private int salary;

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
