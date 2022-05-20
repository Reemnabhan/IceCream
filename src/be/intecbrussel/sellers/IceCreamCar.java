package be.intecbrussel.sellers;
import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller {
    private PriceList pricelist;
    private Stock stock;
    private double profit;

    public IceCreamCar()
    {
        profit=0;
        pricelist= new PriceList(2, 3, 5);
        stock= new Stock(100,100,100,100) ;  }

    public IceCreamCar(PriceList list, Stock stock)
    {
        pricelist= list;
        this.stock=stock;
        profit=0;
    }
    public Cone orderCone(Cone.Flavor[] flavors)
    {

        //call prepareCone
        try
        {
            Cone c1= prepareCone(flavors);//2 possibilities, cone is prepared and returned OR an exception is thrown
            profit+=pricelist.getBallPrice()*flavors.length;
            return c1;
        }
        catch(NoMoreIceCreamException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Cone prepareCone(Cone.Flavor[] flavors)throws NoMoreIceCreamException
    {
        if(stock.getCones()>=1 && stock.getBalls()>=flavors.length)//i can prepare
        {
            Cone c1= new Cone(flavors);
            stock.setCones(stock.getCones()-1);
            stock.setBalls(stock.getBalls()-flavors.length);
            return c1;
        }
        else if(stock.getCones()==0)//i CANNOT prepare => NO CONES
        {
            throw new NoMoreIceCreamException("No more cones in stock, cannot prepare.");
//        NoMoreIceCreamException e= new NoMoreIceCreamException("no more cones,...");
//        throw e;
        }
        else throw new NoMoreIceCreamException("No more balls in stock, cannot prepare");

    }
    public IceRocket orderIceRocket()
    {
        try
        {
            IceRocket i= prepareIceRocket();
            profit+=pricelist.getRocketPrice();
            return i;

        }
        catch(NoMoreIceCreamException e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

    private IceRocket prepareIceRocket() throws NoMoreIceCreamException
    {
        if(stock.getIceRockets()>=1){
            stock.setIceRockets(stock.getIceRockets()-1);
            return new IceRocket();}
        else
            throw new NoMoreIceCreamException ("No more ice rockets in stock, cannot prepare");
    }
    public Magnum orderMagnum(Magnum.MagnumType type)
    {
        try
        {
            Magnum m= prepareMagnum(type);
            profit+=pricelist.getMagnumPrice(type);
            return m;
        }
        catch(NoMoreIceCreamException e)
        {
            System.out.println(e.getMessage());
            return null;

        }
    }
    private Magnum prepareMagnum(Magnum.MagnumType type)throws NoMoreIceCreamException
    {
        if(stock.getMagni()>=1){
            stock.setMagni(stock.getMagni()-1);
            return new Magnum(type);}
        else
            throw new NoMoreIceCreamException("No more magnus in stock, cannot prepare");
    }
    public double getProfit()
    {
        return profit;
    }
}
