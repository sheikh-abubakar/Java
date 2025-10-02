public class Main{
    // parent class -> Exception e

    static void check_age(int age){
        if(age<18){
            throw new ArithmeticException("not valid");
        }
    }
    public static void main(String[] args){

        check_age(19);
        
        int a[] = new int[5];
        //int[] a = {1,2,3,4,5}

        System.out.println("before exception");
        int n;
        try{
         System.out.println(a[6]);
         n = 5 / 0;   
        }catch(ArrayIndexOutOfBoundsException | ArithmeticException e){
            System.out.println("exception occured");
        }finally{
            System.out.println("after exception");
        }
    }
}

// Error/Exception	Description
// ArithmeticError	Occurs when a numeric calculation goes wrong
// ArrayIndexOutOfBoundsException	Occurs when trying to access an index number that does not exist in an array
// ClassNotFoundException	Occurs when trying to access a class that does not exist
// FileNotFoundException	Occurs when a file cannot be accessed
// InputMismatchException	Occurs when entering wrong input (e.g. text in a numerical input)
// IOException	Occurs when an input or output operation fails
// NullPointerException	Occurs when trying to access an object referece that is null
// NumberFormatException	Occurs when it is not possible to convert a specified string to a numeric type
// StringIndexOutOfBoundsException	Occurs when trying to access a character in a String that does not exist