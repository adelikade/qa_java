import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;


public class LionTest {

    @Mock
    Feline feline;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLionFoodTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void doesHaveManeMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertFalse(lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeException() throws Exception {
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Man", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}