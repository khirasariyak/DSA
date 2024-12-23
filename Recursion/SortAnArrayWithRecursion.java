package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
* Sort an array with recursion
* */

public class SortAnArrayWithRecursion {

    public static void main(String[] args) {
        List<Integer> list = getList();
        sort(list);
        System.out.println(list);
    }

    private static void sort(List<Integer> list) {

        if (list.size() == 1) {
            return;
        }

        int lastIndex = list.size() - 1;
        int temp = list.get(lastIndex);
        list.remove(lastIndex);

        sort(list);
        insert(list, temp);
    }

    private static void insert(List<Integer> list, int temp) {

        int lastIndex = list.size() - 1;

        if (list.isEmpty() || list.get(lastIndex) <= temp) {
            list.add(temp);
            return;
        }

        int val = list.get(lastIndex);
        list.remove(lastIndex);
        insert(list, temp);
        list.add(val);
    }

    private static List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        return list;
    }

}
