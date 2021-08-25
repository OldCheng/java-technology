package main.java.com.introduction.serializable.second;

import java.io.Serializable;

public class Child extends Parent implements Serializable {


    private static final long serialVersionUID = 1l;

    private String id;

    public String getId() {
        return id;
    }

    public Child setId(String id) {
        this.id = id;
        return this;
    }

}
