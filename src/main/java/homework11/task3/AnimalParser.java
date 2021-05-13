package homework11.task3;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AnimalParser {
    public static void main(String[] args) {

        final String fileName = "C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework11\\task3\\task.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // Поле для указания, что тэг name начался
                boolean name = false;
                boolean breed = false;

                // Метод вызывается когда SAXParser "натыкается" на начало тэга
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Если тэг имеет имя name, то мы этот момент отмечаем - начался тэг name
                    if (qName.equalsIgnoreCase("name")) {
                        name = true;

                    }
                    if (qName.equalsIgnoreCase("breed")) {
                        breed = true;
                    }
                }

                // Метод вызывается когда SAXParser считывает текст между тэгами
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // Если перед этим мы отметили, что имя тэга name - значит нам надо текст использовать.
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    }
                    if (breed) {
                        System.out.println("Name: " + new String(ch, start, length));
                        breed = false;
                    }
                }
            };
            // Стартуем разбор методом parse, которому передаем наследника от DefaultHandler, который будет вызываться в нужные моменты
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
