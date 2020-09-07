package service;

import bean.Cart;

public interface OrderService {
    String createOrder(Cart cart ,Integer userId);
}
