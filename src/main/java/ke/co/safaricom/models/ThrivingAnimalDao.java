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
}
