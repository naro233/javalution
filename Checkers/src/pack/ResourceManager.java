package pack;
// JAVALUTION TEST
import java.io.*;
import java.nio.file.*;

public class ResourceManager {
    public static void save(Serializable data, String fileName) throws Exception {
        try (ObjectOutputStream outStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
        	outStream.writeObject(data);
        }
    }

    public static Object load(String fileName) throws Exception {
        try (ObjectInputStream inStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return inStream.readObject();
        }
    }
}