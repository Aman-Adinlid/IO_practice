package se.lexicon;

import se.lexicon.file.IODemo;
import se.lexicon.model.Car;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static se.lexicon.file.IODemo.*;


public class App {
    public static void main(String[] args) {
        File file = new File("E:\\myproject\\assignments\\IO_practice\\txt");
        String fileContent = read(file);
        System.out.println(fileContent);
        System.out.println("------------------------------");

        File names = new File("E:\\myproject\\assignments\\IO_practice\\TextName");
        for (String string : readerNames(names)) {
            System.out.println(string);
        }

        System.out.println("------------------------------");
        List<String> stringList = new ArrayList<>();
        stringList.add("Water");
        stringList.add("Book");
        stringList.add("Table");
        stringList.add("Glass");
        stringList.add("Soffa");
        File ex3 = new File("ex3.txt");
        writeStrings(ex3, stringList);

        System.out.println("------------------------------");
        File source = new File("TextName");
        File destination = new File("exercise4_destination.txt");
        if (!source.exists()) {
            try {
                source.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        IODemo.copyFile(source, destination);

        System.out.println("------------------------------");
        List<Car> cars = new ArrayList<>();
        Car Audi = new Car("Abs12", "Audi", "x012");
        Car Volvo = new Car("SCF34", "Audi", "wvv1");
        cars.add(Audi);
        cars.add(Volvo);
        saveList(cars, "Cars.ser");

        System.out.println("---------------------------------------");
        List<Car> result = readFile("E:\\myproject\\assignments\\IO_practice\\Cars.ser");
        for (Car string : result) {
            System.out.println(string.toString());


        }

    }
}