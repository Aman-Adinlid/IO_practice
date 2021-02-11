package se.lexicon;

import se.lexicon.file.IODemo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static se.lexicon.file.IODemo.*;


public class App {
    public static void main(String[] args) {
        File file = new File("E:\\myproject\\assignments\\IO_practice\\txt");
        String fileContent = read(file);
        System.out.println(fileContent);

        File names = new File("E:\\myproject\\assignments\\IO_practice\\txt");
        for (String string : ReaderNames(names)) {
            System.out.println(string);
        }
        List<String> stringList = new ArrayList<>();
        stringList.add("Water");
        stringList.add("Book");
        stringList.add("Table");
        stringList.add("Glass");
        stringList.add("Soffa");
        File ex3 = new File("ex3.txt");
        writeStrings(ex3, stringList);

        File source = new File("TextName");
        File destination = new File("exercise4_destination.txt");
        IODemo.copyFile(source, destination);

    }
}