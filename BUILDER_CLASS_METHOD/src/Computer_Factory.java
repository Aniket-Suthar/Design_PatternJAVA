//Director Class
class HardwareEngineer {
    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder c) {
        computerBuilder = c;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void constructComputer() {
        computerBuilder.createNewComputer();
        computerBuilder.configure_Device_Driver();
        computerBuilder.configure_Monitor_Size();
        computerBuilder.configure_OS();
        computerBuilder.configure_Processor_type();
        computerBuilder.configure_RAM();
    }
}


class Computer {
    private String RAM_Size;
    private String IP_Address;
    private String Processor_Type;
    private String OS;
    private String Monitor_Type;
    private String Device_Driver;
    private String Monitor_Size;
    private String Processor_Brand;

    Computer(String IP_Address, String OS) {
        this.IP_Address = IP_Address;
        this.OS = OS;
    }

    public void setDevice_Driver(String device_Driver) {
        Device_Driver = device_Driver;

    }

    public void setIP_Address(String IP_Address) {
        this.IP_Address = IP_Address;
    }

    public void setMonitor_Size(String monitor_Size) {
        Monitor_Size = monitor_Size;
    }

    public void setMonitor_Type(String monitor_Type) {
        Monitor_Type = monitor_Type;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setProcessor_Brand(String processor_Brand) {
        Processor_Brand = processor_Brand;
    }

    public void setProcessor_Type(String processor_Type) {
        Processor_Type = processor_Type;
    }

    public void setRAM_Size(String RAM_Size) {
        this.RAM_Size = RAM_Size;
    }

    public void displayComputer() {
        System.out.println("The OS type is :" + OS + "\n" +
                "The RAM size is :" + RAM_Size + "\n" +
                "The Device Driver is :" + Device_Driver + "\n" +
                "The Monitor size is :" + Monitor_Size + "\n" +
                "THe Processor Type is :" + Processor_Type);
    }
}


abstract class ComputerBuilder {
    protected Computer computer;
    protected String customer_ip;
    protected String OS_type;

    public Computer getComputer() {
        return computer;
    }

    public void createNewComputer() {
        computer = new Computer(customer_ip, OS_type);
    }

    public abstract void configure_RAM();

    public abstract void configure_Monitor_Size();

    public abstract void configure_OS();

    public abstract void configure_Processor_type();

    public abstract void configure_Device_Driver();
}

class ServerComputer extends ComputerBuilder {
    @Override
    public void configure_RAM() {
        computer.setRAM_Size("4 GB");

    }

    @Override
    public void configure_Monitor_Size() {
        computer.setMonitor_Size("16 inches");
    }

    @Override
    public void configure_OS() {
        computer.setOS("Linux");
    }

    @Override
    public void configure_Processor_type() {
        computer.setProcessor_Type("AMD Ryzen");
    }

    @Override
    public void configure_Device_Driver() {
        computer.setDevice_Driver("64 bits");
    }
}

class PersonalComputer extends ComputerBuilder {
    @Override
    public void configure_RAM() {
        computer.setRAM_Size("8 GB");

    }

    @Override
    public void configure_Monitor_Size() {
        computer.setMonitor_Size("14 inches");
    }

    @Override
    public void configure_OS() {
        computer.setOS("Windows");
    }

    @Override
    public void configure_Processor_type() {
        computer.setProcessor_Type("Intel I7");
    }

    @Override
    public void configure_Device_Driver() {
        computer.setDevice_Driver("64 bits");
    }
}

class test_4 {
    public static void main(String[] args) {
        HardwareEngineer hr = new HardwareEngineer();
        //creating a server computer
        ComputerBuilder sr = new ServerComputer();

        hr.setComputerBuilder(sr);
        hr.constructComputer();

        Computer server = hr.getComputer();
        System.out.println("This is a Server Computer:");
        server.displayComputer();

        System.out.println();

        //creating a Personal Computer
        ComputerBuilder pr = new PersonalComputer();

        hr.setComputerBuilder(pr);
        hr.constructComputer();

        Computer personal = hr.getComputer();
        System.out.println("This is a Personal Computer");
        personal.displayComputer();

    }
}