package Seminar3Task;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Arrays;
import java.util.Random;
//import java.util.Objects;
//import java.util.List;

public class program {
    public static void name(String[] args) {
        Random rnd = new Random();
        int number1;
        int number2;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (Integer counter = 1; counter <= 20; counter++) {
            number1 = rnd.nextInt(100);
            while (list1.contains(number1)) {
                number1 = rnd.nextInt(100);
            }
            number2 = rnd.nextInt(100);
            while (list1.contains(number2)) {
                number2 = rnd.nextInt(100);
            }
            list1.add(number1);
            list2.add(number2);            
        }
        Collections.sort(list1);
        //Collections.sort(list2);
        System.out.println(list1);
        System.out.println(list2);
        //удаляем из первого списка элементы которые отсутсвуют во 2ом списке
        for (int i = 0; i < list1.size(); i++) {
            if (list2.get(i) != list1.get(i))
            list1.remove(i);
        }
        System.out.println(list1);
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println(" Проводим сортировку по уменьшению значений ");
        System.out.println(list2);
    
        //сортировка пузырьковая
        boolean isSorted = false;
        int tmp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list1.size()-1; i++ ) {
                if (list1.get(i) > list1.get(i+1)) {
                    tmp = list1.get(i);
                    list1.set(i, list1.get(i+1));
                    list1.set(i + 1, tmp);
                        isSorted=false;
                           }
            }
        }

    }

    
}