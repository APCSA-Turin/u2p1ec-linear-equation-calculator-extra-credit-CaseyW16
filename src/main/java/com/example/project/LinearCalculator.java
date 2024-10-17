package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    // 1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    // e.g. "(0,0)" and "(5,17)"
    public LinearCalculator(String coord1, String coord2) {
        int seperator1 = coord1.indexOf(",");
        // set x1 to the string after the first parenthesis and before the comma
        x1 = Integer.parseInt(coord1.substring(1, seperator1));
        // set y1 to the string after the comma and before the closing parenthesis
        y1 = Integer.parseInt(coord1.substring(seperator1 + 1, coord1.length() - 1));

        int seperator2 = coord2.indexOf(",");
        // set x2 to the string after the first parenthesis and before the comma
        x2 = Integer.parseInt(coord2.substring(1, seperator2));
        // set y2 to the string after the comma and before the closing parenthesis
        y2 = Integer.parseInt(coord2.substring(seperator2 + 1, coord2.length() - 1));
    }

    // METHODS
    // getters and setters for the 4 instance variables (8 methods total) 
    public int getX1() {
        return x1;
    }
    public int getY1() {
        return y1;
    }
    public int getX2() {
        return x2;
    }
    public int getY2() {
        return y2;
    }
    public void setX1(int newX1) {
        x1 = newX1; 
    }
    public void setY1(int newY1) {
        y1 = newY1;
    }
    public void setX2(int newX2) {
        x2 = newX2;
    }
    public void setY2(int newY2) {
        y2 = newY2;
    }

    // xDiff() -> returns the int difference between the two points' x values
    public int xDiff() {
        return x2 - x1;
    }

    // yDiff() -> returns the int difference between the two points' y values
    public int yDiff() {
        return y2 - y1;
    }

    // distance() -> returns a double. 
    // calculates the distance between the two points to the nearest hundredth and returns the value.
    public double distance() {
        // distance = sqrt((x2 - x1)^2 + (y2 - y1)^2)
        double dist = Math.sqrt(Math.pow(xDiff(), 2) + Math.pow(yDiff(), 2));
        return roundedToHundredth(dist);
    }

    // yInt() -> returns a double.
    // calculates the y intercept of the equation and returns the value to the nearest hundredth;
    // if the slope is undefined, returns -999.99
    public double yInt() {
        double s = slope();
        if (s == -999.99) return -999.99;
        // y = mx + b, so b = y - mx
        return roundedToHundredth(y1 - s * x1);
    }

    // slope() -> returns a double. 
    // calculates the slope of the equations and returns the value to the nearest hundredth;
    // returns -999.99 for an undefined slope
    public double slope() {
        if (xDiff() == 0) return -999.99;
        if (yDiff() == 0) return 0;
        // slope = (y2 - y1) / (x2 - x1)
        return roundedToHundredth(yDiff() / (double)xDiff());
    }

    // equation() -> returns a String
    // calculates this line's equation in y=mx+b form and returns that String;
    // if the equation has an undefined slope, it returns "undefined"
    public String equation() {
        double s = slope();
        if (s == -999.99) return "undefined";
        double y = yInt();
        // if the slope is zero, the mx term should be hidden. Otherwise, it should be followed by "x".
        String mx = (s == 0.0 ? "" : s + "x");
        // If the y-intercept is zero, the b term should be hidden.
        String b = (y == 0.0 ? "" : Double.toString(y));
        // If the mx term exists, we need a "+" before the b term (if it's positive).
        return "y=" + mx + (mx.isEmpty() ? b : formatTerm(y)) ;
    }

    // formatTerm(double a) -> returns a String
    // if a is 0.0, it will return an empty string;
    // if a is negative it will return unchanged; 
    // if a is positive, it will return with a plus before it
    public String formatTerm(double a) {
        if (a == 0.0) return "";
        String aString = Double.toString(a);
        boolean negative = aString.substring(0, 1).equals("-");
        // if a is negative, return it as-is. Otherwise, return it with a "+" before it.
        return (negative ? aString : "+" + aString); 
    }

    // roundedToHundredth(double x)-> returns a double
    // rounds the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x) {
        return Math.round(x * 100) / 100.0;
    }

    // printInfo() -> returns a String of information about this object
    public String printInfo() {
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and (" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        str += "\n" + findSymmetry();
        str += "\n" + midpoint();
        return str;
    }

    // findSymmetry()-> returns a String 
    // determines what kind of symmetry the two points have
    // (about the x-axis, about the y-axis, or about the origin)
    public String findSymmetry() {
        if (x1 == x2) return "Symmetric about the x-axis";
        if (y1 == y2) return "Symmetric about the y-axis";
        if (y1 == -y2 && x1 == -x2) return "Symmetric about the origin";
        return "No symmetry";
    }

    // midpoint() -> returns a String 
    // the method calculates the midpoint between the two points
    // and returns a string describing it
    public String midpoint() {
        // midpoint = ([x1 + x2] / 2, [y1 + y2] / 2)
        double xMid = roundedToHundredth((x1 + x2) / 2.0);
        double yMid = roundedToHundredth((y1 + y2) / 2.0);
        return "The midpoint of this line is: (" + xMid + "," + yMid + ")";
    }
}
