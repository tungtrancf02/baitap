package ex_6;

abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void greets();
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Woof");
    }

    public void greets(Dog another) {
        System.out.println("Woooof");
    }
}

class BigDog extends Dog {
    public BigDog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Wooow");
    }

    @Override
    public void greets(Dog another) {
        System.out.println("Wooooow");
    }

    public void greets(BigDog another) {
        System.out.println("Wooooooooow");
    }
}

class main {
    public static void main(String[] args) {
        Animal cat = new Cat("Kitty");
        Animal dog = new Dog("Buddy");
        Animal bigDog = new BigDog("Max");

        cat.greets();
        dog.greets();
        bigDog.greets();

        Dog dog1 = new Dog("Rex");
        BigDog bigDog1 = new BigDog("Bruno");
        BigDog bigDog2 = new BigDog("Rocky");

        dog1.greets(dog1);
        bigDog1.greets(dog1);
        bigDog1.greets(bigDog2);
    }
}