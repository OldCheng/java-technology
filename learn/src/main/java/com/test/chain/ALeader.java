package main.java.com.test.chain;

public class ALeader extends Leader {

    protected Leader leader;
    @Override
    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    @Override
    public void handlerApply(ApplyModel applyModel) {
        if (applyModel.getSalary() < 100) {
            System.out.println("申请金额为" + applyModel.getSalary() + "小于 100，A 可以处理");
        } else {
            leader.handlerApply(applyModel);
        }
    }
}
