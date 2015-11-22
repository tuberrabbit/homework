import java.util.HashSet;

import jdk.nashorn.internal.objects.NativeUint8Array;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class GuessNumberTest {
    public GuessNumberTest() {
    }

    @Test
    public void should_get_2A2B_when_1234_compare_to_1345() {
        Numbers source = new Numbers("1234");
        Numbers compareto = new Numbers("1243");
        MatcherAssert.assertThat(source.compares(compareto), CoreMatchers.equalTo("2A2B"));
    }

    @Test
    public void should_get_4A0B_when_1234_compare_to_1234() {
        Numbers source = new Numbers("1234");
        Numbers compareto = new Numbers("1234");
        MatcherAssert.assertThat(source.compares(compareto), CoreMatchers.equalTo("4A0B"));
    }

    @Test
    public void should_get_0A0B_when_1234_compare_to_4321() {
        Numbers source = new Numbers("1234");
        Numbers compareto = new Numbers("4321");

        MatcherAssert.assertThat(source.compares(compareto), CoreMatchers.equalTo("0A4B"));
    }

    @Test
    public void should_get_0A0B_when_1234_compare_to_5678() {
        Numbers source = new Numbers("1234");
        Numbers compareto = new Numbers("5678");

        MatcherAssert.assertThat(source.compares(compareto), CoreMatchers.equalTo("0A0B"));
    }

    @Test
    public void should_get_four_length_integer_string_from_generator() {
        Numbers integer_number = Numbers.generator();

        MatcherAssert.assertThat(Integer.valueOf(integer_number.getNumbers().length()), CoreMatchers.equalTo(Integer.valueOf(4)));
    }

    @Test
    public void should_get_four_digital_integer_from_generator() {
        Numbers integer_number = Numbers.generator();

        MatcherAssert.assertThat(Boolean.valueOf(Character.isDigit(integer_number.getNumbers().charAt(0))), CoreMatchers.equalTo(Boolean.valueOf(true)));
        MatcherAssert.assertThat(Boolean.valueOf(Character.isDigit(integer_number.getNumbers().charAt(1))), CoreMatchers.equalTo(Boolean.valueOf(true)));
        MatcherAssert.assertThat(Boolean.valueOf(Character.isDigit(integer_number.getNumbers().charAt(2))), CoreMatchers.equalTo(Boolean.valueOf(true)));
        MatcherAssert.assertThat(Boolean.valueOf(Character.isDigit(integer_number.getNumbers().charAt(3))), CoreMatchers.equalTo(Boolean.valueOf(true)));
    }

    @Test
    public void should_get_unique_four_digital_integer_number_from_generator() {
        Numbers unique_integer = Numbers.generator();
        HashSet results = new HashSet();

        for (int index = 0; index < unique_integer.getNumbers().length(); ++index) {
            results.add(Character.valueOf(unique_integer.getNumbers().charAt(index)));
        }

        MatcherAssert.assertThat(Integer.valueOf(results.size()), CoreMatchers.equalTo(Integer.valueOf(4)));
    }

    @Test
    public void should_get_random_integer_from_generator() {
        HashSet results = new HashSet();

        for (int index = 0; index < 5; ++index) {
            results.add(Numbers.generator());
        }

        MatcherAssert.assertThat(Integer.valueOf(results.size()), CoreMatchers.equalTo(Integer.valueOf(5)));
    }

    @Test
    public void should_get_4A0B_from_user_input_1234_into_games(){
        
    }
}