import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMain {

    public static void main(String args[]) {
        gameFlow(6);
    }

    public static void gameFlow(Integer guesstimes) {
        Scanner scanner = new Scanner(System.in);
        GuessNumbers userinput = new GuessNumbers();
        GuessNumbers gamenumber = new GuessNumbers().generator();//generate four unique random digital number range from 0 to 9
//            System.out.println(gamenumber.getNumbers()); see which number is generated.
        List<String> historyInput = new ArrayList<String>();//store the history input
        Boolean isfinded = false;//a flag to stand for dose user win the game
        String results;
        System.out.println("Welcome!");
        while (guesstimes > 0) {
            System.out.print(String.format("Please input your number(%d): ", guesstimes));
            userinput.setNumbers(scanner.next());
            if (historyInput.contains(userinput.getNumbers())) {
                System.out.println("Cannot input duplicate numbers!");
                continue;
            }
            historyInput.add(userinput.getNumbers());
            results = gamenumber.compares(userinput);
            if (results.equals("4A0B")) {
                System.out.println("Congratulations!");
                isfinded = true;
                break;
            }
            else {
                System.out.println(results);
                --guesstimes;
            }
        }
        if (!isfinded) {
            System.out.println("Game Over!");
//            System.out.println(gamenumber.getNumbers()); see which number is generated.

        }

    }
}
