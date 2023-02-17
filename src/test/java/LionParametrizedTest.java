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

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Parameterized.Parameter
    public int numberOfKittens;
    @Mock
    Feline feline;

    @Parameterized.Parameters()
    public static Object[][] getNumberOfKittens() {
        return new Object[][]{
                {1},
                {2}
        };
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLionKittensTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(numberOfKittens);
        Assert.assertEquals(numberOfKittens, lion.getKittens());
    }
}