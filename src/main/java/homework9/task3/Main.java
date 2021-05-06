package homework9.task3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\fenux\\IdeaProjects\\Java_proffesional\\src\\main\\java\\homework9\\task3\\task3.txt");
        Car car = new Car(21, "Black", 5);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
             ObjectInputStream in = new ObjectInputStream(new FileInputStream(f))) {

            car.writeExternal(out);
            out.writeObject(car);

            System.out.println(car);

            car = new Car(11, "Green", 4);

            System.out.println(car);
            car.readExternal(in);

            System.out.println(car);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
