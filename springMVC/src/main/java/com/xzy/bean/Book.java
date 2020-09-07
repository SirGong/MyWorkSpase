package com.xzy.bean;
/*
<form method="post" action="/springMVC/book">
        书名：<input type="text" name="name"/><br>
        作者：<input type="text" name="author"/><br>
        价格：<input type="text" name="price"/><br>
        库存：<input type="text" name="stock"/><br>
        销量：<input type="text" name="sales"/><br>
<input type="submit" value="保存"/><br>
</form>*/

public class Book {
    private  String name;
    private  String author;
    private Double price;
    private Integer stock;
    private Integer sales;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sales=" + sales +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
