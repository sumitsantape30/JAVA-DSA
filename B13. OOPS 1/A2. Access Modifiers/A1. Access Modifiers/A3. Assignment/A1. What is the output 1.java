What is the output

What will be the output of the following program ?
// Class Shape and ShapeUse are in same package

class Shape{
    int height;
    int width;
}

public class ShapeUse {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.height = 1;
        System.out.println(s.height);
    }
}

Options
Error
0
1 
None of these

Correct Answer : 1
Solution Description
####Since height is a default data member of class Shape and Shape and ShapeUse both the classes are in same package. 
So we can access height via shape object in ShapeUse class.
