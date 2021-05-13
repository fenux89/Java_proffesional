package homework12.task3;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        GsonParser gsonParser = new GsonParser("Украина", "Киев", "Крещатик");

        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(gsonParser);

        System.out.println();
        System.out.println(json);

        Files.write(Paths.get("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\resources\\GsonParser.json"),
                json.getBytes(), StandardOpenOption.CREATE);
    }
}
