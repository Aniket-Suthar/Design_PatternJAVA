//Composite Method for a "Computer" Component

import java.util.ArrayList;
import java.util.List;

abstract class Component {
    protected String name;

    protected int Price;


    public Component(String n, int p) {
        name = n;
        Price = p;
    }

    public Component(String n) {
        name = n;
    }

    abstract public void showName();

    abstract public int getPrice();
}

class leaf extends Component {
    public leaf(String n, int p) {
        super(n, p);
    }

    public void showName() {
        System.out.println("Component :" + "'"+this.name+"'" + " Price :" + getPrice( )+ " Rs.");
        System.out.println();
    }


    @Override
    public int getPrice() {
        return Price;
    }
}

class Composite extends Component {

    List<Component> ls = new ArrayList<Component>();

    Composite(String n) {
        super(n);
    }

    @Override
    public void showName() {

        System.out.println("Composite object: " + "'"+name+"'" + " With Price :" + getPrice() + " Rs." +  " Have :\n");

        for (Component c : ls) {
            c.showName();
        }

    }

    public int getPrice() {
        int price = 0;


        for (Component c : ls) {
            //Summing the price of each component of the composite object
            price += c.getPrice();
        }
        return price;
    }


    public void addComponent(Component c) {
        ls.add(c);
    }

    public void removeComponent(Component c) {
        ls.remove(c);
    }
}

class Compositetest {
    public static void main(String[] args) {
        Component l1 = new leaf("HDD", 70);
        Component l6 = new leaf("GPU", 778);
        Component l2 = new leaf("CPU", 23);
        Component l3 = new leaf("Mouse", 32);
        Component l4 = new leaf("RAM", 22);
        Component l5 = new leaf("Keyboard", 28);


        Composite c1 = new Composite("Cabinet");
        Composite c2 = new Composite("Peripherals");
        Composite c3 = new Composite("MotherBoard");
        Composite c4 = new Composite("Computer");


        //Adding Component of Peripherals
        c2.addComponent(l3);
        c2.addComponent(l5);

        //Adding components of Motherboard
        c3.addComponent(l2);
        c3.addComponent(l4);

        //Adding components of Cabinet
        c1.addComponent(l1);
        c1.addComponent(l6);


        //Adding Components of COmputer
        c4.addComponent(c2);
        c4.addComponent(c1);

        //Showing the all Components of a Composite Object Computer
        System.out.print("This is the main : ");
        c4.showName();

//        System.out.println(c4.getPrice());


    }
}