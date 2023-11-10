package ke.co.safaricom.models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class ThrivingAnimalDao implements ThrivingAnimalManagement {
    public void getDrivers() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void add(ThrivingAnimal thrivingAnimal) {
        getDrivers();
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName, animalType) VALUES (:animalName, :animalType)";

            thrivingAnimal.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", thrivingAnimal.animalName)
                    .addParameter("animalType", thrivingAnimal.animalType)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public void update(ThrivingAnimal thrivingAnimal) {

    }

    @Override
    public ThrivingAnimal getThrivingAnimalById(int id) {
        getDrivers();
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(ThrivingAnimal.class);
        }

    }

    @Override
    public List<ThrivingAnimal> getThrivingAnimals() {
        getDrivers();
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(" SELECT * FROM animals")
                    .throwOnMappingFailure(false)
                    .executeAndFetch(ThrivingAnimal.class);

        }

    }

    @Override
    public void deleteThrivingAnimal(int id) {

    }

    @Override
    public void deleteAllThrivingAnimals() {

    }
}
