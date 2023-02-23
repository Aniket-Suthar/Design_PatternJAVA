import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
interface DatabaseService {
    void accessCustomerRecord(String fileName) throws IOException;
    void appendCustomerData(String filename) throws IOException;
}


class serviceData implements DatabaseService
{
    @Override
    public void appendCustomerData(String filename) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Scanner sc= new Scanner(System.in);
        String name,role,pass;
        System.out.println("Enter the Username: ");
        name=sc.nextLine();
        System.out.println("Enter the password :");
        pass=sc.nextLine();
        System.out.println("Enter the role :");
        role= sc.nextLine();
        String fn=name+"\t "+pass+"\t "+role;

        FileWriter wr = new FileWriter("E:\\ANIKET SUTHAR\\DESIGN_PATTERN_NEW\\STRUCT_PROXY _PATTERN\\"+filename,true);
        wr.write(fn+"\n");
        wr.flush();
        wr.close();

        FileWriter wr2=new FileWriter("log.txt",true);
        String fn2= name+"\t "+role+"\t "+dtf.format(now);
        wr2.write(fn2+"\n");
        wr2.flush();
        wr2.close();
    }
    @Override
    public void accessCustomerRecord(String fileName) throws IOException {
        Scanner sc= new Scanner(System.in);
        String input="Admin",in;


        System.out.println("Enter the user role :");
        in=sc.nextLine();


        File f1=new File("E:\\ANIKET SUTHAR\\DESIGN_PATTERN_NEW\\STRUCT_PROXY _PATTERN\\"+fileName); //Creation of File Descriptor for input file
        String[] words=null;  //Intialize the word Array
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;
        // Input word to be searched
        int count=0;   //Intialize the word to zero
        while((s=br.readLine())!=null)   //Reading Content from the file
        {
            words=s.split(" ");  //Split the word using space
            for (String word : words)
            {
                if (word.equals(input))   //Search for the given word
                {
                    count++;    //If Present increase the count by one
                }
            }
        }
        if(count!=0){
            FileReader fr1=new FileReader("log.txt");
        int i;
        while((i=fr1.read())!=-1)
            System.out.print((char)i);
        fr1.close();

        }
    }
}

class ptest {
    public static void main(String[] args) throws IOException {
        DatabaseService ds = new serviceData();
        ds.appendCustomerData("customerdetails.txt.txt");

        System.out.println("THe file content is:");
        ds.accessCustomerRecord("customerdetails.txt.txt");

    }
}

