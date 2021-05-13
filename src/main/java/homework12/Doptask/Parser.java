package homework12.Doptask;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Parser {
    public static void parse(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Currency[] currencyRates = objectMapper.readValue(new URL(url), Currency[].class);
        String json= "";
        String zoloto ="";
        String fynt ="";
        String forint ="";

        for (Currency currency : currencyRates) {
            if (currency.getTxt().equals("Золото")) {
                System.out.println(currency);
                zoloto = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currency);
            }
            if (currency.getTxt().equals("Фунт стерлінгів")) {
                System.out.println(currency);
                fynt = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currency);
            }
            if (currency.getTxt().equals("Форинт")) {
                System.out.println(currency);
                forint = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currency);
            }
        }
        json="[" + zoloto + "," + fynt + "," + forint + "]";


        System.out.println();

        System.out.println(json);

        Files.write(Paths.get("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\resources\\DopTask.json"),
                json.getBytes(), StandardOpenOption.CREATE);
    }
}
