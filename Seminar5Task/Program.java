package Seminar5Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Program {
    public static void main(String [] args) {
        HashMap<Integer, String> dictPeople = new HashMap<Integer, String>(); 
        dictPeople.put(1, "Зобнин Андрей Владимирович 40 М");
        dictPeople.put(2, "Иванов Иван Иванович 34 М");
        dictPeople.put(3, "Сачков Виталий Олегович 44 М");
        dictPeople.put(4, "Руднева Наталия Борисовна 35 Ж");
        dictPeople.put(5, "Пушкина Ольга Александровна 41 Ж");
        if (!dictPeople.containsKey(6)) {
            dictPeople.put(6, "Галкин Александ Александрович 46 Ж");
        }
            List<Map.Entry<Integer, String>> list = new ArrayList<>(dictPeople.entrySet());
            Collections.sort(list, new Comparator <Map.Entry<Integer, String>>()  {
        public int compare (Map.Entry<Integer, String> entry1, Map.Entry<Integer, String> entry2){
            return Integer.compare(Integer.parseInt(entry1.getValue().split(" ") [3]),
            Integer.parseInt(entry2.getValue().split(" ") [3]));
			}
        });
        System.out.println("\nСортировка по возрастанию: \n");
        int count = 1;
        for (Map.Entry<Integer, String> entry : list) {
        String[] parts = entry.getValue().split(" ");
        String surname = parts[0];
        String initials = parts [1].charAt(0) + "." + parts[2].charAt(0) + ".";
        String age = parts[3];
        String gender = parts[4];
        System.out.println(count + "." + surname + " " +initials + " " + age + " " + gender.toUpperCase());
        count++;
        
        }
    }
}
