package demo;

public class DiDemo {

    public static void main(String[] args) {
        Car c1 = new Car();

        c1.runCar();
        System.out.println(c1);

        Car c2 = new Car();

        c2.runCar();
        System.out.println(c2);


        //Loosely couple constructor
        Engine engine = new Engine("horsePw", 2500);
//        Car c3 = new Car("Lambo", new Engine("horsePw", 2500));
        Car c3 = new Car("Lambo", engine); //parameter here is dependency injection
        //who is creating this object ?
        //can we say c3 is bean ?

        c3.runCar();
        System.out.println(c3);
    }
}
