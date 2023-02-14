import java.awt.*;

public class BigRectangleFilter implements Filter {
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle r = (Rectangle) x;
            // if perimeter is greater than 10
            return 2 * (r.width + r.height) > 10;
        } else {
            return false;
        }
    }
}