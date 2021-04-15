package main.java.com.testtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/4/8 10:45
 * @Version 1.0
 *
 *  * 1.新建一个商品类（包括id, price, product name)
 *  * 2.创建两个商品列表，自己随机插入一些商品数据到列表中
 *  * 3.将这两个商品列表进行合并
 *  * 4.对合并后的商品进行价格从低到高的排序
 */
public class Demo {

    public static void main(String[] args) {
        List<Product> list = getProduct();

        Collections.sort(list,new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });

        System.out.println(list);

    }

    public static List<Product> getProduct(){
        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product(1,2,"手机","a"));
        productList1.add(new Product(2,26,"电脑",""));

        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(5,11,"电脑212",""));
        productList2.add(new Product(3,55,"电脑1212",""));

        List<Product> productList = new ArrayList<>();
        productList1.forEach(p ->{
            productList.add(p);
        });
        productList2.forEach(p ->{
            productList.add(p);
        });
        return productList;
    }

}
