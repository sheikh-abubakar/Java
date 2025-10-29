//Question:

// Assuming that you have a container of type HashMap h, 
// containing the different objects of Person and Teacher type on the basis of key as integer.
// Write a code to retrieve all objects from HashMap with the help of Iterator and show the 
// attributes of Person/Teacher by calling its Show() method.
import java.util.*;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void Show() {
        System.out.println("Person Name: " + name + ", Age: " + age);
    }
}

class Teacher {
    String name;
    int age;
    String subject;

    Teacher(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    void Show() {
        System.out.println("Teacher Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }
}

public class HashMapExample {
    public static void main(String[] args) {

        // HashMap that can hold any type of object
        HashMap<Integer, Object> h = new HashMap<>();

        // Add Person and Teacher objects
        h.put(1, new Person("Ali", 25));
        h.put(2, new Teacher("Sara", 30, "Mathematics"));
        h.put(3, new Teacher("Hassan", 40, "Physics"));
        h.put(4, new Person("Ayesha", 22));

        // Use Iterator to retrieve all objects
        //An Iterator is an object that allows you to move through all items one by one
        //  — like a pointer that visits each element in order.
        Iterator<Integer> it = h.keySet().iterator();

        while (it.hasNext()) {
            int key = it.next();//get next key
            Object obj = h.get(key);//get obj

            // Check actual object type before calling Show()
            if (obj instanceof Person) {
                ((Person) obj).Show();
            } else if (obj instanceof Teacher) {
                ((Teacher) obj).Show();
            }
        }
    }
}

//
| Aspect           | **Error**                                                                                      | **Exception**                                                                                       |
| ---------------- | ---------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| **Meaning**      | Serious problems that occur during program execution and **cannot be handled** by the program. | Problems that occur due to **bad code or invalid input**, and **can be handled** using `try–catch`. |
| **Nature**       | Usually caused by **JVM** or **system-level** issues.                                          | Usually caused by **program logic** or **user input**.                                              |
| **Recoverable?** | ❌ No — program should stop.                                                                    | ✅ Yes — can be handled and program can continue.                                                    |
| **Examples**     | `OutOfMemoryError`, `StackOverflowError`                                                       | `ArithmeticException`, `IOException`, `NullPointerException`                                        |

| Type                     | Description                                                                                        | Examples                                                                        |
| ------------------------ | -------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------- |
| **Checked Exceptions**   | Checked **at compile-time**. The compiler forces you to handle them using `try–catch` or `throws`. | `IOException`, `SQLException`, `FileNotFoundException`                          |
| **Unchecked Exceptions** | Checked **at runtime only**. The compiler does **not** force you to handle them.                   | `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException` |


// Suppose you have a file test.txt in location D:/files/.
// Check whether the file exists on this location or not.
// Display read/write permission, creation and "last modified" time.

import java.io.File;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Date;

public class FileInfo {
    public static void main(String[] args) {
        try {
            File f = new File("D:/files/test.txt");

            if (f.exists()) {
                System.out.println("File exists: " + f.getName());
                System.out.println("Readable: " + f.canRead());
                System.out.println("Writable: " + f.canWrite());
                System.out.println("Last Modified: " + new Date(f.lastModified()));

                // To get creation time using NIO
                Path path = f.toPath();
                BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.println("Creation Time: " + attr.creationTime());
            } else {
                System.out.println("File does NOT exist at location: " + f.getAbsolutePath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//Question #3 (Part A)

// Write down a code to create a copy of an existing file.
// (Include all required error and exception handling.)

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {

        // Source and destination file paths
        String sourcePath = "D:/files/source.txt";
        String destinationPath = "D:/files/copy_source.txt";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            // Open the source file for reading
            File sourceFile = new File(sourcePath);

            // Check if source file exists
            if (!sourceFile.exists()) {
                System.out.println("Error: Source file does not exist!");
                return;
            }

            // Create input and output streams
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationPath);

            // Buffer for reading/writing data
            byte[] buffer = new byte[1024];
            int data;

            // Read from source and write to destination
            while ((data = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, data);
            }

            System.out.println("File copied successfully from " + sourcePath + " to " + destinationPath);

        } catch (FileNotFoundException e) {
            System.out.println("Exception: File not found! " + e.getMessage());

        } catch (IOException e) {
            System.out.println("Exception: Error while copying file! " + e.getMessage());

        } finally {
            // Always close the streams
            try {
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                System.out.println("Exception while closing file streams: " + e.getMessage());
            }
        }
    }
}
