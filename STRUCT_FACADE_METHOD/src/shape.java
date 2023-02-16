interface Shape {
    public void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("You are drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("You are drawing a Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("You are drawing a Square");
    }
}


class Shapemaker {
    Shape c=new Circle();
    Shape r=new Rectangle();
    Shape sq=new Square();

    private static Shapemaker instance = null;


    //constructor for the
    private Shapemaker() {
    }

    //public getInstance method
   synchronized public static Shapemaker getInstance() {
        if (instance == null) {
            instance = new Shapemaker();
        }
        return instance;
    }

    public void drawCirle() {
//        c = new Circle();
        c.draw();
    }

    public void drawSquare() {
//        r = new Rectangle();
        r.draw();
    }

    public void drawRectangle() {
//        sq = new Square();
        sq.draw();
    }
}


class FacadePatternDemo {
    public static void main(String[] args) {
        Shapemaker sm=Shapemaker.getInstance(); //Singleton Implementation
        sm.drawSquare();
        sm.drawCirle();
        sm.drawRectangle();
    }
}