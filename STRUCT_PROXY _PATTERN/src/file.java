import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.*;
import java.util.*;

interface DatabaseServices {
    void accessCustomerRecord(String fileName);
}

class ServiceDatabase implements DatabaseServices {
    @Override
    public void accessCustomerRecord(String fileName) {
        //Providing access to file name customerdetails.txt
        try {
            Reader reader = new FileReader("E:\\ANIKET SUTHAR\\DESIGN_PATTERN_NEW\\STRUCT_PROXY _PATTERN\\customerdetails.txt.txt");
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


class ServiceDatabaseProxy implements DatabaseServices {
    String name;
    ServiceDatabase sd = new ServiceDatabase();
    String dfile = "logcustomerdetails";
    //Log Client information in logcustomerdetails.txt file
    FileReader fin = new FileReader("E:\\ANIKET SUTHAR\\DESIGN_PATTERN_NEW\\STRUCT_PROXY _PATTERN\\customerdetails.txt.txt");
    FileWriter fout = new FileWriter(dfile, true);
    int c;

    ServiceDatabaseProxy() throws IOException {
        while ((c = fin.read()) != -1) {
            fout.write(c);
        }
        System.out.println("Copy finished in Log File...");
        fin.close();

        fout.close();
    }


    //Check the role of client if "Manager" then able to access file else access denied
    @Override
    public void accessCustomerRecord(String fileName) {
        sd.accessCustomerRecord("customerdetails.txt");
    }
}

class ProxyTest {
    public static void main(String[] args) throws IOException {
        DatabaseServices ds = new ServiceDatabaseProxy();

        ds.accessCustomerRecord("customerdetails.txt");
    }
}