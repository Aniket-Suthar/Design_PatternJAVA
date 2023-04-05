//Composite Method for a "Directory-Files" Components

import java.util.ArrayList;
import java.util.List;

abstract class Base {
    protected String name;

    protected int size;


    public Base(String n, int p) {
        name = n;
        size = p;
    }

    public Base(String n) {
        name = n;
    }

    abstract public void showName();

    abstract public int getPrice();
}


//leaf Object
class File extends Base {
    public File(String n, int p) {
        super(n, p);
    }

    public void showName() {
        System.out.println("File :" + "'"+this.name+"'" + " size :" + getPrice() + " MB");
        System.out.println();
    }


    @Override
    public int getPrice() {
        return size;
    }
}

class Directory extends Base {

    List<Base> l = new ArrayList<Base>();

    Directory(String n) {
        super(n);
    }

    @Override
    public void showName() {

        System.out.println("Directory : " +"'"+name +"'"+ " With Size :" + getPrice() + " MB" + " Have :\n");

        for (Base c : l) {
            c.showName();
        }

    }

    public int getPrice() {
        int price = 0;
        
        for (Base c : l) {
            //Summing the size of each file in directory
            price += c.getPrice();
        }
        return price;
    }


    public void addComponent(Base c) {
        l.add(c);
    }

    public void removeComponent(Base c) {
        l.remove(c);
    }
}

class basetest {
    public static void main(String[] args) {
        Base l1 = new File("File-->1", 70);
        Base l6 = new File("File-->2", 778);
        Base l2 = new File("File-->3", 23);
        Base l3 = new File("File-->4", 32);
        Base l4 = new File("File-->5", 22);
        Base l5 = new File("File-->6", 28);


        Directory d1 = new Directory("New Volume E:");
        Directory d2 = new Directory("WIndows C:");
        Directory d3 = new Directory("This PC");


        //Adding Files to Directories
        d1.addComponent(l3);
        d2.addComponent(l5);


        d1.addComponent(l2);
        d1.addComponent(l4);


        d2.addComponent(l1);
        d2.addComponent(l6);

        d3.addComponent(d2);
        d3.addComponent(d1);


        //Showing the all the directories and files
        System.out.print("This the main : ");
        d3.showName();


    }
}