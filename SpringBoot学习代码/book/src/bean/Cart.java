package bean;


import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer, CartItem>();

    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //查看购物车是否存在该商品
        CartItem item = items.get(cartItem.getId());
        if(item == null){
            //添加商品
            items.put(cartItem.getId(), cartItem);
        }else{
            //已经添加过该商品,数量累加
            item.setCount(item.getCount()+1);
            //修改总金额
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     */
    public void deleteItem(Integer id){
        items.remove(id);

    }
    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();

    }
    /**
     * 修改商品数量
     */
    public void updateCount(Integer id,Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            //修改数量
            cartItem.setCount(count);
            //修改总价
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }



    public Integer getTotalCount() {
        int totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
