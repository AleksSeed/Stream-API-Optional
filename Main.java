import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Person> personStream = Stream.of(new Person("Petrushka", 12),
            new Person("Petr Agafonich", 82),
            new Person("Klaudia Shifoner", 80),
            new Person("Gizmo", 37),
            new Person("Kvasimodo", 27));

            BiConsumer<Person, Person> biConsumer = (min, max) -> System.out.println(min.toString() + max.toString());
            Comparator<Person> personComparator = Comparator.comparing(Person::getAge).thenComparing(Person::getName);
            System.out.println("Задание 1");
            findMinMax(personStream, personComparator, biConsumer);

            System.out.println("Задание 2");
            findCountEvenNums(List.of(19, 56, 82, 93, 47, 46, 64));
    }

    public static <T> void findMinMax(
        Stream<? extends T> stream,
        Comparator<? super T> order,
        BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null,null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

   public static void findCountEvenNums(List<Integer> list) {
       Stream<Integer> stream = list.stream();
       Predicate<Integer> predicate = (n) -> (n % 2) == 0;
       Stream<Integer> resStream = stream.filter(predicate);
       System.out.println("Четных чисел: " + resStream.count() + " шт.");
   }

}