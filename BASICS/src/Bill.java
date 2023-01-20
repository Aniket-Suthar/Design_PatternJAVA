public abstract class Bill {
    private int bill_id;
    private int bill_unit;
    private float bill_unit_rate;

    //class
    public abstract float calculate_Bill();

    public abstract void print_bill();

    //Getter and Setter methods
    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public void setBill_unit(int bill_unit) {
        this.bill_unit = bill_unit;
    }

    public void setBill_unit_rate(float bill_unit_rate) {
        this.bill_unit_rate = bill_unit_rate;
    }

    public float getBill_unit_rate() {
        return bill_unit_rate;
    }

    public int getBill_id() {
        return bill_id;
    }

    public int getBill_unit() {
        return bill_unit;
    }

}

class Mobile_bill extends Bill {


    //Methods
    @Override
    public float calculate_Bill() {
        return this.getBill_unit() * this.getBill_unit_rate() + 50;
    }

    @Override
    public void print_bill() {
        System.out.println("THe bill id is: " + this.getBill_id());
        System.out.println("The bill units are: " + this.getBill_unit());
        System.out.println("The bill amount is:" + calculate_Bill());
    }
}

class Test {
    public static void main(String[] args) {
        Mobile_bill b1 = new Mobile_bill();
        b1.setBill_id(101);
        b1.setBill_unit(60);
        b1.setBill_unit_rate(5);
        b1.calculate_Bill();
        b1.print_bill();

        Mobile_bill b2 = new Mobile_bill();
        b2.setBill_id(102);
        b2.setBill_unit(65);
        b2.setBill_unit_rate(4);
        b2.calculate_Bill();
        b2.print_bill();

        Mobile_bill b3 = new Mobile_bill();
        b3.setBill_id(103);

    }
}

