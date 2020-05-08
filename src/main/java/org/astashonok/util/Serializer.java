package org.astashonok.util;

import java.io.*;

public class Serializer<T> {
    public static<T> void write(String fileName, T value) {
        try (ObjectOutputStream stream =
                     new ObjectOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(fileName)))) {
            stream.writeObject(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T read(String fileName) {
        T value = null;
        try (ObjectInputStream stream =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(fileName)))) {
            value = (T) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

    @SuppressWarnings("unchecked")
    public static <T> T read(File file) {
        T value = null;
        try (ObjectInputStream stream =
                     new ObjectInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(file)))) {
            value = (T) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
