public class Product {

    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(!(obj instanceof Product))
            return false;
        Product p = (Product)obj;

        return(this.name.equals(p.name) && this.price == p.price && ((this.discountPercent - p.discountPercent ))<0.01);


    }


}
