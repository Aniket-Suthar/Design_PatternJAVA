//Interface for Main Component
interface Shape {
    void draw();
}

//Implementing Concrete Classes Without Decorations
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a simple Rectangle...");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a simple Triangle...");
    }
}


//Implementing an Abstract Decorator to decorate the objects
abstract class Decorator implements Shape {
    protected Shape NewShape;

    public Decorator(Shape decoratedShape) {
        this.NewShape = decoratedShape;
    }

    @Override
    public void draw() {
        NewShape.draw();
    }

}


//Implementing Concrete Decorator class for Adding the Border
class BorderShape extends Decorator {


    public BorderShape(Shape NewShape) {
        super(NewShape);
    }

    @Override
    public void draw() {
        NewShape.draw();
        //Calling the function created for adding Decorations i.e (Border)
        borderAdd(NewShape);
    }

    //Implementing the private method to be used
    private void borderAdd(Shape NewShape) {
        System.out.println("THe Border of the Decorated Shape is Thick and Black");
    }
}


class TestDecorator {
    public static void main(String[] args) {
        //Simple Shapes
        Shape simpleRect = new Rectangle();
        Shape simpleTri = new Triangle();

        //Decorated Shapes
        Shape decRect = new BorderShape(simpleRect);
        Shape decTri = new BorderShape(simpleTri);

        simpleRect.draw();
        simpleTri.draw();

        System.out.println("========================================");
        decRect.draw();
        System.out.println("========================================");
        decTri.draw();
    }
}
