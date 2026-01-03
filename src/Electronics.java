public class Electronics extends Product {
    private int warrantyMonths;

    public Electronics(String name, double price, int warrantyMonths){
        super(name,price);
        this.warrantyMonths=warrantyMonths;
    }

    @Override
    public String getCategory(){return "Electronics";}

    public int getWarrantyMonths(){return warrantyMonths;}

    @Override
    public String toString(){
        return super.toString()+"[Warranty:"+ warrantyMonths+ " months]";
    }
}