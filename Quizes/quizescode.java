// Write a program that will display the following attributes of the file titled as "filename"?

// - The absolute path
// - The last modified and accessed time
// - The reading and writing permissions
// - The current filename is directory/file?


import java.io.File;
import java.text.SimpleDateFormat;

public class FileAttributes {

    public static void main(String[] args) {
        // create a File object for the given filename
        File file = new File("filename.txt"); // change to your actual file name

        // check if file exists
        if (file.exists()) {
            // Display the absolute path
            System.out.println("Absolute Path: " + file.getAbsolutePath());

            // Display last modified time
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("Last Modified: " + sdf.format(file.lastModified()));

            // Display permissions
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());

            // Check if it's a file or a directory
            if (file.isFile()) {
                System.out.println("This is a file.");
            } else if (file.isDirectory()) {
                System.out.println("This is a directory.");
            }
        } else {
            System.out.println("File does not exist!");
        }
    }
}


// write a program that:
// - Prompts the user to enter two integer values.
// - Displays whether the second number is a proper factor of the first number.
// - Uses a custom exception class invalidFactorException to throw an exception when the second number is not a factor of the first.
// - Includes appropriate code for exception handling.


import java.util.Scanner;

// Custom Exception Class
class InvalidFactorException extends Exception {
    public InvalidFactorException(String message) {
        super(message);
    }
}

public class FactorCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input from user
            System.out.print("Enter the first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = sc.nextInt();

            // Check for factor
            if (num2 == 0) {
                throw new InvalidFactorException("Division by zero is not allowed!");
            } else if (num1 % num2 != 0) {
                // If num2 is not a proper factor of num1, throw custom exception
                throw new InvalidFactorException(num2 + " is NOT a proper factor of " + num1);
            } else {
                System.out.println(num2 + " is a proper factor of " + num1);
            }

        } catch (InvalidFactorException e) {
            // Handle custom exception
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("Invalid input! Please enter integers only.");
        }

        sc.close();
    }
}


// Question 01: Write a program to match the contents of two files. 
// Your program should display the percentage of matched (i.e., same) words in the files.


import java.io.*;
import java.util.*;

public class FileMatchPercentage {
    public static void main(String[] args) throws IOException {
        // Open both files
        BufferedReader file1 = new BufferedReader(new FileReader("file1.txt"));
        BufferedReader file2 = new BufferedReader(new FileReader("file2.txt"));

        // Read all words from both files
        ArrayList<String> words1 = new ArrayList<>();
        ArrayList<String> words2 = new ArrayList<>();

        String line;
        while ((line = file1.readLine()) != null) {
            String[] parts = line.split("\\s+"); // split by spaces
            for (String word : parts)
                words1.add(word.toLowerCase());
        }

        while ((line = file2.readLine()) != null) {
            String[] parts = line.split("\\s+");
            for (String word : parts)
                words2.add(word.toLowerCase());
        }

        file1.close();
        file2.close();

        // Count matches
        int matchCount = 0;
        for (String w : words1) {
            if (words2.contains(w))
                matchCount++;
        }

        // Calculate percentage
        double totalWords = Math.max(words1.size(), words2.size());
        double percentage = ((double) matchCount / totalWords) * 100;

        // Display result
        System.out.println("Percentage of matched words: " + percentage + "%");
    }
}



//  create a copy of an existing file with error and exception handling in Java


import java.io.*;

class copyFile {
    public static void main(String args[]) {
        // You can change filenames as needed
        String sourceFile = "source.txt";
        String destFile = "copy.txt";

        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            // Open source file for reading
            fin = new FileInputStream(sourceFile);

            // Create or open destination file for writing
            fout = new FileOutputStream(destFile);

            int data;
            // Read bytes one by one and write to destination
            while ((data = fin.read()) != -1) {
                fout.write(data);
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Error: Problem while reading or writing the file!");
            e.printStackTrace();

        } finally {
            // Always close the streams in finally block
            try {
                if (fin != null) fin.close();
                if (fout != null) fout.close();
            } catch (IOException e) {
                System.out.println("Error closing files!");
                e.printStackTrace();
            }
        }
    }
}



