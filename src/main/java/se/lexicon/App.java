package se.lexicon;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        File file = new File("E:\\myproject\\assignments\\IO_practice\\txt");
        String fileContent = read(file);
        System.out.println(fileContent);

    }

    public static String read(File source) {
        StringBuilder readText = new StringBuilder();

        try (
                FileReader fileReader = new FileReader(source);
        ) {

            int i;
            while ((i = fileReader.read()) != -1) {
                char letter = (char) i;
                readText.append(letter);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return readText.toString();
    }
}