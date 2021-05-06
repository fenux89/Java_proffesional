package homework9.task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework9\\task2\\task2.txt");
        Animal animal = new Animal(22, "Max", 199);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f))) {

            objectOutputStream.writeObject(animal);
            Animal an = (Animal) objectInputStream.readObject();

            System.out.println(an);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
