package main.java.com.introduction.thread.deadLock;

public class ResourceSync {

    private String name;

    private int resource;

    public ResourceSync() {
    }
    public ResourceSync(String name, int resource) {
        this.name = name;
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    synchronized int doSome(){
        return ++resource;
    }

    synchronized void cooperate(ResourceSync r){
        r.doSome();
        System.out.printf("%s 整合 %s 的资源%n", this.getName(), r.getName(),r.getResource());
    }


}
