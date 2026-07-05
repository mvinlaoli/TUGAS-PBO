package pbo.week8.controller;
import pbo.week8.model.genericModel;
import pbo.week8.view.genericView;

import java.util.Arrays;
import java.util.List;

public class genericController {
    private genericModel model;
    private genericView view;

    public genericController(genericModel model, genericView view) {
        this.model = model;
        this.view = view;
    }

    public void executeSoal1() {
        view.printHeader("Test Soal 1: Swap Generic");
        
        String[] nama = {"Jolvin", "Laoli"};
        view.printMessage("Sebelum swap: " + Arrays.toString(nama));
        
        model.swap(nama, 0, 1);
        
        view.printMessage("Sesudah swap: " + Arrays.toString(nama));
    }

    public void executeSoal2() {
        view.printHeader("Test Soal 2: Print Numeric List");
        
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.5, 4.5);
        List<String> stringList = Arrays.asList("a", "b");

        view.printMessage("Print List Integer: ");
        view.printNumericList(intList); 

        view.printMessage("Print List Double: ");
        view.printNumericList(doubleList);
        
       // Jika inputan string maka error

        
    }

    public void executeSoal3() {
        view.printHeader("Test Soal 3: Copy List (Overloading/Custom Rule)");

        List<String> stringList = Arrays.asList("a", "b");
        List<Integer> intList = Arrays.asList(3, 1);
        List<Double> doubleList = Arrays.asList(1.5, 4.5);

        // Aturan String
        List<String> clonedStrings = model.copyListString(stringList);
        view.printMessage("String awal : " + stringList);
        view.printMessage("String clone: " + clonedStrings);

        // Aturan Integer
        List<Integer> clonedIntegers = model.copyListInteger(intList);
        view.printMessage("Integer awal : " + intList);
        view.printMessage("Integer clone: " + clonedIntegers);

        // Aturan Double
        List<Double> clonedDoubles = model.copyListDouble(doubleList);
        view.printMessage("Double awal : " + doubleList);
        view.printMessage("Double clone: " + clonedDoubles);
    }
}
    
