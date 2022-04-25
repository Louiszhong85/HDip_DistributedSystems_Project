package grpc.ca.order.store;


import java.util.List;


public interface OrderStore {

    // query order list
    List<Order> queryOrders();

    // update order
    void updateOrder(int orderId, float price);

    // query order
    Order getByOrderId(int orderId);
}

