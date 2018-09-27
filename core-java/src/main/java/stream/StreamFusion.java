package stream;

import java.util.stream.Stream;

public class StreamFusion {

    public static void main(String[] args) {
        Stream.of("The", "cat", "sat", "on", "the", "mat")
            .filter(w -> {
                System.out.println("Filtering: " + w);
                return w.length() == 3;
            })
            .map(w -> {
                System.out.println("Mapping: " + w);
                return w.toUpperCase();
            })
            .forEach(w -> System.out.println("Printing: " + w));
    }

}
