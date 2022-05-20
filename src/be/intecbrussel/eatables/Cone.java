package be.intecbrussel.eatables;
import java.util.Arrays;

public class Cone implements Eatable{
    public enum Flavor{
        STRAWBERRY,
        BANANA,
        CHOCOLATE,
        VANILLA,
        LEMON,
        STRACIATELLA,
        MOKKA,
        PISTACHE;
    }

    private Flavor[] balls;

    public Cone()
    {
        //default constructor
        balls=new Flavor[2];
        balls[0]=Flavor.STRAWBERRY;
        balls[1]=Flavor.CHOCOLATE;
    }
    public Cone(Flavor[] flavors)
    {
        this.balls=flavors;
    }


    public void eat()
    {
        System.out.print("Eating a cone with flavors: ");
        for(int i = 0;i<balls.length-1;i++)//0-> length-2 ( i traverse all elements EXCEPT THE LAST ONE)
            System.out.print(balls[i]+", ");

        System.out.println(balls[balls.length-1]+".");
    }

}
