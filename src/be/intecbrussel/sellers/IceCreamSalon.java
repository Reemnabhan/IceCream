package be.intecbrussel.sellers;
import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{
    private PriceList pricelist;
    private double totalProfit;

    public IceCreamSalon(PriceList list)
    {
        pricelist=list;
        totalProfit=0;
    }

    public double getProfit()
    {return totalProfit;}

    public Cone orderCone(Cone.Flavor[] flavors)
    {
        Cone c1= new Cone(flavors);
        totalProfit+=pricelist.getBallPrice()*flavors.length;
        return c1;
    }

    public IceRocket orderIceRocket()
    {
        IceRocket i= new IceRocket();
        totalProfit+=pricelist.getRocketPrice();
        return i;//return new IceRocket();
    }

    public Magnum orderMagnum(Magnum.MagnumType type)
    {
        totalProfit+=pricelist.getMagnumPrice(type);
        return new Magnum(type);
    }
}
