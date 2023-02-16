import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Parameterized.Parameter(0)
    public int numberOfKittens;
    @Parameterized.Parameter(1)
    public int expectedLionResult;
    @Mock
    Feline feline;

    @Parameterized.Parameters(name = "{index}: {0}-{1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1}
        });
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLionKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(numberOfKittens);
        Assert.assertEquals(expectedLionResult, lion.getKittens());
    }
}