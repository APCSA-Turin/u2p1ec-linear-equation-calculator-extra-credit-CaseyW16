package com.example.project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LinearCalculatorTest {

    @Test
    void testFindSymmetry(){
        LinearCalculator c = new LinearCalculator("(1,2)","(-1,-2)");
        String expectedOutput = "Symmetric about the origin";
        String studentOutput = c.findSymmetry();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    void testMidpoint(){
        LinearCalculator c = new LinearCalculator("(3,4)","(3,-4)");
        String expectedOutput = "The midpoint of this line is: (3.0,0.0)";
        String studentOutput = c.midpoint();
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    void testPrintInfo1(){
        LinearCalculator c = new LinearCalculator("(3,4)","(3,-4)");
        String expectedOutput = "The two points are: (3,4)";
        expectedOutput += " and " + "(3,-4)";
        expectedOutput += "\nThe equation of the line between these points is: undefined";
        expectedOutput += "\nThe slope of this line is: -999.99";
        expectedOutput += "\nThe y-intercept of the line is: -999.99";
        expectedOutput += "\nThe distance between the two points is: 8.0";
        expectedOutput += "\nSymmetric about the x-axis";
        expectedOutput += "\nThe midpoint of this line is: (3.0,0.0)";

        String studentOutput = "The two points are: (" + c.getX1() + "," + c.getY1() + ")";
        studentOutput += " and " + "(" + c.getX2() + "," + c.getY2() + ")";
        studentOutput += "\nThe equation of the line between these points is: " + c.equation();
        studentOutput += "\nThe slope of this line is: " + c.slope();
        studentOutput += "\nThe y-intercept of the line is: " + c.yInt();
        studentOutput += "\nThe distance between the two points is: " + c.distance();
        studentOutput += "\n"+c.findSymmetry();
        studentOutput += "\n"+c.midpoint();
     
        assertEquals(expectedOutput,studentOutput);
    }

    @Test
    void testPrintInfo2(){
        LinearCalculator c = new LinearCalculator("(1,2)","(3,4)");
        String expectedOutput = "The two points are: (1,2)";
        expectedOutput += " and " + "(3,4)";
        expectedOutput += "\nThe equation of the line between these points is: y=1.0x+1.0";
        expectedOutput += "\nThe slope of this line is: 1.0";
        expectedOutput += "\nThe y-intercept of the line is: 1.0";
        expectedOutput += "\nThe distance between the two points is: 2.83";
        expectedOutput += "\nNo symmetry";
        expectedOutput += "\nThe midpoint of this line is: (2.0,3.0)";

        String studentOutput = "The two points are: (" + c.getX1() + "," + c.getY1() + ")";
        studentOutput += " and " + "(" + c.getX2() + "," + c.getY2() + ")";
        studentOutput += "\nThe equation of the line between these points is: " + c.equation();
        studentOutput += "\nThe slope of this line is: " + c.slope();
        studentOutput += "\nThe y-intercept of the line is: " + c.yInt();
        studentOutput += "\nThe distance between the two points is: " + c.distance();
        studentOutput += "\n"+c.findSymmetry();
        studentOutput += "\n"+c.midpoint();
     
        assertEquals(expectedOutput,studentOutput);
    }

  

    
}
