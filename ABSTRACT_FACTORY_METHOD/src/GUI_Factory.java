interface button {
    void buttoncolor();
}

interface label {
    void labelcontent();
}

class Windowsbutton implements button {
    @Override
    public void buttoncolor() {
        System.out.println("Blue BUtton Created in Windows");
    }

}

class MacButton implements button {
    @Override
    public void buttoncolor() {
        System.out.println("New BUtton on Mac Screen");
    }
}

class Windowlabel implements label {
    @Override
    public void labelcontent() {
        System.out.println("Label has image on Windows");
    }
}

class Maclabel implements label {
    @Override
    public void labelcontent() {
        System.out.println("Label has video on MAc Screen");
    }
}

interface GUI_Factory {
    button Button_factory(String name);

    label Label_factory(String name);
}

class Windows_Factory implements GUI_Factory {
    public Windowsbutton Button_factory(String name) {
        if (name.equalsIgnoreCase("WB")) {
            return new Windowsbutton();
        }
        return null;
    }

    public Windowlabel Label_factory(String name) {
        if (name.equalsIgnoreCase("WL")) {
            return new Windowlabel();
        }
        return null;
    }

}

class MAC_Factory implements GUI_Factory {
    public MacButton Button_factory(String name) {
        if (name.equalsIgnoreCase("MB")) {
            return new MacButton();
        }
        return null;
    }

    public Maclabel Label_factory(String name) {
        if (name.equalsIgnoreCase("ML")) {
            return new Maclabel();
        }
        return null;
    }

}

class test2 {
    public static void main(String[] args) {
        System.out.println("Windows Creation");
        Windows_Factory w1 = new Windows_Factory();
        Windowsbutton b1 = w1.Button_factory("WB");
        b1.buttoncolor();
        Windowlabel b3 = w1.Label_factory("WL");
        b3.labelcontent();

        System.out.println();
        System.out.println("Mac Creation");
        MAC_Factory m1 = new MAC_Factory();
        MacButton b2 = m1.Button_factory("MB");
        Maclabel b5 = m1.Label_factory("ML");
        b2.buttoncolor();
        b5.labelcontent();
    }
}
