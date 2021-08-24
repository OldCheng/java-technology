package main.java.com.introduction.proxy;


public class UserServiceImpl implements UserService {
    @Override
    public void create() {
        System.out.println("-----------create-----------");
    }

    @Override
    public void update() {
        System.out.println("-----------update-----------");
    }

}
