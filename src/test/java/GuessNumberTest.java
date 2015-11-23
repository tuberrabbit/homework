import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GuessNumberTest {
    private GuessNumbers guessNumbers;
    private GuessNumbers userinput;

    public GuessNumberTest() {

    }

    @Before
    public void setUp() throws Exception {
        guessNumbers = new GuessNumbers();
        userinput = new GuessNumbers();
    }

    @After
    public void tearDown() throws Exception {
        guessNumbers.setNumbers("");
        userinput.setNumbers("");
    }

    @Test
    public void should_get_2A2B_when_1234_compare_to_1345() {
        userinput.setNumbers("1234");
        guessNumbers.setNumbers("1324");

        assertThat(guessNumbers.compares(userinput), equalTo("2A2B"));
    }

    @Test
    public void should_get_4A0B_when_1234_compare_to_1234() {
        userinput.setNumbers("1234");
        guessNumbers.setNumbers("1234");

        assertThat(guessNumbers.compares(userinput), equalTo("4A0B"));
    }

    @Test
    public void should_get_0A0B_when_1234_compare_to_4321() {
        userinput.setNumbers("1234");
        guessNumbers.setNumbers("4321");

        assertThat(guessNumbers.compares(userinput), equalTo("0A4B"));
    }

    @Test
    public void should_get_0A0B_when_1234_compare_to_5678() {
        userinput.setNumbers("1234");
        guessNumbers.setNumbers("5678");

        assertThat(guessNumbers.compares(userinput), equalTo("0A0B"));
    }

    @Test
    public void should_get_four_length_integer_string_from_generator() {
        guessNumbers = new GuessNumbers().generator();

        assertThat(guessNumbers.getNumbers().length(), equalTo(4));
    }

    @Test
    public void should_get_four_digital_integer_from_generator() {
        guessNumbers = new GuessNumbers().generator();

        assertThat(Character.isDigit(guessNumbers.getNumbers().charAt(0)), equalTo(true));
        assertThat(Character.isDigit(guessNumbers.getNumbers().charAt(1)), equalTo(true));
        assertThat(Character.isDigit(guessNumbers.getNumbers().charAt(2)), equalTo(true));
        assertThat(Character.isDigit(guessNumbers.getNumbers().charAt(3)), equalTo(true));
    }

    @Test
    public void should_get_unique_four_digital_integer_number_from_generator() {
        guessNumbers = new GuessNumbers().generator();
        HashSet results = new HashSet();

        for (int index = 0; index < guessNumbers.getNumbers().length(); ++index) {
            results.add(guessNumbers.getNumbers().charAt(index));
        }

        assertThat(results.size(), equalTo(4));
    }


    @Test
    public void should_get_random_integer_from_generator() {
        HashSet results = new HashSet();

        for (int index = 0; index < 5; ++index) {
            results.add(guessNumbers.generator().getNumbers());
        }

        assertThat(results.size(), equalTo(5));
    }

    @Test
    public void should_get_4A0B_from_user_input_1234_into_games() {
        userinput.setNumbers("1234");
        GuessNumbers mockNumbers = mock(GuessNumbers.class);

        when(mockNumbers.generator()).thenReturn(new GuessNumbers("1234"));
        GuessNumbers gameGeneratorNumber = mockNumbers.generator();

        assertThat(gameGeneratorNumber.compares(userinput), equalTo("4A0B"));
    }

    @Test
    public void should_get_0A0B_from_user_input_1234_into_games() {
        userinput.setNumbers("1234");
        GuessNumbers mockNumbers = mock(GuessNumbers.class);

        when(mockNumbers.generator()).thenReturn(new GuessNumbers("5678"));

        assertThat(mockNumbers.generator().compares(userinput), equalTo("0A0B"));

    }

    @Test
    public void should_get_2A2B_from_user_input_1234_into_games() {
        userinput.setNumbers("1234");
        GuessNumbers mockNumbers = mock(GuessNumbers.class);

        when(mockNumbers.generator()).thenReturn(new GuessNumbers("1324"));

        assertThat(mockNumbers.generator().compares(userinput), equalTo("2A2B"));

    }

    @Test
    public void should_get_0A4B_from_user_input_1234_into_games() {
        userinput.setNumbers("1234");
        GuessNumbers mockNumbers = mock(GuessNumbers.class);

        when(mockNumbers.generator()).thenReturn(new GuessNumbers("4321"));

        assertThat(mockNumbers.generator().compares(userinput), equalTo("0A4B"));
    }

}