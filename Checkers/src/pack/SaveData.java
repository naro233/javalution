package pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

// JAVALUTION TEST
public class SaveData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public GameBoard savedBoard;
    public int savedCurrentPlayer;
    

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