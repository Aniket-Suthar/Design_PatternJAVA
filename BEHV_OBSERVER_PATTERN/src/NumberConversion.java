import java.util.ArrayList;
//observer pattern for conversion of decimal to binary,hexal and ocatal numbers

//Subject or Publisher Entity ,who has following jobs- attach,detach,notify
class SubjectEntity {
    private int number;

    //Getter and Setter Methods
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
        notifyObject();
    }

    ArrayList<ObserverObject> list = new ArrayList<>();

    //ADDING OBSERVER OBJECT
    public void attachObject(ObserverObject o) {
        list.add(o);
        System.out.println("The Observer :" + o + " is Registered successfully..");
    }

    //REMOVING OBSERVER OBJECT
    public void detachObject(ObserverObject o) {
        list.remove(o);
        System.out.println("The Observer :" + o + " is Deleted successfully..");
    }

    //GETTING THE VARIOUS OBSERVER DETALIS i.e NOTIFY() FUNCTION
    public void notifyObject() {
        for (ObserverObject obs : list) {
            obs.updateNoSystem();
        }
    }
}


//Observer Entity who subscribes or registers to the Subject entity
abstract class ObserverObject {
    //Giving the reference of the subject to which the observer is interested in
    SubjectEntity sm;

    public abstract void updateNoSystem();
}


//Implementing first observer i.e Binary Conversion
class BinaryObserver extends ObserverObject {
    public BinaryObserver(SubjectEntity e) {
        sm = e;
        sm.attachObject(this);
    }

    //Implementing the business logic
    @Override
    public void updateNoSystem() {
        int number = sm.getNumber();
        System.out.println("The Binary Conversion of " + number + " is " + Integer.toBinaryString(number));
    }
}

//Implementing second observer i.e Hex Conversion
class HexObserver extends ObserverObject {
    public HexObserver(SubjectEntity e) {
        sm = e;
        sm.attachObject(this);
    }

    //Implementing the business logic
    @Override
    public void updateNoSystem() {
        int number = sm.getNumber();
        System.out.println("The hex Conversion of " + number + " is " + Integer.toHexString(number));
    }
}


//Implementing third observer i.e octal Conversion
class OctalObserver extends ObserverObject {
    public OctalObserver(SubjectEntity e) {
        sm = e;
        sm.attachObject(this);
    }

    //Implementing the business logic
    @Override
    public void updateNoSystem() {
        int number = sm.getNumber();
        System.out.println("The Octal Conversion of " + number + " is " + Integer.toOctalString(number));
    }
}

class ObserverTestingg {
    public static void main(String[] args) {
        SubjectEntity s = new SubjectEntity();

        //Creating 3 different Subscribers
        ObserverObject o1 = new BinaryObserver(s);

        ObserverObject o2 = new HexObserver(s);

        ObserverObject o3 = new OctalObserver(s);
        System.out.println();
        s.setNumber(999999999);
    }
}