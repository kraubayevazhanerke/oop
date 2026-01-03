import java.util.Objects;

public abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getCategory();

    public String getName() {return name;}
    public double getPrice() {return price;}

    @Override
    public String toString(){
        return name + "-$" + price + "[" + getCategory() + "]";
    }

    @Override
    public boolean equals(Object obj){
        if (this==obj) return true;
        if(!(obj instanceof Product)) return false;
        Product p=(Product) obj;
        return Double.compare(p.price, price)==0&& name.equals(p.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,price);
    }
}