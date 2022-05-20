package be.intecbrussel.application;
import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

public class IceCreamAppV2 {
    public static void main(String[] args){
        PriceList pricelist = new PriceList(2, 3, 5);
        Stock stock = new Stock (2,2,2,2);
        IceCreamSeller car1= new IceCreamCar(pricelist, stock);
        //order and store the ice creams in an array of eatables
        Eatable [] icecreams= new Eatable[5];//ordered 5 icecreams

        icecreams[0]= car1.orderIceRocket();
        icecreams[1]= car1.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);

        icecreams[2]= car1.orderIceRocket();

        icecreams[3]= car1.orderIceRocket();//MESSAGE

        icecreams[4]=car1.orderCone(new Cone.Flavor[]  {Cone.Flavor.STRAWBERRY, Cone.Flavor.LEMON});

//call eat
        for(int i =0; i<icecreams.length;i++)
            if(icecreams[i]!=null)icecreams[i].eat();

        System.out.println("\nThe profit = $"+car1.getProfit());


    }



}
