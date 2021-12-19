package Blocks;

public class OrderList extends Blocks {

    public OrderList(String orderList) {
        super(orderList);
    }

    // Render order list
    @Override
    public String render(String orderList) {
        return orderList.replaceAll("\\.\\s*", ". ");
    }
}
