import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;

class Banker {
    Account ne;
    ArrayList<Account> al = new ArrayList<>();
    private static Banker instance = null;

    //constructor
    private Banker() {
    }

    //public getInstance method
    public static Banker getInstance() {
        if (instance == null) {
            instance = new Banker();
        }
        return instance;
    }

    public Account addAccount(Account ne) {
        al.add(ne);
        return ne;

    }


}

class Account {
    int accountno;
    String accname;
    int mobile;

    Account(int accountno, String accname, int mobile) {
        this.accname = accname;
        this.accountno = accountno;
        this.mobile = mobile;
    }

    public void diplay() {
        System.out.println("Account no is " + this.accountno);
        System.out.println("Account holder is " + this.accname);
        System.out.println("Mobile No. :" + this.mobile);
    }
}

class t {
    public static void main(String[] args) {
        Banker b1 = Banker.getInstance();

        Account a1 = new Account(123, "Abc", 97654);
        Account a2 = new Account(113, "xyz", 97652222);
        Account a3 = new Account(1223, "asd", 9722);

        b1.addAccount(a1).diplay();
        System.out.println();

        b1.addAccount(a2).diplay();
        System.out.println();

        b1.addAccount(a3).diplay();
        System.out.println();


        System.out.println("The accounts in the banks are: " + b1.al);


    }
}