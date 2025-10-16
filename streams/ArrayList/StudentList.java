import java.util.ArrayList;

// array list is a class of pakage java.util
//list is an interface and array list implements it

public class StudentList{
    public static void main(String[] args){
        ArrayList<String> students = new ArrayList<>();
        students.add("Ali");
        students.add("abuabkar");

        System.out.println("All students: " + students);
        System.out.println("std at index1: "+ students.get(1));

        students.set(1, "zain");
        System.out.println("after update: "+ students);

        students.remove(0);
        System.out.println("after remove: "+ students);

    }
}