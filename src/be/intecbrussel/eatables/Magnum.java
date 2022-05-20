package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    public enum MagnumType{
        MILKCHOCOLATE,
        WHITECHOCOLATE,
        BLACKCHOCOLATE,
        ALPINENUTS,
        ROMANTICSTRAWBERRY;
    }

    private MagnumType type;
    public Magnum()
    {
        type=MagnumType.ALPINENUTS;
    }

    public Magnum(MagnumType t)
    {
        this.type=t;
    }
    public void eat()
    {
        System.out.println("Eating Magnum Icecream of type "+type);
    }

    public MagnumType getType()
    {
        return type;
    }

}
