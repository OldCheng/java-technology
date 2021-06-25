package main.java.com.test.chain;

public class CLeader extends Leader {

    protected Leader leader;
    @Override
    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    @Override
    public void handlerApply(ApplyModel applyModel) {
        if (applyModel.getSalary() < 500) {
            System.out.println("申请金额为" + applyModel.getSalary() + "小于 500，C 可以处理");
        } else {
            leader.handlerApply(applyModel);
        }
    }
}
