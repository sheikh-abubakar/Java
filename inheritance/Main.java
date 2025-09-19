class Animal{
    public void eyes(){
        System.out.println("Animal: has eyes");
    }
    public void eat(){
        System.out.println("Animal eats");
    }
}

class Dog extends Animal{

    public void eyes(){
        //super.eyes();
        System.out.println("dog: has eyes");
    }
    public void bark() {

        System.out.println("Dog barks");
    }
}

public class Main{
    public static void main(String[] args){

        Animal a = new Dog();// upcasting;;;; as eat function is not overided so it will call eat function of animal
        Animal a2 = new Animal();
        Dog d = (Dog) a;//down casting
        Dog d2 = new Dog();

        a.eat();//parent clas function called 
        a.eyes(); // as eyes function is overrided and obj is still of type animal but call child class function
        d.bark();
        d.eyes();
        a2.eat();
        a2.eyes(); // here as obj is type of Animal so  it will call animaal class funtion eyes not of dog like 2nd
        d2.eyes();
        d2.bark();
    }
}

// super can aslo used for same data members to sccess parent data if they are same