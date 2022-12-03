package pack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

// JAVALUTION TEST
public class DataManager implements Serializable{
    public GameBoard savedBoard;
    public int savedCurrentPlayer;
    
    public void save(GameBoard data, String fileName) throws Exception {
        //try (ObjectOutputStream outStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
       	//outStream.writeObject(data);
       // }
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			System.out.print("save");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static GameBoard load(String fileName) throws Exception {
        GameBoard newData = null;
    	try {

            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            newData = (GameBoard) ois.readObject();

            ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }

        return newData;
    }
}