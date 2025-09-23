interface Area
{
    // always abstract method
    //by default al are abstracts
    // no concrete / regular method
    // for multiple inheritance and abstraction
    final static float pi = 3.14f; // by default all are static and final

    float area(float x, float y);
}

class Rectangle implements Area
{
    public float area(float x, float y){
        return x*y;
    }
}

public class Main{
    public static void main(String[] arr){
        Area a = new Rectangle();
        System.out.println("Area is : "+ a.area(2, 4));;
    }
}