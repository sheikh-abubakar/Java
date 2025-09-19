**Upcasting** = Child object stored in Parent reference.

````Animal a = new Dog();


-Allowed automatically (implicit).

-You can only access methods/fields available in Animal.

--But if a method is overridden in Dog, the Dog’s version runs (runtime polymorphism).

---


**Downcasting** = Convert Parent reference back to Child reference.

Animal a = new Dog();    // upcasting
Dog d = (Dog) a;         // downcasting
d.bark();                // now we can use Dog methods
Requires explicit cast ((Dog)).

Safe only if the object is actually a Dog.

If not, you get a ClassCastException at runtime.