
import controller.FileCompressionController;
import view.FileCompressionView;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    
    public static void main(String[] args) {
        FileCompressionView view = new FileCompressionView();
        FileCompressionController controller = new FileCompressionController(view);

        controller.start();
    }
}

