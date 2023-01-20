abstract class Residency {
    private String name;
    private int area, unitprice;

    abstract long calculate();

    //getter and setter methods
    public int getArea() {
        return area;
    }

    public int getUnitprice() {
        return unitprice;
    }

    public String getName() {
        return name;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }


}


abstract class Flat extends Residency {

    @Override
    long calculate() {
        return 400000;
    }
}

abstract class Tenaments extends Residency {

    @Override
    long calculate() {
        return super.getArea() * super.getUnitprice();
    }
}

class TwoBHK extends Flat {
    @Override
    long calculate() {
        return super.calculate() + 20000;
    }
}

class Villas extends Tenaments {
    @Override
    long calculate() {

        return super.calculate() + 30000;
    }
}

class Residency_Factory {
    public static Residency GetHome(String name) {
        if (name.equalsIgnoreCase("twobhk")) {
            return new TwoBHK();
        } else if (name.equalsIgnoreCase("villa")) {
            return new Villas();
        }
        return null;
    }
}

class Test3 {
    public static void main(String[] args) {

        Residency r1 = Residency_Factory.GetHome("twobhk");
        r1.setUnitprice(500);
        r1.setArea(5000);
        System.out.println("The price for your 2 BHK will be :" + r1.calculate());


        Residency r2 = Residency_Factory.GetHome("villa");
        r2.setUnitprice(600);
        r2.setArea(10000);
        System.out.println("The price for your Villa will be :" + r2.calculate());


    }
}

