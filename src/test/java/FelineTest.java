import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {


    @Test
    public void getFelineFood() throws Exception {
        Feline feline = new Feline();
        List<String> actualFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(actualFood, feline.getFood("Хищник"));
    }

    @Test
    public void getFelineFamily() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getFelineKittens() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        assertEquals(1, actualKittens);
    }
}

