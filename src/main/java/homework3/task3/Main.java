package homework3.task3;

public class Main {
    public static void main(String[] args) {
        SimpleHashMap<String, String> mymap = new SimpleHashMap<>();
        mymap.put("12", "двенадцать");
        mymap.put("21", "двадцать один");
        mymap.put("2", "два");
        mymap.put("3", "три");
        mymap.put("2", "22");

        System.out.println(mymap.get("12"));
        System.out.println(mymap.get("21"));
        System.out.println(mymap.get("2"));
        System.out.println(mymap.get("3"));


        mymap.remove("21");
        mymap.remove("3");
        System.out.println();
        System.out.println(mymap.get("12"));
        System.out.println(mymap.get("21"));
        System.out.println(mymap.get("2"));
        System.out.println(mymap.get("3"));
        System.out.println(mymap.get("99"));

    }
}
