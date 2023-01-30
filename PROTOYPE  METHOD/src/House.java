import java.util.HashMap;
import java.util.Map;

class owner {
    protected String name;
    protected int MobileNo;

    owner(String name, int MobileNo) {
        this.MobileNo = MobileNo;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return " Owner is: " + this.name + " THe mobile no is : " + this.MobileNo;
    }
}

class House implements Cloneable {
    private int area;
    private long price;
    protected owner on;

    House(int area, long price, owner o) {
        this.area = area;
        this.price = price;
        on = o;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }


    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "The house's size is : " + this.area + " The price of house is : " + this.price + on.toString();
    }



    public House clone() {
        House clone = null;
        try {
            clone = (House) super.clone();
            owner o1 = new owner(this.on.getName(), this.on.getMobileNo());  //for creating the deep copy
            clone.on = o1;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (House) clone;
    }

}

class TwoBHKhouse extends House {

    TwoBHKhouse(int area, long price, owner o, long paintingcost) {
        super(area, price, o);
        this.paintingcost = paintingcost;
    }

    private long paintingcost;

    public void setPaintingcost(long paintingcost) {
        this.paintingcost = paintingcost;
    }

    public long getPaintingcost() {
        return paintingcost;
    }

    @Override
    public String toString() {
        return super.toString() + "The painting cost is : " + this.paintingcost;
    }
}


class HouseStore{
    static Map<String,House> houses = new HashMap<String,House>();

    static{
        owner o3=new owner("XYZ",856423353);
        houses.put("2 BHK",new TwoBHKhouse(125, 32445, o3, 500000));
    }
    public House getHouse(String type){
        return houses.get(type);
    }

    public House getCloneHouse(String type){
        return houses.get(type).clone();
    }
}
class test2 {
    public static void main(String[] args) {
//        owner o2 = new owner("ABC", 995468587);
//        House h1 = new House(124, 233333, o2);
//
//        House h2 = h1.clone();
//
//        System.out.println("Original : " + h1);
//        System.out.println("CLoned : " + h2);
//
//        System.out.println("Changed Data:");
//
//        h2.setPrice(3434323);
//        h2.on.setName("New ABC");
//
//        System.out.println("Original : " + h1);
//        System.out.println("CLoned : " + h2);
//
//        TwoBHKhouse t1 = new TwoBHKhouse(125, 32445, o2, 500000);
//        System.out.println("2 BHK : " + t1);

        HouseStore h1 = new HouseStore();
        h1.getHouse("2 BHK");
        System.out.println(h1);
    }

}