package exercise3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*String text = "Студенты очень любят посещать лекции по Java и Android "+
                "разработке. Всегда слушают очень внимательно и не спят.";
        String[] words = text.split("\\PL+");
        Stream stream = Arrays.stream(words);
        stream.filter(new Predicate() {
                    @Override
                    public boolean test(Object x) {
                        return x.toString().length() <= 3;
                    }
                })
                .map(t->t.toString().toUpperCase())
                .distinct()
                .forEach(x->System.out.println(x));
    }   */
        List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Stream<Integer> myIntegerStream = lst.stream();
        // Фильтрация четных чисел и умножение на 2
        List<Integer> transformedList = myIntegerStream
                .filter(num -> num % 2 == 0) // фильтрация четных чисел
                .map(num -> num * 2) // умножение каждого числа на 2
                .collect(Collectors.toList()); // сбор результатов в список
        System.out.println(transformedList);
    }
}
