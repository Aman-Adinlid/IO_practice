package se.lexicon.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IODemo {


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


    public static List<String> ReaderNames(File source) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
