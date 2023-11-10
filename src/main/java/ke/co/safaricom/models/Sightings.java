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

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
