package service.impl;

import bean.*;
import dao.BookDao;
import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author ASUS
 * @Date 2020/6/23 13:03
 * @Version 1.0.0
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号,唯一性，时间戳加userId
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);
        //保存订单项
        //遍历购物车
        for(Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            //获取每个订单项
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(),cartItem.getTotalPrice() , orderId);
            //保存订单项
            orderItemDao.saveOrderItem(orderItem);
            //对数据库商品的库存和销量进行修改
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空
        cart.clear();
        return orderId;
    }
}
