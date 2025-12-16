public class Order {
    private int orderId;
    private Customer customer;
    private Item item;
    private int quantity;

    public Order (int orderId, Customer customer, Item item, int quantity){
        this.orderId=orderId;
        this.customer=customer;
        this.item=item;
        this.quantity=quantity;
    }

    public int getOrderId() {return orderId;}
    public Customer getCustomer(){ return customer;}
    public Item getItem() {return item;}
    public int getQuantity() {return quantity;}

    public void setOrderId(int orderId){this.orderId=orderId;}
    public void setCustomer(Customer customer) {this.customer=customer;}
    public void setItem(Item item){this.item=item;}
    public void setQuantity(int quantity){this.quantity=quantity;}

    public double getTotalPrice() {
        return item.getPrice()*quantity;
    }

    public String getInformation(){
        return "Order:" + orderId + ": " +customer.getName()+
                " bought " + quantity+ " x "+ item.getName()+
                ", total: $ "+ getTotalPrice();
    }
}
