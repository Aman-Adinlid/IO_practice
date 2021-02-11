package se.lexicon;

import java.io.File;

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


    }

}