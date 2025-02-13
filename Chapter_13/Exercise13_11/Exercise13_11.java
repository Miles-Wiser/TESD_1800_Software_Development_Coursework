/*
Author: Miles Wiser
Date: 2/13/2025

    This program creates the Octagon class that implements the Comparable and
Cloneable interfaces. The execution file will create one Octagon instance and
clone it. Then an overriden compareTo() will compare the two instances three
times. The first Octagon will change it's side twice after each comparision to
better demonstrate compareTo().
*/

public class Exercise13_11 {
    public static void main(String[] args) throws Exception {
        Octagon oct1 = new Octagon(5, "Green", true);
        Octagon oct2 = oct1.clone();

        System.out.println("Oct1 s: " + oct1.getSide() + ", Oct2 s: " + oct2.getSide());
        System.out.println("Oct1 is greater/less/equal to Oct2: " + status(oct1, oct2));

        oct1.setSide(5.1);
        System.out.println("\nOct1 s: " + oct1.getSide() + ", Oct2 s: " + oct2.getSide());
        System.out.println("Oct1 is greater/less/equal to Oct2: " + status(oct1, oct2));

        oct1.setSide(4.9);
        System.out.println("\nOct1 s: " + oct1.getSide() + ", Oct2 s: " + oct2.getSide());
        System.out.println("Oct1 is greater/less/equal to Oct2: " + status(oct1, oct2));
    }

    public static String status(Octagon o1, Octagon o2) {
        if (o1.compareTo(o2) < 0)
            return "Less Than";
        else if(o1.compareTo(o2) > 0)
            return "Greater Than";
        else
            return "Equal To";
    }
}
