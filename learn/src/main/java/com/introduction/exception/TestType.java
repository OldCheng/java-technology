package main.java.com.introduction.exception;

public class TestType {
    public static void main(String[] args) {

        try {
            int i=9/0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("e:-------"+e);
            System.out.println("e.getMessage----"+e.getMessage());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getStackTrace()[0].getClassName());
            System.out.println(e.getStackTrace()[0].getFileName());
            System.out.println(e.getStackTrace()[0].getLineNumber());
            System.out.println(e.getStackTrace()[0].getMethodName());

            StackTraceElement[] stackTrace = e.getStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception:"+e+"\n");
            stringBuilder.append("file:"+stackTrace[0].getClassName()+"\n");
            stringBuilder.append("method:"+stackTrace[0].getMethodName()+"\n");
            stringBuilder.append("line:"+stackTrace[0].getLineNumber());
            System.out.println(stringBuilder);
        }

    }
}
