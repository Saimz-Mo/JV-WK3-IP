package ke.co.safaricom;

import ke.co.safaricom.models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = parseInt(process.environment().get("PORT"));
        }else {
            port = 4567;
        }
        port(port);


        //home route
        get("/", (request, response) -> {
            Map<String, Object > model = new HashMap();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/about", (request, response) -> {
            return new ModelAndView( new HashMap<>(), "about.hbs");
        }, new HandlebarsTemplateEngine());

        //thriving animals form input route
        get("/thriving", (request, response) -> {
            return new ModelAndView( new HashMap<>(), "thriving-form.hbs");
        }, new HandlebarsTemplateEngine());

        //thriving animals form input route for submitting post request
        post("/thriving", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String animalName = request.queryParams("animalName");
            try {
                ThrivingAnimal thrivingAnimal = new ThrivingAnimal(animalName);
                ThrivingAnimalDao thrivingAnimalDao = new ThrivingAnimalDao();
                thrivingAnimalDao.add(thrivingAnimal);
            } catch (IllegalArgumentException exception) {
                System.out.println("Please enter an animal name.");
            }
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            model.put("eAnimals", endangeredAnimalDao.getEndangeredAnimals());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //display list of animals route
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ThrivingAnimalDao thrivingAnimalDao = new ThrivingAnimalDao();
            model.put("animals", thrivingAnimalDao.getThrivingAnimals());
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            model.put("eAnimals", endangeredAnimalDao.getEndangeredAnimals());
            return new ModelAndView( model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //deleting an animal
        get("/animals/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ThrivingAnimalDao thrivingAnimalDao = new ThrivingAnimalDao();
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            thrivingAnimalDao.deleteThrivingAnimal(Integer.parseInt(request.params(":id")));
            endangeredAnimalDao.deleteEndangeredAnimal(Integer.parseInt(request.params(":id")));
            response.redirect("/animals");
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //endangered animals form input route
        get("/endangered", (request, response) -> {
            return new ModelAndView( new HashMap<>(), "endangered-form.hbs");
        }, new HandlebarsTemplateEngine());

        //endangered animals form input route for submitting post request
        post("/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            try {
                EndangeredAnimal endangeredAnimal = new EndangeredAnimal(name, health, age);
                EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
                endangeredAnimalDao.add(endangeredAnimal);
                System.out.println(endangeredAnimalDao.getEndangeredAnimals());
            } catch (IllegalArgumentException exception) {
                System.out.println("Please enter all details");
            }
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            model.put("eAnimals", endangeredAnimalDao.getEndangeredAnimals());
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        //display list of sightings route
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ThrivingAnimalDao thrivingAnimalDao = new ThrivingAnimalDao();
            model.put("animals", thrivingAnimalDao.getThrivingAnimals());
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            model.put("eAnimals", endangeredAnimalDao.getEndangeredAnimals());
            model.put("sightings", Sightings.all());
            return new ModelAndView( model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        //display animals data in sightings form input route for seen animals
        get("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ThrivingAnimalDao thrivingAnimalDao = new ThrivingAnimalDao();
            model.put("animals", thrivingAnimalDao.getThrivingAnimals());
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            model.put("eAnimals", endangeredAnimalDao.getEndangeredAnimals());
            return new ModelAndView( model, "sightings-form.hbs");
        }, new HandlebarsTemplateEngine());

        //deleting a sighting
        get("/sightings/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sightings.find(Integer.parseInt(request.params(":id"))).delete();
            response.redirect("/sightings");
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sightings/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int animalId = Integer.parseInt(name);
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");
            try {
                Sightings sightings = new Sightings( animalId, location, ranger);
                sightings.save();
                System.out.println(Sightings.all());
            } catch (IllegalArgumentException exception) {
                System.out.println("Please enter all details");
            }
            response.redirect("/sightings");
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sightings.find(Integer.parseInt(request.params(":id"))).update();
            ThrivingAnimalDao thrivingAnimalDao = new ThrivingAnimalDao();
            model.put("animals", thrivingAnimalDao.getThrivingAnimals());
            EndangeredAnimalDao endangeredAnimalDao = new EndangeredAnimalDao();
            model.put("eAnimals", endangeredAnimalDao.getEndangeredAnimals());
            return new ModelAndView(model, "sightings-form.hbs");
        }, new HandlebarsTemplateEngine());

        //updating a sighting instance
        post("/sightings/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int id = Integer.parseInt(request.params(":id"));
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Sightings sighting = Sightings.find(id);
            sighting.setLocation(location);
            sighting.setRanger(rangerName);
            sighting.update();
            response.redirect("/sightings");
            return new ModelAndView(model, "sightings-form.hbs");
        }, new HandlebarsTemplateEngine());

    }
}