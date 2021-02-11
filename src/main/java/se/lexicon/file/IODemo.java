package se.lexicon.file;

import java.io.*;
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

    //ex3
    public static List<String> writeStrings(File destination, List<String> src) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for (String toWrite : src) {
                writer.write(toWrite);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }
//ex4
    public static void copyFile(File source, File destination) {
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))
        ) {
            byte[] buffer = new byte[1042];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}