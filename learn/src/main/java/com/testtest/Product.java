package main.java.com.testtest;

/**
 * @Description
 * @Author 程杰
 * @Date 2021/4/8 10:43
 * @Version 1.0
 *
 * 1.新建一个商品类（包括id, price, product name)
 * 2.创建两个商品列表，自己随机插入一些商品数据到列表中
 * 3.将这两个商品列表进行合并
 * 4.对合并后的商品进行价格从低到高的排序
 *
 */


public class Product {

    private int id;

    private int price;

    private String product;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(int id, int price, String product, String name) {
        this.id = id;
        this.price = price;
        this.product = product;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", product='" + product + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
