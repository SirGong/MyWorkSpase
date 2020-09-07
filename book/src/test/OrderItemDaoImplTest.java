package test;

import bean.OrderItem;
import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null, "Java11", 1, new BigDecimal(100), new BigDecimal(100), "165313"));
        orderItemDao.saveOrderItem(new OrderItem(null, "Java12", 2, new BigDecimal(100), new BigDecimal(200), "165313"));
        orderItemDao.saveOrderItem(new OrderItem(null, "Java13", 1, new BigDecimal(50), new BigDecimal(50), "165313"));
    }
}