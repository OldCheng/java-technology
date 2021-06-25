package main.java.com.test.chain;

public abstract class Leader {
    protected Leader leader;

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public abstract void handlerApply(ApplyModel applyModel);
}
