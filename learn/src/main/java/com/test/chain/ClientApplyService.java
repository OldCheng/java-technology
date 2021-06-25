package main.java.com.test.chain;

public class ClientApplyService {

    public static void main(String[] args) {
        ApplyModel applyModel = new ApplyModel();
        applyModel.setApplyName("阿粉");
        applyModel.setContent("申请涨薪");
        applyModel.setSalary(500);

        Leader aLeader = new ALeader();
        Leader bLeader = new BLeader();
        Leader cLeader = new CLeader();
        Leader ceoLeader = new CEOLeader();
//        aLeader.setLeader(bLeader);
//        bLeader.setLeader(cLeader);
//        cLeader.setLeader(ceoLeader);
//
//        aLeader.handlerApply(applyModel);

        ceoLeader.handlerApply(applyModel);
    }
}
