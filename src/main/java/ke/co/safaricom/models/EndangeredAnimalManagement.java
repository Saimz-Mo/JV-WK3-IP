package ke.co.safaricom.models;

import java.util.List;

import java.util.List;

public interface EndangeredAnimalManagement {
    void add(EndangeredAnimal endangeredAnimal);
    void update(EndangeredAnimal endangeredAnimal);
    List<EndangeredAnimal> getEndangeredAnimalId(int id);

    EndangeredAnimal getEndangeredAnimalById(int id);

    List<EndangeredAnimal> getEndangeredAnimals();
    void deleteEndangeredAnimal(int id);
    void  deleteAllEndangeredAnimals();
}
