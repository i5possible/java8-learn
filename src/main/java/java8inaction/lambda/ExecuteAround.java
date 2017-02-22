package java8inaction.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
    public static void main(String[] args) throws IOException{
        processFile(BufferedReader::readLine);
        processFile(br -> br.readLine() + br.readLine());
    }

    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReaderProcessor.process(br);
        }
    }
}