//  Suppose you have a file test.txt on location D:/files/. 
//  Check that either file exists on this location or not? Display read/write permission, creation and "last modified time".


import java.io.File;
import java.util.Date;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileInfo {
    public static void main(String[] args) {
        try {
            // Create file object
            File file = new File("D:/files/test.txt");

            // Check if file exists
            if (file.exists()) {
                System.out.println("File exists!");

                // Display absolute path
                System.out.println("Absolute Path: " + file.getAbsolutePath());

                // Check if it is a file or directory
                if (file.isFile()) {
                    System.out.println("It is a file.");
                } else if (file.isDirectory()) {
                    System.out.println("It is a directory.");
                }

                // Show read and write permissions
                System.out.println("Readable: " + file.canRead());
                System.out.println("Writable: " + file.canWrite());

                // Show last modified time
                System.out.println("Last Modified: " + new Date(file.lastModified()));

                // Show creation time using NIO (new method)
                Path path = file.toPath();
                BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println("Creation Time: " + attr.creationTime());
            } 
            else {
                System.out.println("File does NOT exist at this location!");
            }
        } 
        catch (Exception e) {
            System.out.println("An error occurred while reading file info.");
            e.printStackTrace();
        }
    }
}
// QUIZ null  for more detailed check gpt chat 
//  https://chatgpt.com/c/68fa36e0-40f8-8323-a30f-d30fde53b0b7   

//A palindrome is a number or a text phrase that reads the same backward as forward. For example, each of the following five-digit integers is a palindrome: 12321, 55555, 45554 and 11611. Write a program that reads in a five-digit integer and determines whether it is a palindrome.
//  Hint: Use the division and modulus operators to separate the number into its individual digits.
import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input a five-digit integer
        System.out.print("Enter a five-digit integer: ");
        int num = input.nextInt();
        
        // Extract digits using division and modulus
        int d1 = num / 10000;           // first digit
        int d2 = (num / 1000) % 10;     // second digit
        int d3 = (num / 100) % 10;      // third digit
        int d4 = (num / 10) % 10;       // fourth digit
        int d5 = num % 10;              // fifth digit
        
        // Check if it’s a palindrome
        if (d1 == d5 && d2 == d4) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is not a palindrome.");
        }

        input.close();
    }
}
// //
// The question is: Write down a function (named as find()) for a dictionary system that will accept input string as 
// "word name" from console and return the "meaning of word" to console back after searching from storage structure.
//  You have to implement Find(String) method for the searching of meaning. Instructions: 
// - Create HashMap as storage structure for dictionary. - No marks will be given for any irrelevant answers.
import java.util.HashMap;
import java.util.Scanner;

public class DictionarySystem {

    // HashMap used as storage structure for dictionary
    private static HashMap<String, String> dictionary = new HashMap<>();

    // Static block to initialize dictionary words
    static {
        dictionary.put("apple", "A sweet fruit that grows on trees.");
        dictionary.put("book", "A collection of pages containing written or printed material.");
        dictionary.put("computer", "An electronic device that processes data.");
        dictionary.put("river", "A large natural stream of water flowing in a channel to the sea.");
    }

    // Function to find meaning of the given word
    public static String find(String word) {
        // Search for word in the HashMap
        if (dictionary.containsKey(word.toLowerCase())) {
            return dictionary.get(word.toLowerCase());
        } else {
            return "Word not found in dictionary!";
        }
    }

    // Main method to take input and display result
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word name: ");
        String inputWord = sc.nextLine();

        // Call find() method and display meaning
        String meaning = find(inputWord);
        System.out.println("Meaning: " + meaning);

        sc.close();
    }
}

//Write a program that prompts the user to enter integer value and return the factorial of integer. 
// User may enter a negative number, so write your own exception class NegativeNumberException, and throw exception 
// when user enter negative number.

// Test your code on following inputs:

