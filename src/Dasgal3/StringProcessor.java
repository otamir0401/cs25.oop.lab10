package Dasgal3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringProcessor {

    public void processStrings(List<String> input, Predicate<String> filter,
                               Function<String, String> transformer,
                               Consumer<String> action) {
        input.stream()
             .filter(filter)
             .map(transformer)
             .forEach(action);
    }

    public static void main(String[] args) {
        List<String> data = Arrays.asList("маргашаал", "гутал", "процессор");

        StringProcessor sp = new StringProcessor();

        sp.processStrings(data,
            s -> s.length() > 5,                         // Predicate
            s -> new StringBuilder(s).reverse().toString(), // Function
            s -> System.out.println("ГАРШИЛ: " + s.toUpperCase()) // Consumer
        );
    }
}
