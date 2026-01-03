import java.util.ArrayList;
import java.util.List;

public class Inventory{
    private List<Product> products=new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> filterByPrice(double maxPrice){
        List<Product> result=new ArrayList<>();
        for (Product p: products){
            if (p.getPrice()<=maxPrice) result.add(p);
        }
        return result;
    }

    public Product searchByName(String name){
        for (Product p: products){
            if(p.getName().toLowerCase().contains(name.toLowerCase())){
                return p;
            }
        }
        return null;
    }

    public List<Product> sortByPrice(){
        List<Product> sorted = new ArrayList<>(products);
        for (int i=0; i<sorted.size()-1; i++){
            for (int j=0; j<sorted.size()-i-1; j++){
                if(sorted.get(j).getPrice()>sorted.get(j+1).getPrice()){
                    Product temp=sorted.get(j);
                    sorted.set(j, sorted.get(j+1));
                    sorted.set(j+1,temp);
                }
            }
        }
        return sorted;
    }
}