package homework10.task3;

public class Main {
    public static void main(String[] args) {
        Eagle eagle = new Eagle("Max", 10, "Black");
        Eagle clonEagle = Eagle.cloneEagle(eagle);

        System.out.println(eagle);
        eagle.setName("Ain");
        eagle.setAge(22);
        eagle.setColor("Blue");

        System.out.println();
        System.out.println(eagle);
        System.out.println(clonEagle);

        try {
            clonEagle = (Eagle) eagle.clone();
            System.out.println();
            System.out.println(eagle);
            System.out.println(clonEagle);

            eagle.setName("Ted");
            eagle.setAge(11);
            eagle.setColor("Green");

            System.out.println();
            System.out.println(eagle);
            System.out.println(clonEagle);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
