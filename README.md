# JV-WK3-IP

# Wildlife Tracker

## Author
Njuguna Simon 

## Description
Wildlife tracker is a web application built using java and java-spark framework. The application allows Rangers to track wildlife sightings in the area.


## Prerequisites
You need to have the following installled on your machine.
- Java JDK
- Gradle
- JDK
- Maven
- Java IDE (Intellij)
- Basic Git knowledge, including an installed version of Git.
- Your application must run on the OpenJDK.

## Technologies Used 

- Java 
- Gradle
- Spark Framework
- CSS (Bootstrap)
- JUnit 
- Handlebars 
- HTML

## Setup Installations Requirements
- To access this project on your local files, you can clone it using these steps
- Open your terminal; This will clone the repository into your local folder.
- Navigate to the folder you cloned into, within src/main/java/App. java and open it with intellij.
- Ensure that dependencies are installed on build.gradle.
- Go to your browser and type localhost:4567


### Development
Want to contribute? Great!
To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch ('git switch -c ft-development')
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (git commit -m 'additional info')
- Push to the branch ('git push origin ft-development')
- Create a Pull Request 

### Behavior Driven Development
The user is able to;

- Run the App on a browser 
- Select the Add ThrivingAnimal, EndangeredAnimal or Sighting tab which will open a form to fill. 
- View the ThrivingAnimal, EndangeredAnimal or Sighting details. 
- Add edit or delete more ThrivingAnimals, EndangeredAnimals or Sightings as possible (It also allows a user to Test the output before actual running of the App)

### Running Tests
- Navigate to the folder you cloned into. Within src/test/java/models and open it with intellij. 
- Select the EndangeredAnimalTests, ThrivingAnimalTests or SightingsTests. 
- This is a sample test to check a correct instance of the EndangeredAnimal, ThrivingAnimal and Sightings objects.

@Test

public void getAnimalType_constantTypeProperty_String() {

EndangeredAnimal rhino = new EndangeredAnimal("Rhino","Healthy", "Young");

assertEquals("Endangered_Animal", rhino.getAnimalType());

}

- Right click within the open test file and run the tests on your terminal.

### SQL
1.Launch postgres 
2.Type in psql Run these commands 
3.CREATE DATABASE wildlife_tracker; 
4.\c wildlife_tracker; 
5.CREATE TABLE animals (id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar); 
6.CREATE TABLE wildlife_tracker=# CREATE TABLE sightings (id serial PRIMARY KEY, animal_id int, location varchar, ranger_name varchar, timestamp timestamp); 
7.CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

## Known Bugs
So far no bugs encountered

## License
This project is under the MIT licence


## Copyright 
Copyright (c) 2023 Njuguna Simon.
