import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        inventory.addProduct(new Electronics("Laptop", 999.99, 24));
        inventory.addProduct(new Clothing("T-Shirt", 29.99, "L"));
        inventory.addProduct(new Electronics("Smartphone", 499.99, 12));
        inventory.addProduct(new Clothing("Jeans", 79.99, "32"));

        System.out.println("Online shopping system");

        System.out.println("1. Products under $500: ");
        for (Product p: inventory.filterByPrice(500)){
            System.out.println("  "+p);
        }

        System.out.println("\n2. Search for 'laptop':");
        Product found = inventory.searchByName("laptop");
        System.out.println(" Result:" +(found !=null?found: "Not found"));

        System.out.println("\n3. Sorted by price:");
        for (Product p: inventory.sortByPrice()){
            System.out.println("  "+p);
        }

        System.out.println("\n4. Inheritance&Polymorphism:");
        Product[] products={
                new Electronics("Tablet", 299.99, 12),
                new Clothing("Jacket", 129.99,"XL")
        };
        for(Product p:products){
            System.out.println("  "+p.getName()+"-> Category: "+ p.getCategory());
        }

        System.out.println("\n5. Object methods demonstration:");
        Product p1=new Electronics("Test", 100.0, 6);
        Product p2=new Electronics("Test", 100.0, 12);
        System.out.println(" toString: "+p1);
        System.out.println(" equals: "+p1.equals(p2));
        System.out.println(" hashCode (same for equal objects): "+p1.hashCode()+"="+p2.hashCode());

        System.out.println("\n6. Interactive Scanner demo:");
        System.out.print(" Enter product name to search: ");
        String search=scanner.nextLine();
        Product result= inventory.searchByName(search);
        System.out.println(" Found: "+ (result!=null ? result: "Nothing"));

        scanner.close();
    }
}