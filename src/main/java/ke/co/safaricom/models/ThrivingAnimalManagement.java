package ke.co.safaricom.models;

import java.util.List;

public interface ThrivingAnimalManagement {
    
    void add(ThrivingAnimal thrivingAnimal);
    void update(ThrivingAnimal thrivingAnimal);
    ThrivingAnimal getThrivingAnimalById(int id);
    List<ThrivingAnimal> getThrivingAnimals();
    void deleteThrivingAnimal(int id);
    void deleteAllThrivingAnimals();
}
