package composition;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal[name=" + name + "]";
    }
}

class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Mammal[" + super.toString() + "]";
    }
}

class Cat extends Mammal {
    public Cat(String name) {
        super(name);
    }

    public void greets() {
        System.out.println("Meow");
    }

    @Override
    public String toString() {
        return "Cat[" + super.toString() + "]";
    }
}

class Dog extends Mammal {
    public Dog(String name) {
        super(name);
    }

    public void greets() {
        System.out.println("Woof");
    }

    public void greets(Dog another) {
        System.out.println("Woooof");
    }

    public void greets(Animal another) {
        System.out.println("Grrrr");
    }

    @Override
    public String toString() {
        return "Dog[" + super.toString() + "]";
    }
}

class BigDog extends Dog {
    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("WOOF");
    }

    @Override
    public void greets(Dog another) {
        System.out.println("WOOOOF");
    }

    public void greets(BigDog another) {
        System.out.println("WOOOOOOF");
    }
}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Kitty");
        Dog dog1 = new Dog("Buddy");
        Dog dog2 = new Dog("Rocky");
        BigDog bigDog = new BigDog("Brutus");

        System.out.println(cat);
        cat.greets();

        System.out.println(dog1);
        dog1.greets();
        dog1.greets(dog2);
        dog1.greets(cat);

        System.out.println(bigDog);
        bigDog.greets();
        bigDog.greets(dog1);
        bigDog.greets(bigDog);
    }
}
