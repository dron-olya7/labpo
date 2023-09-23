import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    public ArrayList<Integer> listData;

    public int listLen;

    ReadFile(String nameFile) {
        try {
            listData = new ArrayList<Integer>();
            Scanner scanner = new Scanner(new FileReader(nameFile));

            while (scanner.hasNextBigInteger()) {
                listData.add(scanner.nextInt());
            }

            scanner.close();

            listLen = listData.size();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
