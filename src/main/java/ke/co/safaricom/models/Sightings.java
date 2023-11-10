package ke.co.safaricom.models;

public class Sightings implements SightingsManagement{
    private int animalId;
    private int id;
    private String animalName;
    private String location;
    private String ranger;
    private Timestamp timestamp;

    public Sightings(int animalId, String location, String ranger) {
        if (ranger.equals("")){
            throw new IllegalArgumentException("Please enter the Ranger's name");
        }
        this.animalId = animalId;
        this.location = location;
        this.ranger = ranger;
    }
}
