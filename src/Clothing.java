public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size){
        super(name, price);
        this.size=size;
    }

    @Override
    public String getCategory(){
        return "Clothes";
    }

    public String getSize(){return size;}

    @Override
    public String toString(){
        return super.toString()+"(Size: "+size+")";
    }
}
