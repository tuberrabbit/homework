/**
 * Created by apprentice on 15-11-22.
 */
import java.util.Random;

public class Numbers {
    private String numbers;

    public Numbers(String i) {
        this.numbers = i;
    }

    public String getNumbers() {
        return this.numbers;
    }

    public String compares(Numbers another) {
        String compareto = another.getNumbers();
        Integer timesA = Integer.valueOf(0);
        Integer timesB = Integer.valueOf(0);

        for(int results = 0; results < this.numbers.length(); ++results) {
            if(this.numbers.charAt(results) == compareto.charAt(results)) {
                timesA = Integer.valueOf(timesA.intValue() + 1);
            } else if(compareto.indexOf(this.numbers.charAt(results)) != -1) {
                timesB = Integer.valueOf(timesB.intValue() + 1);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(timesA);
        result.append("A");
        result.append(timesB);
        result.append("B");
        return result.toString();
    }

    public static Numbers generator() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for(int index = 0; index < 4; ++index) {
            Integer temp = Integer.valueOf(random.nextInt(10));
            if(result.indexOf(temp.toString()) == -1) {
                result.append(temp);
            } else {
                while(result.indexOf(temp.toString()) != -1) {
                    temp = Integer.valueOf(random.nextInt(10));
                }
                result.append(temp);
            }
        }

        return new Numbers(result.toString());
    }
}
