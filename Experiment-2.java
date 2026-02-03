class Area {
    double calculateArea(double side) {
        return side*side;
    }

    double calculateArea(double length, double breadth) {
        return length*breadth;
    }

    
}

public class Main {
    public static void main(String[] args) {

        Area a = new Area();

        System.out.println("Area of Square: ");
        System.out.println(a.calculateArea(5));
        
        System.out.println("Area of Rectangle: ");
        System.out.println(a.calculateArea(6,10));

    }
}
