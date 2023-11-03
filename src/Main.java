
import controller.FileCompressionController;
import view.FileCompressionView;


public class Main {
    
    public static void main(String[] args) {
        FileCompressionView view = new FileCompressionView();
        FileCompressionController controller = new FileCompressionController(view);

        controller.start();
    }
}

