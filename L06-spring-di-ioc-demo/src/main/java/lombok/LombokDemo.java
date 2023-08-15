package lombok;

public class LombokDemo {

    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("Raju", 14, 2666);
        person1.setAge(15);

        System.out.println(person1);
    }
}
