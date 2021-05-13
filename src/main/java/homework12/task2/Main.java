package homework12.task2;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        JacksonParser jacksonParser = new JacksonParser("Украина", "Киев", "Крещатик");

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(jacksonParser);

        System.out.println();
        System.out.println(jacksonParser);

        Files.write(Paths.get("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\resources\\JacksonParser.json"),
                jsonString.getBytes(), StandardOpenOption.CREATE);
    }
}
