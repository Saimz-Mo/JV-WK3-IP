package ke.co.safaricom.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ThrivingAnimalTest {
    @Test
    public void all_instantiatesCorrectly_true(){
        ThrivingAnimal giraffe = new ThrivingAnimal("Giraffe");
        assertEquals(true, giraffe instanceof ThrivingAnimal);
    }

    @Test
    public void exception_throwRuntimeExceptionForEmptyField_true(){
        ThrivingAnimal giraffe = new ThrivingAnimal("giraffe");
        assertEquals(true, giraffe instanceof ThrivingAnimal);
    }
    @Test
    public void getName_nameProperty_String() {
        ThrivingAnimal giraffe = new ThrivingAnimal("Giraffe");
        assertEquals("Giraffe", giraffe.getAnimalName());
    }

    @Test
    public void getAnimalType_constantTypeProperty_String() {
        ThrivingAnimal giraffe = new ThrivingAnimal("Giraffe");
        assertEquals("Thriving_Animal", giraffe.getAnimalType());
    }
}
