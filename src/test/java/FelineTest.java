import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {
    private final List<String> felineFood;
    private final String felineFamily;
    private final int felineKittens;
    private final boolean expectedResult;

    public FelineTest(List<String> felineFood, String felineFamily, int felineKittens, boolean expectedResult) {
        this.felineFood = felineFood;
        this.felineFamily = felineFamily;
        this.felineKittens = felineKittens;
        this.expectedResult = expectedResult;

    }

    @Parameterized.Parameters

    public static Object[][] getFelineTestData() {
        return new Object[][]{
                {List.of("Животные", "Птицы", "Рыба"), "Кошачьи", 1, true},
                {List.of("Трава", "Различные растения"), "Еноты", 122, false},
                {List.of("1", "2"), "2", 0, false},
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void eatFelineMeat() throws Exception {
        Feline feline = new Feline();
        List<String> actualFood = feline.eatMeat();
        boolean actualResult = felineFood.equals(actualFood);
        assertEquals("Кошачьи едят мясо", expectedResult, actualResult);
        System.out.println("Результат выполнения теста:");
        System.out.println(actualResult == expectedResult);
    }

    @Test
    public void getFelineFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        boolean actualResult = felineFamily.equals(actualFamily);
        assertEquals("Должно быть семейство кошачьих", expectedResult, actualResult);
        System.out.println("Результат выполнения теста:");
        System.out.println(actualResult == expectedResult);
    }

    @Test
    public void getFelineKittens() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        boolean actualResult = Objects.equals(felineKittens, actualKittens);
        assertEquals("У кошачьих 1 котенок", expectedResult, actualResult);
        System.out.println("Результат выполнения теста:");
        System.out.println(actualResult == expectedResult);
    }
}

