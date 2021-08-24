package main.java.com.introduction.proxy.static1;

import main.java.com.introduction.proxy.UserService;
import main.java.com.introduction.proxy.UserServiceImpl;

public class UserServiceProxy implements UserService {

    UserService target;

    public UserServiceProxy(UserService target) {
        this.target = target;
    }

    @Override
    public void create() {
        before();
        target.create();
        after();
    }

    @Override
    public void update() {
        before();
        target.update();
        after();
    }


    void before() {
        System.out.println("-----------before---proxy--------");
    }

    void after() {
        System.out.println("-----------after---proxy--------");
    }

    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userServiceImpl);
        proxy.create();
        proxy.update();
    }
}
