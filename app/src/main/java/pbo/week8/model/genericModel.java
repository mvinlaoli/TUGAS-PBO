package pbo.week8.model;

import java.util.ArrayList;
import java.util.List;

public class genericModel {
    public <T> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public List<String> copyListString(List<String> list) {
        List<String> clonedList = new ArrayList<>();
        for (String str : list) {
            clonedList.add(str + " cloned");
        }
        return clonedList;
    }

    public List<Integer> copyListInteger(List<Integer> list) {
        List<Integer> clonedList = new ArrayList<>();
        for (Integer num : list) {
            clonedList.add(num + 10);
        }
        return clonedList;
    }

    public List<Double> copyListDouble(List<? extends Number> list) {
        List<Double> clonedList = new ArrayList<>();
        for (Number num : list) {
            clonedList.add(num.doubleValue() * 2);
        }
        return clonedList;
    }
    
}
