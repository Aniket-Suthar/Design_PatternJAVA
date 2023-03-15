import java.util.HashMap;
import java.util.Map;
import java.util.Random;

abstract class Player {
    String type; //Player's Type i.e. Terrorist or Counter-Terrorist
    String task;  //Intrinsic Property as it will be fixed for both the types of Players
    String weapon; //Extrinsic Property as it will be varying from player to player

    public abstract void assignWeapon(String weapon);

    public abstract void goOnMission();
}

class Terrorist extends Player {
    public Terrorist() {
        System.out.println("Terrorist Created !!!");
        task = "Plant a Bomb";
    }

    @Override
    public void assignWeapon(String weapon) {
        System.out.println("The assigned weapon is :" + weapon);
    }

    @Override
    public void goOnMission() {

        System.out.println("Terrorist on the mission of " + task + "with weapon : " + weapon);
    }
}

class Counter_Terrorist extends Player {
    public Counter_Terrorist() {
        System.out.println("Counter-Terrorist Created !!!");
        task = "Diffuse a Bomb";
    }

    @Override
    public void assignWeapon(String weapon) {
        System.out.println("The assigned weapon is :" + weapon);
    }

    @Override
    public void goOnMission() {
        System.out.println("Terrorist on the mission of " + task + "with weapon : " + weapon);
    }
}

class PlayerFactory {
    //Map used for storing the object created and reuse for minimizing the number of Object creation
    Map<String, Player> players = new HashMap<String, Player>();
    Player p = null;

    public Player createPlayer(String playertype) {
        //Checking whether the object required is already present in the memory if yes then directly returning it thus reducing the memory space
        if (players.containsKey(playertype)) {
            p = players.get(playertype);
        }
        //If object is not present then creating it
        else {
            if (playertype.equalsIgnoreCase("Terrorist")) {
                p = new Terrorist();
                players.put("Terrorist", p);
            } else {
                p = new Counter_Terrorist();
                players.put("CounterTerrorist", p);
            }

        }
        //Returning the object created
        return p;
    }
}

class FlyweightDemo {
    public static void main(String[] args) {

        PlayerFactory p1 = new PlayerFactory();

        String[] Weapon = {"AK-47", "GROZA", "UMP", "SCAR", "KAR98k", "FAMAS", "DESERT-EAGLE"};
        for (int i = 0; i < 20; i++) {

            //Random function for selecting Weapon from weapon's array generating random number between 1 to 6
            Random rn = new Random();
            int answer = rn.nextInt(6) + 1;

            //Random function for creating Player whether a terrorist or C-terrorist generated random no. 0 or 1
            int choice = (int) Math.round(Math.random());
            if (choice == 1) {
                //Creating the initial objects
                Player p = p1.createPlayer("Terrorist");

                //Assigning the weapons
                p.assignWeapon(Weapon[answer]);

            } else {
                Player p = p1.createPlayer("CounterTerrorist");
                p.assignWeapon(Weapon[answer]);
            }
        }

    }
}