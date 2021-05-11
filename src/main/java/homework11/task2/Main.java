package homework11.task2;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        final String fileName = "C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework11\\task2\\city.xml";

        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(new FileOutputStream(fileName));

        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("Country");
        writer.writeStartElement("city");
        writer.writeAttribute("size", "big");
        writer.writeCharacters("Tomsk");
        writer.writeEndElement();
        writer.writeStartElement("street_name");
        writer.writeCharacters("Lenina");
        writer.writeEndElement();
        writer.writeStartElement("house");
        writer.writeCharacters("51");

        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();
    }
}
