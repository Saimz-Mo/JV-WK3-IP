package ke.co.safaricom.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SightingsTest {
    private Sightings sightings;
    private Animal animal;

    @BeforeEach
    public void setUp() {
        sightings = new Sightings(1, "Zone A", "Stacy");
    }

    @Test
    public void Sighting_instantiatesCorrectly() {
        assertTrue(sightings instanceof Sightings);
    }

    @Test
    public void getId_sightingInstantiatesWithId(){
        sightings.save();
        assertTrue(sightings.getId() > 0);
    }

    @Test
    public void getAnimalId_sightingInstantiatesWithAnimalId(){
        sightings.save();
        assertEquals(1, sightings.getAnimalId());
    }

    @Test
    public void getLocation_sightingInstantiatesWithLocation(){
        sightings.save();
        assertEquals("Zone A", sightings.getLocation());
    }

    @Test
    public void getRangerName_sightingInstantiatesWithRangerName(){
        sightings.save();
        assertEquals("Stacy", sightings.getRanger());
    }
    @Test
    public void equals_returnsTrueIfAllPropertiesAreTheSame() {
        Sightings anotherSighting = new Sightings(1, "Zone A", "Stacy");
        assertEquals(true, sightings.equals(anotherSighting));
    }

    @Test
    public void save_assignsIdToObject() {
        sightings.save();
        Sightings savedSighting = Sightings.all().get(0);
        assertEquals(sightings.getId(), savedSighting.getId());
    }

    @Test
    public void save_insertsObjectIntoDatabase() {
        sightings.save();
        assertTrue(Sightings.all().get(0).equals(sightings));
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        sightings.save();
        Sightings otherSighting = new Sightings(1, "Zone B",  "Tom");
        otherSighting.save();
        assertEquals(true, Sightings.all().get(0).equals(sightings));
        assertEquals(true, Sightings.all().get(1).equals(otherSighting));
    }

    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        sightings.save();
        Sightings otherSighting = new Sightings(1, "Zone B",  "Mark");
        otherSighting.save();
        assertEquals(Sightings.find(otherSighting.getId()), otherSighting);
    }

    @Test
    public void delete_deletesSighting() {
        sightings.save();
        sightings.delete();
        assertEquals(0, Sightings.all().size());
    }
}
