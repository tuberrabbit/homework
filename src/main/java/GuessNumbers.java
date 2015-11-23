
import java.util.Random;

public class GuessNumbers {
    private String numbers;

    public GuessNumbers(String i) {
        this.numbers = i;
    }

    public GuessNumbers() {
        this.numbers = new String();
    }

    public String getNumbers() {
        return this.numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String compares(GuessNumbers another) {
        String compareto = another.getNumbers();
        Integer timesA = 0;
        Integer timesB = 0;

        for(int results = 0; results < this.numbers.length(); ++results) {
            if(this.numbers.charAt(results) == compareto.charAt(results)) {
                ++timesA;
            } else if(compareto.indexOf(this.numbers.charAt(results)) != -1) {
                ++timesB;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(timesA);
        result.append("A");
        result.append(timesB);
        result.append("B");
        return result.toString();
    }

    public GuessNumbers generator() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for(int index = 0; index < 4; ++index) {
            Integer temp = random.nextInt(10);
            if(result.indexOf(temp.toString()) == -1) {
                result.append(temp);
            } else {
                while(result.indexOf(temp.toString()) != -1) {
                    temp = random.nextInt(10);
                }
                result.append(temp);
            }
        }

        return new GuessNumbers(result.toString());
    }
}
