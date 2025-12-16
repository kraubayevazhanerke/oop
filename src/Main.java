public class Main{
    public static void main(String[] args) {
        System.out.println("Online Shopping System\n");

        Item hoodie = new Item(1, "Hoodie", 39.99);
        Item jeans = new Item(2,"Jeans", 49.99 );

        System.out.println("1. Items:");
        System.out.println(hoodie.getInformation());
        System.out.println(jeans.getInformation());

        Customer customer1 = new Customer(1, "Kraubayeva Zhanerke", "zhanerke@gmail.com");
        Customer customer2 = new Customer(2, "Abai Aisha", "aisha@gmail.com");

        System.out.println("\n2. Customers:");
        System.out.println(customer1.getInformation());
        System.out.println(customer2.getInformation());

        Order order1 = new Order(1, customer1, hoodie, 1);
        Order order2 = new Order(2, customer2, jeans, 2);

        System.out.println("\n3. Orders:" );
        System.out.println(order1.getInformation());
        System.out.println(order2.getInformation());

        if (hoodie.getPrice()>jeans.getPrice()){
            System.out.println(hoodie.getName() + " is more expensive than " + jeans.getName());
        } else {
            System.out.println(jeans.getName() + " is more expensive than " + hoodie.getName());
        }

        if (order1.getTotalPrice()> order2.getTotalPrice()){
            System.out.println("Order"+ order1.getOrderId()+" is more expensive");
        } else {
            System.out.println("Order"+order2.getOrderId()+" is more expensive");
        }
    }
}