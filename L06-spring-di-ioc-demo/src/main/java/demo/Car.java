package demo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {

    private String name;
    private Engine engine;

    public Car(){
        //Tight Coupling
        name="Tata Tiago";
        engine = new Engine("Reverton", 1200);
    }



    public void runCar(){
        System.out.println(name + "name car is running with engine "+engine.getName());
    }
}
