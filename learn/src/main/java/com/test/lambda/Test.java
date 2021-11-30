package main.java.com.test.lambda;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(6);
        list1.retainAll(list2);


        new Test().asd();

        ArrayList<Integer> squared = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            squared.add(i*i);
        }

        int ddgg = dg(100);
        System.out.println(ddgg);

        SUB SS = new SUB();
        SS.setSs("aaaa");

        Class<? extends SUB> aClass = SS.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        Field[] declaredFields = aClass.getDeclaredFields();
        Class<?>[] declaredClasses = aClass.getDeclaredClasses();
        Field ss = aClass.getDeclaredField("ss");
        Object o = ss.get(SS);

        Consumer<String> c1 = System.out::println;
        c1.accept("1");

//        Stream st= Arrays.asList(1,2,3,4,5).stream().filter(x->{
//            System.out.println(x);
//            return  x>3;
//        });
//        st.forEach(System.out::println);

        List<Student> studentList1 = new ArrayList<>();
        studentList1.add(new Student("黎明", 20, new BigDecimal(80), 1));
        studentList1.add(new Student("郭敬明", 22, new BigDecimal(90), 2));
        studentList1.add(new Student("黎明", 21, new BigDecimal(65.5), 3));
        studentList1.add(new Student("黎明", 21, new BigDecimal(64.5), 3));
        //studentList1.stream().distinct().forEach(x -> System.out.println(x.getStuName()));
        Map<Integer, Student> collect = new HashMap<>();
        try {
            collect = studentList1.stream().distinct().collect(Collectors.toMap(Student::getAge, Function.identity()));
        }catch (Exception e){

        }

//        TreeMap<Integer, Student> collect1 = studentList1.stream()
//                .collect(Collectors.toMap(Student::getAge, Function.identity(),
//                        (ev1, ev2) -> {
//                            throw new IllegalStateException();
//                        }, TreeMap::new
//                ));

        Map<Integer, Student> collect2 = studentList1.stream()
                .collect(Collectors.toMap(Student::getAge, Function.identity(),
                        (ev1, ev2) -> ev2
                ));


        Locale[] availableLocales = Locale.getAvailableLocales();

        Stream<Locale> locales = Stream.of(availableLocales);

        Map<String, Set<String>> collect4 = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage(l)),
                        (a, b) -> {
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }
                ));


        Student s = new Student("黎明", 20, new BigDecimal(80), 1);
        Optional<Student> s1 = Optional.ofNullable(s);

        System.out.println(collect);

        int pageIndex=1;
        int pageSize=5;

        List<Student> studentList = getStudent();
        //studentList.stream().skip((pageIndex-1)*pageSize).limit(pageSize).forEach(x -> System.out.println(x.getStuName()));

        studentList.stream().skip(1).limit(6).forEach(x -> System.out.println(x.getStuName()));

//        studentList.stream().distinct().forEach(x -> System.out.println(x.getStuName()));
//
//        Map<Integer, Long> collect = studentList.stream().collect(Collectors.groupingBy(x -> x.getAge(), Collectors.counting()));
//        System.out.println(studentList.stream().collect(Collectors.groupingBy(x->x.getAge(),Collectors.counting())));

    }
    
    
    public static List<Student> getStudent(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("黎  明", 20, new BigDecimal(80), 1));
        studentList.add(new Student("郭敬明", 22, new BigDecimal(90), 2));
        studentList.add(new Student("明  道", 21, new BigDecimal(65.5), 3));
        studentList.add(new Student("郭富城", 30, new BigDecimal(90.5), 4));
        studentList.add(new Student("刘诗诗", 20, new BigDecimal(75), 1));
        studentList.add(new Student("成  龙", 60, new BigDecimal(88), 5));
        studentList.add(new Student("郑伊健", 60, new BigDecimal(86), 1));
        studentList.add(new Student("刘德华", 40, new BigDecimal(81), 1));
        studentList.add(new Student("古天乐", 50, new BigDecimal(83), 2));
        studentList.add(new Student("赵文卓", 40, new BigDecimal(84), 2));
        studentList.add(new Student("吴奇隆", 30, new BigDecimal(86), 4));
        studentList.add(new Student("言承旭", 50, new BigDecimal(68), 1));
        studentList.add(new Student("郑伊健", 60, new BigDecimal(86), 1));
        studentList.add(new Student("黎  明", 20, new BigDecimal(80), 1));
        studentList.add(new Student("李连杰", 65, new BigDecimal(86), 4));
        studentList.add(new Student("周润发", 69, new BigDecimal(58), 1));
        studentList.add(new Student("徐若萱", 28, new BigDecimal(88), 6));
        studentList.add(new Student("许慧欣", 26, new BigDecimal(86), 8));
        studentList.add(new Student("陈慧琳", 35, new BigDecimal(64), 1));
        studentList.add(new Student("关之琳", 45, new BigDecimal(50), 9));
        studentList.add(new Student("温碧霞", 67, new BigDecimal(53), 2));
        studentList.add(new Student("林青霞", 22, new BigDecimal(56), 3));
        studentList.add(new Student("李嘉欣", 25, new BigDecimal(84), 1));
        studentList.add(new Student("彭佳慧", 26, new BigDecimal(82), 5));
        studentList.add(new Student("陈紫涵", 39, new BigDecimal(88), 1));
        studentList.add(new Student("张韶涵", 41, new BigDecimal(90), 6));
        studentList.add(new Student("梁朝伟", 58, new BigDecimal(74), 1));
        studentList.add(new Student("梁咏琪", 65, new BigDecimal(82), 7));
        studentList.add(new Student("范玮琪", 22, new BigDecimal(83), 1));
        return studentList;
    }

    public static int dg(int d){
        if(d<=1){
            return d;
        }
        return d + dg(d-1);
    }

    public void asd(){
        SUB sub = new SUB();
        sub.asd="asas";
        System.out.println(sub);
    }
}
