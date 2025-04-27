public class Shape {
    public interface Shape {
        void draw();
        String getTypeName();
    }
}


public class Square implements Shape.Shape{

    private int sideLength;

    public Square() {
        this.sideLength = 1;
    }

    @Override
    public void draw() {
        System.out.println("Square size: " + sideLength);
    }

    @Override
    public String getTypeName() {
        return "square";
    }
}
