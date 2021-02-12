package se.lexicon.file;

import se.lexicon.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IODemo {
//ex1

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

    //ex2
    public static List<String> readerNames(File source) {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
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

    //ex5

    public static void saveList(List<Car> source, String filePath) {
        try (
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))
        ) {
            objectOutputStream.writeObject(source);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Car> readFile(String filePath) {
        try (
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))
        ) {
            List<Car> returnObject = (List<Car>) objectInputStream.readObject();
            return returnObject;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
