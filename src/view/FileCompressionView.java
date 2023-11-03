
package view;

import java.util.Scanner;


public class FileCompressionView {
    public Scanner scanner;

    public FileCompressionView() {
        scanner = new Scanner(System.in);
    }

    public String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
