import java.util.HashMap;
import java.util.Map;

abstract class Order implements Cloneable {
    protected String Order_name;
    protected int Order_id;

    abstract void addOrder();

    //Implementing Clone method
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    abstract void getOrder_Id();

    abstract void get_OrderName();

}

class FoodOrder extends Order {

    @Override
    void addOrder() {
        System.out.println("Food is Ordered");
    }

    @Override
    void getOrder_Id() {
        this.Order_id = 1234;
        System.out.println("The order id is : " + this.Order_id);
    }

    @Override
    void get_OrderName() {
        this.Order_name = "Pizza";
        System.out.println("The order is of : " + this.Order_name);
    }


}

class GarmentOrder extends Order {
    public void getOrder_id() {
        this.Order_id = 1234;
    }

    @Override
    void addOrder() {
        System.out.println("Clothes are Ordered");
    }

    void getOrder_Id() {
        this.Order_id = 5678;
        System.out.println("The order id is : " + this.Order_id);
    }

    @Override
    void get_OrderName() {
        this.Order_name = "JAcket";
        System.out.println("The order is of : " + this.Order_name);
    }
}

class OrderStore {
    private static Map<String, Order> OrderMap = new HashMap<String, Order>();


    //Implementing static block which is always run first when the class loader load the class in memory
    static {
        OrderMap.put("Food", new FoodOrder());
        OrderMap.put("Garment", new GarmentOrder());
    }

    public static Order getOrder(String OrderName) {

        return (Order) OrderMap.get(OrderName).clone();
    }

}

class Test {
    public static void main(String[] args) {
        System.out.println("ORDER STORE ");
        OrderStore.getOrder("Food").addOrder();
        OrderStore.getOrder("Food").getOrder_Id();
        OrderStore.getOrder("Food").get_OrderName();

        System.out.println("=======================================================");

        OrderStore.getOrder("Garment").addOrder();
        OrderStore.getOrder("Garment").getOrder_Id();
        OrderStore.getOrder("Garment").get_OrderName();

    }
}