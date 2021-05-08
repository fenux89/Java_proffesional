package homework10.Doptask;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Volga", 10, "Black");
        Car newCar = new Car();

        try {
            Car cloneCar = (Car) car.clone();

            System.out.println("Поверхностное клонирование");
            System.out.println(car);
            System.out.println(cloneCar);

            car.setName("Ain");
            car.setAge(22);
            car.setColor("Blue");

            System.out.println();
            System.out.println("Поверхностное клонирование, изменение и проверка");
            System.out.println(car);
            System.out.println(cloneCar);


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        newCar = Car.cloneCar(car);
        System.out.println();
        System.out.println("Глубокое клонирование");
        System.out.println(car);
        System.out.println(newCar);

        car.setName("Niva");
        car.setAge(13);
        car.setColor("Green");

        System.out.println();
        System.out.println("Глубокое клонирование");
        System.out.println(car);
        System.out.println(newCar);

    }
}
