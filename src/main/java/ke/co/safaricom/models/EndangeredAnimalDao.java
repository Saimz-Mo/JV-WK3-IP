package ke.co.safaricom.models;

import java.util.List;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class EndangeredAnimalDao {
    public void getDrivers(){
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(EndangeredAnimal endangeredAnimal) {
        getDrivers();
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalName, health, age, animalType) VALUES (:animalName, :health, :age, :animalType)";

            endangeredAnimal.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", endangeredAnimal.animalName)
                    .addParameter("health", endangeredAnimal.health)
                    .addParameter("age", endangeredAnimal.age)
                    .addParameter("animalType", endangeredAnimal.animalType)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void update(EndangeredAnimal endangeredAnimal) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE animals SET animalName = :animalName, health = :health, age = :age, animalType= :animalType WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("animalName", endangeredAnimal.animalName)
                    .addParameter("health", endangeredAnimal.health)
                    .addParameter("age", endangeredAnimal.age)
                    .addParameter("animalType", endangeredAnimal.animalType)
                    .executeUpdate();
        }
    }

    @Override
    public List<EndangeredAnimal> getEndangeredAnimalId(int id) {
        return null;
    }

    @Override
    public EndangeredAnimal getEndangeredAnimalById(int id) {
        getDrivers();
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery("SELECT * FROM animals WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }

    @Override
    public List<EndangeredAnimal> getEndangeredAnimals() {
        getDrivers();
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(" SELECT * FROM animals")
                    .executeAndFetch(EndangeredAnimal.class);
        }

    }

    @Override
    public void deleteEndangeredAnimal(int id) {
        getDrivers();
        String sql = "DELETE FROM animals WHERE id = :id";

        try(Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllEndangeredAnimals() {
        getDrivers();
        String sql = "DELETE FROM animals";

        try(Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException e){
            System.out.println(e);
        }
    }
}
