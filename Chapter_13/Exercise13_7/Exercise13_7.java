public class Exercise13_7 {
    public static void main(String[] args) {
        GeometricObject[] myObjects = new Triangle[5];
        
        for (int i = 0; i < myObjects.length; i++) {
            myObjects[i] = new Triangle(
                (int)(Math.random() * 10 + 1),
                (int)(Math.random() * 10 + 1),
                (int)(Math.random() * 10 + 1),
                (i % 2 == 0) ? ("Green" + i) : null,
                true);

            System.out.println("\nTriangle " + i + " Area: " + ((Triangle)myObjects[i]).getArea());

            // myObjects[i].howToColor();
            ((Triangle)myObjects[i]).howToColor();
        }
    }
}