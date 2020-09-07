package dao.impl;

import bean.Order;
import dao.OrderDao;

/**
 * @author ASUS
 * @Date 2020/6/23 12:09
 * @Version 1.0.0
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public void saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";
        update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
