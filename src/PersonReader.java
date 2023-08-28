import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class PersonReader {
    public static void main(String[] args) {
        // Create a file chooser dialog
        JFileChooser fileChooser = new JFileChooser();

        // Show the file chooser dialog and get the user's choice
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File selectedFile = fileChooser.getSelectedFile();

            // Display the content of the selected file
            displayFile(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void displayFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            // Print column headers
            System.out.println("\nID#        Firstname    Lastname      Title    YOB");
            System.out.println("=============================================");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(", ");

                if (data.length == 5) {
                    String id = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String title = data[3];
                    String yearOfBirth = data[4];

                    // Format and display the data using printf for columns
                    System.out.printf("%-10s %-12s %-12s %-8s %-5s%n",
                            id, firstName, lastName, title, yearOfBirth);
                } else {
                    // Handle invalid data format
                    System.out.println("Invalid data format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("File not found.");
        }
    }
}
