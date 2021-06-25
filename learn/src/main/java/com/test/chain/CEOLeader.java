package main.java.com.test.chain;

public class CEOLeader extends Leader {

    protected Leader leader;
    @Override
    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    @Override
    public void handlerApply(ApplyModel applyModel) {
        if (applyModel.getSalary() < 1000) {
            System.out.println("申请金额为" + applyModel.getSalary() + "小于 1000，CEO 同意了");
        } else {
            System.out.println("想涨薪" + applyModel.getSalary() + "这么多，下次吧");
        }
    }
}
