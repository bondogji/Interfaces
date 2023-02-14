import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List collectAll(Object[] array, Filter filter) {
        List<Object> result = new ArrayList<Object>();
        for (Object x : array) {
            if (filter.accept(x)) {
                result.add(x);
            }
        }
        return result;

    }
}
