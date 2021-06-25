package main.java.com.test.chain;

public class BLeader extends Leader {

    protected Leader leader;
    @Override
    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    @Override
    public void handlerApply(ApplyModel applyModel) {
        if (applyModel.getSalary() < 300) {
            System.out.println("申请金额为" + applyModel.getSalary() + "小于 300，B 可以处理");
        } else {
            leader.handlerApply(applyModel);
        }
    }
}
