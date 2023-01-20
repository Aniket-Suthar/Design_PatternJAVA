interface Shape {
    public void draw(String a);
}

class Rectangle implements Shape {
    public void draw(String a) {
        System.out.println("You are in the rectangle class to draw: " + a);
    }

}

class Square implements Shape {
    public void draw(String a) {
        System.out.println("You are in the square class to draw: " + a);
    }

}

class Circle implements Shape {
    public void draw(String a) {
        System.out.println("You are in the circle class to draw: " + a);
    }

}

class ShapeFactory {
    public static Shape GetShape(String name) {
        if (name.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (name.equalsIgnoreCase("square")) {
            return new Square();
        } else if (name.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}

class test {
    public static void main(String[] args) {


        Shape s2 = ShapeFactory.GetShape("circle");
        Shape s3 = ShapeFactory.GetShape("square");
        Shape s4 = ShapeFactory.GetShape("rectangle");

        s2.draw("Balloon");
        s3.draw("cube");
        s4.draw("table");


    }
}
