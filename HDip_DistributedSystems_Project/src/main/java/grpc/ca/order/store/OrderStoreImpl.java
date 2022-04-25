package grpc.ca.order.store;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class OrderStoreImpl implements OrderStore {
    ConcurrentHashMap<Integer, Order> store;

    public OrderStoreImpl() {
        store = new ConcurrentHashMap();
        for (int i = 1; i <= 3; i++) {
            Order order = new Order(i, "order" + i, new BigDecimal(new Random().nextFloat() * 100).setScale(2,  BigDecimal.ROUND_HALF_UP).floatValue());
            store.put(i, order);
        }
    }

    @Override
    public List<Order> queryOrders() {
        return store.values().stream().collect(Collectors.toList());
    }

    @Override
    public void updateOrder(int orderId, float price) {
        store.merge(orderId, new Order(orderId, "test" + orderId, price), Order::update);
    }

    @Override
    public Order getByOrderId(int orderId) {
        return store.get(orderId);
    }
}
