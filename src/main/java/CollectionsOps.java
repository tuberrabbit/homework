import java.util.List;
import java.util.stream.Collectors;

public class CollectionsOps {

    public static List<Integer> odd(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> doubleEvens(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number % 2 == 0 ? number * 2 : number)
                .collect(Collectors.toList());
    }

    public static String tryFind(Integer toFind, List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number.equals(toFind))
                ? "Hello, " + toFind : "Not Found";
    }
}
