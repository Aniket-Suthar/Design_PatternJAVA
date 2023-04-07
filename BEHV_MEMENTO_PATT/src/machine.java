import java.util.ArrayList;
import java.util.List;

//ORIGINATOR CLASS CONTAINS ALL THE OBJECT THAT ARE REQUIRED FOR OUR MACHINE WORKING
class OriginatorClass{
    private int temperature;
    private int volume;

    public OriginatorClass(int temperature,int volume)
    {
        this.temperature=temperature;
        this.volume=volume;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getVolume() {
        return volume;
    }

    //SAVING THE STATE THE OF OBJECT CREATED
    public MementoObject saveStateDetails(){
        return  new MementoObject(this.temperature,this.volume);
    }

    //RESTORING  THE STATES OF SOME OF THE SAVED STATES FROM ABOVE;
    public void recoverState(MementoObject m1){
        this.temperature=m1.getTemperature();
        this.volume=m1.getVolume();
//        setTemperature(m1.getTemperature());
//        setVolume(m1.getVolume());
    }

    //OPERATIONS IN MACHINE
    public void operateMachine(){
        System.out.println("Machine operating with temperature: "+this.temperature + " With volume: "+ this.volume );
    }


    @Override
    public String toString() {
        return "The Temperature is: "+this.temperature+ " The VOlume is:" +this.volume;
    }
}


//IN THIS ANY NUMBER OF OBJECT CAN BE BUILD FROM THE ORIGINATOR  CLASS
//WHOSE STATE IS DEPENDENT ON OUR MACHINE EFFICIENT WORKING

class MementoObject{
    private int temperature;
    private int volume;

    public MementoObject(int temperature,int volume){
        this.temperature=temperature;
        this.volume=volume;
    }
    //NO SETTER METHOD SHOULD BE USED IN THE MEMENTO CLASS
    public int getVolume() {
        return volume;
    }

    public int getTemperature() {
        return temperature;
    }
}

//CARETAKER CLASS IN ORDER TO GET THE REQUIRED STATE THAT WE WANT TO GET
class CareTakerObject{
    private List <MementoObject> list=new ArrayList<MementoObject>();

    public void add(MementoObject m1){
        list.add(m1);
    }
    public MementoObject getState(int i){
        return list.get(i);
    }
}

class MementoTest{
    public static void main(String[] args) {

        //CREATING AN ORIGINATOR OBJECT
        OriginatorClass o1= new OriginatorClass(23,22);

        //CALLING BUSINESS METHOD
        o1.operateMachine();

        //SAVING THE STATE (IT RETURNS A MEMNTO OBJECT)
        o1.saveStateDetails();

        //ADDING THE OBJECT TO LIST
        CareTakerObject c1=new CareTakerObject();
        c1.add(o1.saveStateDetails());


        //CHANGING THE STATES
        o1.setVolume(35);
        o1.setTemperature(34);

        //
        o1.setTemperature(33);
        o1.setVolume(88);

        //CALLING/RESTORING THE SAVED STATE
        o1.recoverState(c1.getState(0));

        //CALLING THE MACHINE AGAIN
        o1.operateMachine();


    }
}
