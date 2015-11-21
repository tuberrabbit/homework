import java.util.ArrayList;
import java.util.List;

public class CollectionsOps {

    public static List<Integer> odd(List<Integer> numbers) {
        List<Integer> results = new ArrayList<Integer>();

        for (Integer item: numbers) {
            if (item % 2 != 0){
                results.add(item);
            }
        }
        return results;
    }

    public static List<Integer> doubleEvens(List<Integer> numbers) {
        List<Integer> results = new ArrayList<Integer>();
        for (Integer item: numbers) {
            if (item % 2 == 0){
                results.add(item*2);
            }
            else {
                results.add(item);
            }
        }
        return results;
    }

    public static String tryFind(Integer toFind, List<Integer> numbers) {
        String result = "Not Found";
        for (Integer item: numbers) {
            if (item == toFind){
                result = "Hello, " + item.toString();
                break;
            }
        }
        return result;

    }
}
