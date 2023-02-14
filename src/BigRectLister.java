import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {
    /*
    creates an ArrayList of 10 Rectangles making sure that you have several that are under and
    several that are over a perimeter of 10. Use the collectAll method as before to list the
    rectangles that have big perimeters.
     */
        List<Rectangle> rectangles = new ArrayList<>();
        createRectangles(rectangles);
        System.out.println("All rectangles:");
        printRectangles(rectangles);
        Object[] rectanglesArray = rectangles.toArray();
        List<Rectangle> bigRectangles = Utils.collectAll(rectanglesArray, new BigRectangleFilter());
        System.out.println("\nFound " + bigRectangles.size() + " big rectangles:");
        printRectangles(bigRectangles);
    }

    public static void createRectangles(List<Rectangle> rectangles) {
        rectangles.add(new Rectangle(new Dimension(4, 4)));
        rectangles.add(new Rectangle(new Dimension(3, 8)));
        rectangles.add(new Rectangle(new Dimension(2, 1)));
        rectangles.add(new Rectangle(new Dimension(3, 4)));
        rectangles.add(new Rectangle(new Dimension(15, 34)));
        rectangles.add(new Rectangle(new Dimension(2, 3)));
        rectangles.add(new Rectangle(new Dimension(1, 3)));
        rectangles.add(new Rectangle(new Dimension(2, 4)));
        rectangles.add(new Rectangle(new Dimension(1, 1)));
        rectangles.add(new Rectangle(new Dimension(2, 2)));
    }

    private static void printRectangles(List<Rectangle> rectangles) {
        for (int i = 0; i < rectangles.size(); i++) {
            System.out.println("Rectangle #" + (i + 1)
                    + ": " + "width = "
                    + rectangles.get(i).width + ", height = "
                    + rectangles.get(i).height + ", perimeter = "
                    + (2 * (rectangles.get(i).width + rectangles.get(i).height)));
        }
    }
}

