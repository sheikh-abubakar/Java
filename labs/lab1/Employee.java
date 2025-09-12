class Employee {
    
    private String name;
    private String email;
    private double salary;
    private String companyName;

    
    public Employee(String name, String email, double salary, String companyName) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.companyName = companyName;
    }

   
    public void displayInfo() {
        System.out.println("Employee Information:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Salary: " + salary);
        System.out.println("Company: " + companyName);
    }

   
    public static void main(String[] args) {
        
        String name = "Ali";
        String email = "ali@example.com";
        String salaryStr = "75000";   
        String company = "devsicn";

        
        double salary = Double.parseDouble(salaryStr);

       
        Employee emp = new Employee(name, email, salary, company);

       
        emp.displayInfo();
    }
}
