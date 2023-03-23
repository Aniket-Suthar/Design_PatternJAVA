interface Icecream {
    void type();

    void addCost();
}

abstract class Toppings implements Icecream {
    protected Icecream newIceCream;
    protected int cost;

    public Toppings(Icecream newIceCream, int cost) {
        this.newIceCream = newIceCream;
    }


    @Override
    public void type() {
        newIceCream.type();
    }

    @Override
    public void addCost() {
        System.out.println("THe Simple Cost is " + this.cost);
    }
}


class addingNuts extends Toppings {
    protected int newcost;

    public addingNuts(Icecream newIceCream, int newcost) {
        super(newIceCream, newcost);

    }

    @Override
    public void type() {
        newIceCream.type();
        Nuts(newIceCream);
    }

    @Override
    public void addCost() {
    ;
        Nuts(newIceCream);
    }

    private void Nuts(Icecream newIceCream) {
        System.out.println("This Ice-Cream Has Nuts Added on it..");
    }
}

class VanilaIcecream implements Icecream {
    protected int cost;

    public VanilaIcecream(int cost) {
        this.cost = cost;
    }

    @Override
    public void type() {
        System.out.println("You are eating a Simple Vanilla Ice-Cream :)");
    }

    @Override
    public void addCost() {
        System.out.println("THe cost of Simple Vanilla Ice-Cream is:" + cost);
    }
}

class ChocolateIcecream implements Icecream {
    protected int cost;
    public ChocolateIcecream(int cost) {
        this.cost = cost;
    }
    @Override
    public void type() {
        System.out.println("You are eating a Simple Chocolate Ice-Cream :)");

    }
    @Override
    public void addCost() {
        System.out.println("The cost of Simple Chocolate ice-Cream is" + this.cost);
    }
}

class IceTest {
    public static void main(String[] args) {
        Icecream simpVanilla = new VanilaIcecream(20);
        Icecream simpChoco = new ChocolateIcecream(20);

        Icecream nutVanilla = new addingNuts(simpVanilla, 50);
        Icecream nutChoco = new addingNuts(simpChoco, 50);

        simpVanilla.type();
        simpVanilla.addCost();
        simpChoco.type();
        simpChoco.addCost();
        System.out.println("========================================");
        nutVanilla.type();
        nutVanilla.addCost();
        System.out.println("========================================");
        nutChoco.type();
        nutVanilla.addCost();
    }
}