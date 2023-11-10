package ke.co.safaricom.models;

import org.sql2o.Sql2o;
public class DB {
    //Use when running project locally
    private static final Sql2o connect = new Sql2o(
            "jdbc:postgresql://localhost:5432/wildlife_tracker",
            "postgres",
            "22709689"
    );

    public static Sql2o getConnect() {

        return connect;
    }

    //Use when deploying to heroku
    // public static Sql2o sql2o = new Sql2o(
    //        "jdbc:postgresql://ec2-54-158-247-210.compute-1.amazonaws.com:5432/dek5veegvsbu4",
    //        "zqcqcwnxeihpsu",
    //        "7cb2962b3c8ad1ab91e7923204bd4d9646887af835f755c3a0964e12d372ca1d"
    );
}
