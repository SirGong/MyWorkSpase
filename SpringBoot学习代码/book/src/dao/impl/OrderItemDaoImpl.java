package dao.impl;

import bean.OrderItem;
import dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`price`,`total_money`,`count`,`order_id`) values(?,?,?,?,?)";
        update(sql,orderItem.getName(),orderItem.getPrice(),orderItem.getTotalMoney(),orderItem.getCount(),orderItem.getOrderId());

    }
}
