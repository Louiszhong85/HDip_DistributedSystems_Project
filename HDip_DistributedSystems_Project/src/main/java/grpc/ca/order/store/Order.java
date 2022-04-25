package grpc.ca.order.store;

public class Order {

    public Order(int orderId, String orderName, float price) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.price = price;
    }

    private int orderId;

    private String orderName;

    private float price;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static Order update(Order prev, Order newValue) {
        prev.setPrice(newValue.getPrice());
        return prev;
    }
}

