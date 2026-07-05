package pbo.week8;
import pbo.week8.controller.genericController;
import pbo.week8.model.genericModel;
import pbo.week8.view.genericView;

public class main {
    public static void main(String[] args) {
        genericModel model = new genericModel();
        genericView view = new genericView();
        genericController controller = new genericController(model, view);
        controller.executeSoal1();
        controller.executeSoal2();
        controller.executeSoal3();
    }
    
}
