package ke.co.safaricom.models;

public class ThrivingAnimal extends Animal{
    public static final String ANIMAL_TYPE = "ThrivingAnimal";

    public ThrivingAnimal(String animalName) {
        if (animalName.equals("")){
            throw new RuntimeException("Please submit an Animal name.");
        }
        this.animalName = animalName;
        this.animalType =ANIMAL_TYPE;
        this.id=id;
    }
}
