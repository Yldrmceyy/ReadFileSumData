import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a File object for the file named "data.txt"
            File file = new File("src/data.txt");

            // Check if the file exists
            if (!file.exists()) {
                file.createNewFile();
                System.out.println(file.getName() + " file created.");
            } else {
                System.out.println(file.getName() + " file already exists!");
            }

            // Create a FileWriter to write to the file, and a BufferedWriter for efficiency
            FileWriter fWriter = new FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fWriter);

            bWriter.write("5\n10\n20\n25\n30");
            bWriter.newLine();
            bWriter.close();

            // Create a FileReader to read from the file, and a BufferedReader for efficiency
            FileReader fReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);
            String line;
            int sum = 0;
            // Read each line from the file and calculate the sum of the numbers
            while ((line = bReader.readLine()) != null) {
                int number = Integer.parseInt(line);
                sum += number;
            }
            System.out.println("Sum of Numbers in the File: " + sum);
            bReader.close();
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

}
