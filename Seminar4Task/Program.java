/* 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader
2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. Фамилии, имена, отчества, возрас и пол в отдельных списках.
4.Отсортировать по возрасту используя дополнительный список индексов. */
package Seminar4Task;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class Program {
    public static void main(String[] args) throws IOException {
        String str = "";
        ArrayList<String> familyName = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> surName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> indexes = new LinkedList<>();

        try {
            try (FileWriter wr = new FileWriter("db.sql")) {
               	wr.append("Зобнин Андрей Владимирович 40 М\n");
                wr.append("Иванов Иван Иванович 34 М\n");
                wr.append("Сачков Виталий Олегович 44 М\n");
                wr.append("Руднева Наталия Борисовна 35 Ж\n");
                wr.append("Пушкина Ольга Александровна 41 Ж\n");
                wr.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            try (FileReader fr = new FileReader("db.sql")) {
                while (fr.ready()) str += (char) fr.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String [] strArray = str.split("\n");
        System.out.println("Сушествующий список:");
        for (int i = 0; i < strArray.length; i++) {
            String [] strTmp = strArray[i].split(" ");
            System.out.printf("%s %s.%s. %s %s\n", strTmp[0], strTmp[1].toUpperCase().charAt(0), strTmp[2].toUpperCase().charAt(0), strTmp[3], strTmp[4]);

            familyName.add(strTmp[0]);
            name.add(strTmp[1]);
            surName.add(strTmp[2]);
            age.add(Integer.parseInt(strTmp[3]));
            gender.add(strTmp[4].equals("М")? false : true);
            indexes.add(i);
        }

        System.out.println("\nА этот Список отсортирован по возрасту:");
        sortIndexesByIntList(age, indexes);
        printFromLists(familyName, name, surName, age, gender, indexes);
    }

    private static void printFromLists(ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> list3,
                                       ArrayList<Integer> list4, ArrayList<Boolean> list5, LinkedList<Integer> indexes) {

        for (Integer i : indexes) {
            String gender = (list5.get(i).equals(true) ? "Ж" : "М");
            System.out.printf("%s %s.%s. %s %s\n", list1.get(i), list2.get(i).toUpperCase().charAt(0),
                    list3.get(i).toUpperCase().charAt(0), list4.get(i), gender);
        }
    }

    private static void sortIndexesByIntList(ArrayList<Integer> arrayToSort, LinkedList<Integer> ind) {
        ArrayList<Integer> arr = new ArrayList<>(arrayToSort);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int tmp = ind.get(j);
                    ind.set(j, ind.get(j + 1));
                    ind.set(j + 1, tmp);

                    tmp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, tmp);
                }
            }
        }
    }
}
