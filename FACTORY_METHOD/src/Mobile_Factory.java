interface mobiles {
    void message();

    void call();

    void os();
}

class Mi implements mobiles {
    @Override
    public void message() {
        System.out.println("You can send message from your MI  phone");
    }

    @Override
    public void call() {
        System.out.println("You can call from your MI phone developed by XIAOMI");
    }

    @Override
    public void os() {
        System.out.println("The OS you are using is ANDROID");
    }
}

class Apple implements mobiles {
    @Override
    public void message() {
        System.out.println("You can send message from your Apple phone");
    }

    @Override
    public void call() {
        System.out.println("You can call from your Iphone developed by APPLE");
    }

    @Override
    public void os() {
        System.out.println("The OS you are using is IOS");
    }
}

class Nokia implements mobiles {
    @Override
    public void message() {
        System.out.println("You can send message from your Lumia  phone");
    }

    @Override
    public void call() {
        System.out.println("You can call from your Lumia phone developed by NOKIA");
    }

    @Override
    public void os() {
        System.out.println("The OS you are using is WINDOWS");
    }
}

class Mobilefactory {
    public static mobiles YourMobile(String name) {
        if (name.equalsIgnoreCase("IOS")) {
            return new Apple();
        } else if (name.equalsIgnoreCase("ANDROID")) {
            return new Mi();
        } else if (name.equalsIgnoreCase("NOKIA")) {
            return new Nokia();
        }
        return null;
    }
}

class test_new {
    public static void main(String[] args) {
        mobiles s1 = Mobilefactory.YourMobile("android");
        mobiles s2 = Mobilefactory.YourMobile("ios");
        mobiles s3 = Mobilefactory.YourMobile("nokia");

        s1.call();
        s1.message();
        s1.os();

        System.out.println();

        s2.call();
        s2.message();
        s2.os();

        System.out.println();

        s3.call();
        s3.message();
        s3.os();

    }
}
