interface chair {
    void usage();

    void price();
}

interface sofa {
    void material();

    void price();
}

class Officechair implements chair {
    public void usage() {
        System.out.println("Office chairs for office purpose");
    }

    @Override
    public void price() {
        System.out.println("Cost is: Rs. 5000");
    }
}

class Artisticchair implements chair {
    @Override
    public void usage() {
        System.out.println("Artistic chair for home decor.");
    }

    @Override
    public void price() {
        System.out.println("The Cost will be : 8000");
    }
}

class Homesofa implements sofa {

    @Override
    public void material() {
        System.out.println("Sofa material is leather");
    }

    @Override
    public void price() {
        System.out.println("The cost will be 500000");
    }
}

class Luxurysofa implements sofa {
    public void material() {
        System.out.println("Sofa material is latex");
    }

    @Override
    public void price() {
        System.out.println("The cost will be 600000");
    }
}

//interface for furniture creations
interface Furniture_factory {
    chair chair_factory(String name);

    sofa sofa_factory(String name);
}

//implementation
class Office_Factory implements Furniture_factory {
    public Officechair chair_factory(String name) {
        if (name.equalsIgnoreCase("Office Chair")) {
            return new Officechair();
        }
        return null;
    }

    public Luxurysofa sofa_factory(String name) {
        if (name.equalsIgnoreCase("Luxury sofa")) {
            return new Luxurysofa();
        }
        return null;
    }

}

class Home_Factory implements Furniture_factory {
    public Artisticchair chair_factory(String name) {
        if (name.equalsIgnoreCase("Artistic Chair")) {
            return new Artisticchair();
        }
        return null;
    }

    public Homesofa sofa_factory(String name) {
        if (name.equalsIgnoreCase("Home sofa")) {
            return new Homesofa();
        }
        return null;
    }

}

class test3 {
    public static void main(String[] args) {
        System.out.println("Office Furnitures");

        Office_Factory f1 = new Office_Factory();
        Officechair f2 = f1.chair_factory("Office Chair");
        Luxurysofa f3 = f1.sofa_factory("Luxury sofa");

        f2.price();
        f2.usage();
        System.out.println();
        f3.material();
        f3.price();
        System.out.println();

        System.out.println("Home Furniture");

        Home_Factory fn = new Home_Factory();
        Artisticchair f4 = fn.chair_factory("Artistic Chair");
        Homesofa f5 = fn.sofa_factory("Home sofa");

        f4.price();
        f4.usage();
        System.out.println();
        f5.material();
        f5.price();
    }
}
