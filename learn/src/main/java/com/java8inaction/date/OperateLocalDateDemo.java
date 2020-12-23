package main.java.com.java8inaction.date;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * @Author 程杰
 * @Date 2020/12/23 15:22
 * @Version 1.0
 */
public class OperateLocalDateDemo {
    public static void main(String[] args) {
        // 2014-03-18
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        // 2011-03-18
        LocalDate date2 = date1.withYear(2011);
        // 2011-03-25
        LocalDate date3 = date2.withDayOfMonth(25);
        // 2011-09-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
        System.out.println(date1);System.out.println(date2);System.out.println(date3);System.out.println(date4);

    }
    
    /**方法名  是否是静态方法         描 述
     * from         是       依据传入的 Temporal 对象创建对象实例
     * now          是       依据系统时钟创建 Temporal 对象
     * of           是       由 Temporal 对象的某个部分创建该对象的实例
     * parse        是        由字符串创建 Temporal 对象的实例
     * atOffset     否        将 Temporal 对象和某个时区偏移相结合
     * atZone       否       将 Temporal 对象和某个时区相结合
     * format       否       使用某个指定的格式器将Temporal对象转换为字符串（Instant类不提供该方法）
     * get          否       读取 Temporal 对象的某一部分的值
     * minus        否      创建 Temporal 对象的一个副本，通过将当前 Temporal 对象的值减去一定的时长创建该副本
     * plus         否      创建 Temporal 对象的一个副本，通过将当前 Temporal 对象的值加上一定的时长创建该副本
     * with         否      以该 Temporal 对象为模板，对某些状态进行修改创建该对象的副本
     */
}
