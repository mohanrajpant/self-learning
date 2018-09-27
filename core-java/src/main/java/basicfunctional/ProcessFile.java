package basicfunctional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFile {


    public static void main(String[] args) throws IOException {
        System.out.println(processFile((BufferedReader::readLine)));
        System.out.println(processFile((reader ->
                reader.readLine() + reader.readLine() + reader.readLine())));
    }
    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try(BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("src/main/java/functional/Apple.java"))) {

            return bufferedReaderProcessor.process(bufferedReader);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader reader) throws IOException;
    }

}
