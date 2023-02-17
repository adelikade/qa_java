import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Mock
    Feline feline;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCatSoundTest() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        assertEquals("Кошка должна мяукать", expectedSound, cat.getSound());
    }

    @Test
    public void getCatFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        assertEquals("Кошка должна есть мясо", expectedFood, cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

}

