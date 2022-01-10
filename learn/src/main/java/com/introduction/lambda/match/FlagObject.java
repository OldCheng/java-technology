package main.java.com.introduction.lambda.match;

public class FlagObject {

    private String name;

    private Boolean flag;

    public FlagObject(String name, Boolean flag) {
        this.name = name;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
