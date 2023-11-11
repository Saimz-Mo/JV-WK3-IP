package ke.co.safaricom.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EndangeredAnimalsTest {
    @Test
    public void all_instantiatesCorrectly_true(){
        EndangeredAnimal rhino = new EndangeredAnimal("Rhino","healthy", "young");
        assertEquals(true, rhino instanceof EndangeredAnimal);
    }
    @Test
    public void exception_throwRuntimeExceptionForEmptyField_true(){
        EndangeredAnimal rhino = new EndangeredAnimal("Rhino","healthy", "");
        assertEquals(true, rhino instanceof EndangeredAnimal);
    }
    @Test
    public void equals_returnsTrueIfObjectIsTheSame_true(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Rhino","healthy", "Young");
        EndangeredAnimal rhino = new EndangeredAnimal("Rhino","healthy", "Young");
        assertTrue(rhino.equals( testAnimal));
    }
    @Test
    public void getHealth_healthProperty_String() {
        EndangeredAnimal rhino = new EndangeredAnimal("Rhino","Healthy", "Young");
        assertEquals("Healthy", rhino.getHealth());
    }
    @Test
    public void getName_nameProperty_String() {
        EndangeredAnimal rhino = new EndangeredAnimal("Rhino","Healthy", "Young");
        assertEquals("Rhino", rhino.getAnimalName());

    }
    @Test
    public void getAge_ageProperty_String() {
        EndangeredAnimal rhino = new EndangeredAnimal("Rhino","Healthy", "Young");
        assertEquals("Young", rhino.getAge());

    }
    @Test
    public void getAnimalType_constantTypeProperty_String() {
        EndangeredAnimal rhino = new EndangeredAnimal("Rhino","Healthy", "Young");
        assertEquals("Endangered_Animal", rhino.getAnimalType());
    }
}
