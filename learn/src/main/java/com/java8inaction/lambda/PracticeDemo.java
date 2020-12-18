package main.java.com.java8inaction.lambda;

import main.java.com.introduction.entity.Trader;
import main.java.com.introduction.entity.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * @Author 程杰
 * @Date 2020/12/16 20:08
 * @Version 1.0
 */
public class PracticeDemo {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        System.out.println("-----------------1----------------");
        //(1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(x -> x.getValue()))
                .collect(Collectors.toList())
                .forEach(x-> System.out.println(x));
        System.out.println("-----------------2----------------");
        //(2) 交易员都在哪些不同的城市工作过？
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(x-> System.out.println(x));
        System.out.println("-----------------3----------------");
        //(3) 查找所有来自于剑桥的交易员，并按姓名排序。
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList())
                .forEach(z-> System.out.println(z.getName()));
        System.out.println("-----------------4----------------");
        //(4) 返回所有交易员的姓名字符串，按字母顺序排序。
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("-----------------4----------------");
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(s-> s.getName().split(""))
                .flatMap(Arrays::stream)
                .distinct().sorted().collect(Collectors.joining());
        String traderStr1 =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining());
        System.out.println("-----------------5----------------");
        //(5) 有没有交易员是在米兰工作的？
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .anyMatch(trader -> "Milan".equals(trader.getCity())));

        transactions.stream()
                .anyMatch(transaction -> "Milan"
                        .equals(transaction.getTrader()
                                .getCity()));
        System.out.println("-----------------6----------------");
        //(6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue).forEach(System.out::println);
        System.out.println("-----------------7----------------");
        //(7) 所有交易中，最高的交易额是多少？
        Optional<Integer> highestValue =
                transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(Integer::max);

        System.out.println("-----------------8----------------");
        //(8) 找到交易额最小的交易。
        transactions.stream()
                .reduce((t1, t2) ->
                        t1.getValue() < t2.getValue() ? t1 : t2);

                transactions.stream()
                        .min(comparing(Transaction::getValue)).ifPresent(System.out::println);
    }
}