// - Enter Integer: 5       // Answer : Factorial is 120
// - Enter Integer: -3      //Exception: NegativeNumberException
import java.util.Scanner;

// Custom Exception Class
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class FactorialProgram {

    // Method to calculate factorial
    public static long factorial(int n) throws NegativeNumberException {
        if (n < 0) {
            throw new NegativeNumberException("Exception: NegativeNumberException");
        }

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Integer: ");
        int num = sc.nextInt();

        try {
            long result = factorial(num);
            System.out.println("Factorial is " + result);
        } catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
//Here's the question extracted from the image:

// Write a program to check the eligibility of an applicant for a driving license. 
// The program should let the user to input his/her age and throws an invalidAgeException
//  if age is below 18 (prints "Access denied"). If age is 18 or older, prints "Access granted".
import java.util.Scanner;

// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class DrivingLicenseEligibility {

    // Method to check eligibility
    public static void checkEligibility(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Access denied");
        } else {
            System.out.println("Access granted");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            checkEligibility(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
//
//"Write a program that prompts the user to enter integer value and calculate its cube,
//  a user may enter a zero number , so write your own exception class ZeroNumberException, 
// and throw exception when user enter zero number."

// Test inputs:
// - Enter Integer: 5    //Result: 125
// - Enter Integer: 0    //Exception: ZeroNumberException

import java.util.Scanner;

// Custom Exception Class
class ZeroNumberException extends Exception {
    public ZeroNumberException(String message) {
        super(message);
    }
}

public class CubeCalculator {

    // Method to calculate cube
    public static int calculateCube(int num) throws ZeroNumberException {
        if (num == 0) {
            throw new ZeroNumberException("Exception: ZeroNumberException");
        }
        return num * num * num;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Integer: ");
        int number = sc.nextInt();

        try {
            int result = calculateCube(number);
            System.out.println("Result: " + result);
        } catch (ZeroNumberException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
//
// Implement the Shape hierarchy as explained in the following: Each TwoDimensionalShape 
// should contain method getArea to calculate the area of the two-dimensional shape. Each ThreeDimensionalShape 
// should have methods getArea and getVolume to calculate the surface area and volume, respectively, of the three-dimensional shape.
//  TwoDimensionalShape has one child class named as Circle and ThreeDimensionalShape has a child with the name of Cylinder. 
//  Write a Driver that uses an array of Shape references to objects of each concrete class in the hierarchy. 
//  The program should print a text description of the object to which each array element refers.
//   Also, in the loop that processes all the shapes in the array, determine whether each shape is a TwoDimensionalShape or a 
//   ThreeDimensionalShape. If a shape is a TwoDimensionalShape, display its area.
//  If a shape is a ThreeDimensionalShape, display its area and volume."

// Base class Shape (Abstract)
abstract class Shape {
    public abstract String getName();
}

// TwoDimensionalShape (Abstract)
abstract class TwoDimensionalShape extends Shape {
    public abstract double getArea();
}

// ThreeDimensionalShape (Abstract)
abstract class ThreeDimensionalShape extends Shape {
    public abstract double getArea();
    public abstract double getVolume();
}

// Concrete class Circle (child of TwoDimensionalShape)
class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return String.format("Shape: %s (Radius = %.2f)", getName(), radius);
    }
}

// Concrete class Cylinder (child of ThreeDimensionalShape)
class Cylinder extends ThreeDimensionalShape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getArea() {
        // Surface Area = 2πr(h + r)
        return 2 * Math.PI * radius * (height + radius);
    }

    @Override
    public double getVolume() {
        // Volume = πr²h
        return Math.PI * radius * radius * height;
    }

    @Override
    public String getName() {
        return "Cylinder";
    }

    @Override
    public String toString() {
        return String.format("Shape: %s (Radius = %.2f, Height = %.2f)", getName(), radius, height);
    }
}

// Driver Class
public class ShapeHierarchyTest {
    public static void main(String[] args) {

        // Array of Shape references
        Shape[] shapes = new Shape[2];

        // Storing objects of child classes
        shapes[0] = new Circle(5.0);
        shapes[1] = new Cylinder(3.0, 7.0);

        // Processing all shapes
        for (Shape s : shapes) {
            System.out.println("--------------------------------");
            System.out.println(s.toString());

            if (s instanceof TwoDimensionalShape) {
                TwoDimensionalShape twoD = (TwoDimensionalShape) s;
                System.out.printf("Type: Two-Dimensional Shape%n");
                System.out.printf("Area: %.2f%n", twoD.getArea());
            } 
            else if (s instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape threeD = (ThreeDimensionalShape) s;
                System.out.printf("Type: Three-Dimensional Shape%n");
                System.out.printf("Surface Area: %.2f%n", threeD.getArea());
                System.out.printf("Volume: %.2f%n", threeD.getVolume());
            }
        }
    }
}
// Write a program to store Integers. Your program must ask for number of Integers from users and store them in an array. Display the greatest and smallest Integer (i.e., based on its respective integer value) from the array.

// In java, array can be created and accessed in the following way:

// int arr = new int[size]; // array creation

// arr[index] = any_int_value; // value assignment

import java.util.Scanner;

public class SmallestGreatestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for number of integers
        System.out.print("Enter number of integers: ");
        int size = sc.nextInt();

        // Create an integer array
        int[] arr = new int[size];

        // Input integers from user
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Initialize smallest and greatest with first element
        int smallest = arr[0];
        int greatest = arr[0];

        // Find smallest and greatest
        for (int i = 1; i < size; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
            if (arr[i] > greatest) {
                greatest = arr[i];
            }
        }

        // Display results
        System.out.println("Smallest Integer: " + smallest);
        System.out.println("Greatest Integer: " + greatest);

        sc.close();
    }
}
//
// "Imagine a publishing company that markets both book and audiocassette versions of its works.
//  Create a class Publication that stores the title (a string) and price (type float) of a publication. 
//  From this class derive two classes: Book which adds a page count (type int), and Tape which adds a playing time in minutes (type float).
//   Each of these three classes should have a getdata() function to get its data from the user at the keyboard, and a putdata()
//    function to display its data.
// Write Driver class to create an array of Publication which will save the objects of Book and Tape. Write a loop, get and check the instance type 
// and print their information, polymorphiclly.

import java.util.Scanner;

// Base class
class Publication {
    protected String title;
    protected float price;

    public void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title: ");
        title = sc.nextLine();
        System.out.print("Enter price: ");
        price = sc.nextFloat();
    }

    public void putdata() {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }
}

// Derived class: Book
class Book extends Publication {
    private int pageCount;

    @Override
    public void getdata() {
        super.getdata();  // call Publication's getdata
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of pages: ");
        pageCount = sc.nextInt();
    }

    @Override
    public void putdata() {
        super.putdata();  // call Publication's putdata
        System.out.println("Pages: " + pageCount);
    }
}

// Derived class: Tape
class Tape extends Publication {
    private float playingTime;

    @Override
    public void getdata() {
        super.getdata();  // call Publication's getdata
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter playing time (in minutes): ");
        playingTime = sc.nextFloat();
    }

    @Override
    public void putdata() {
        super.putdata();  // call Publication's putdata
        System.out.println("Playing Time (minutes): " + playingTime);
    }
}

// Driver class
public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Publication[] publications = new Publication[3]; // array for Book & Tape objects

        for (int i = 0; i < publications.length; i++) {
            System.out.println("\nEnter 1 for Book or 2 for Tape:");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                publications[i] = new Book();
            } else if (choice == 2) {
                publications[i] = new Tape();
            } else {
                System.out.println("Invalid choice! Defaulting to Book.");
                publications[i] = new Book();
            }

            publications[i].getdata();
        }

        System.out.println("\n===== Publication Details =====");
        for (Publication pub : publications) {
            if (pub instanceof Book) {
                System.out.println("\nBook Information:");
            } else if (pub instanceof Tape) {
                System.out.println("\nTape Information:");
            }

            pub.putdata();  // polymorphic call
        }
    }
}
