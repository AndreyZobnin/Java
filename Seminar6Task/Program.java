package Seminar6Task;
import java.util.HashMap;
import java.util.Map;


public class Program {
    private static Object OBJECT;
    private Map<Integer, Object> setClone;

    public Program() {
        this.setClone = new HashMap<>();
    }

    public static void main(String[] args) {
//  Разработать программу, имитирующую поведение коллекции HashSet.
//  В программе содать метод add добавляющий элемент,
//  и метод позволяющий выводить эллементы коллекции в консоль.
//  Формат данных Integer.
  /*   Set<Integer> set = new HashSet<>();
     set.add(22);
     set.add(82);
     set.add(224);
     set.add(224);
     set.add(212);
     set.forEach(integer -> System.out.println(integer));
 */
        Program tipoSet = new Program();
        tipoSet.add(12);
        tipoSet.add(66);
        tipoSet.add(135);
        tipoSet.add(200);
        tipoSet.add(299);

        System.out.println(tipoSet);
    }

    public void add(Integer val) {
        this.setClone.put(val, OBJECT);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.setClone.forEach((key, value) -> sb.append(key).append(" "));
        return sb.toString();
    }

}