package pbo.week8.view;

import java.util.List;

public class genericView {
    public void printNumericList(List<? extends Number> list) {
        for (Number element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void printHeader(String title) {
        System.out.println("\n--- " + title + " ---");
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
    
}
