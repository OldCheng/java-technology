package main.java.com.thinkinjava.annotations;

import java.util.List;

/**
 * @Author 程杰
 * @Date 2021/1/19 19:42
 * @Version 1.0
 */
public class PasswordUtils {

    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean validatePassword(String password){
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "new password can not equal previous used one")
    public boolean checkForNewPassword(List<String> prevPassword, String password){
        return !prevPassword.contains(password);
    }

    public static void main(String[] args) {
        PasswordUtils passwordUtils = new PasswordUtils();
        System.out.println(passwordUtils.encryptPassword(""));

    }
}
