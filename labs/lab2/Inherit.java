class Person{
	public String name;
	public int age;
	public int id;
	
	public Person(String n, int a, int i){
	this.name = n;
	this.age = a;
	this.id = i;
	}
	
void displayInfo()
	{
		System.out.println("name : "+name + "age: "+ age + "id is : "+id);
		
	
	}
	
	public String toString(){
	return "person";
	}
	
}
	
	class Student extends Person{
	public String program;
	public double Cgpa;
	
	
	
	public Student(String n, int a, int id, String prog, double gpa)
	{
		super(n,a,id);
		this.program = prog;
		this.Cgpa = gpa;
	}
	
	
	public void displayInfo()
	{
	System.out.println("name : "+name + "age: "+ age + "id is : "+id + "studying " + program + "having "+Cgpa);
			
	}
	
	public double getCgpa(){
	return Cgpa;
	}
	
	public String toString(){
		return "Student";
	}
	
	}
	
	class Faculty extends Person{
		public String designation;
		public double sal;
		
		public Faculty(String n, int a, int id, String d, double s){
		super(n,a,id);
		this.designation = d;
		this.sal = s;
		}
		
		void displayInfo()
		{
		System.out.println("name : "+name + "age: "+ age + "id is : "+id+"having designanition "+ designation+"and earing "+sal);
		
		}
		public double getSal()
		{
		return sal;
		}
		public String toString()
		{
		return "facaulty";
		}
	}
	
	class Staff extends Person{
		public String dept;
		public String shift;
		
		public Staff (String n, int a, int id, String d, String s){
		super(n,a,id);
		this.dept = d;
		this.shift = s;
		}
		
		
		void displayInfo()
		{
		System.out.println("name : "+name + "age: "+ age + "id is : "+id+"having depatment "+dept+"working in "+shift);
		
		}
		
		public String getShift(){
		return shift;
		}
		public String toString()
		{
			return "staff";
		}
	}
	
	public class Inherit{
	public static void main (String[] args){
	Person[] people = new Person[10];
	
	people[0] = new Student("Ali", 20, 01, "CS", 2.5);
	people[1] = new Faculty("Alina", 21, 02, "prof", 4500.0);
	people[2] = new Staff("Alisha", 22, 03, "IT", "morning");
	people[3] = new Student("zain", 20, 04, "DS", 4.0);
	
	System.out.println("--");
	
	System.out.println(people[0]);
		System.out.println();
	
	double totalgpa = 0.0;
	int StdCount = 0;
	
	double totalSal = 0.0;
	int facCount = 0;
	
	int nightShiftCount = 0;
	
	System.out.println("------------------------");
	
	for(Person p : people){
		
	if(p != null){
	p.displayInfo();
	
		if(p instanceof Student){
			Student s = (Student) p;
			totalgpa += s.getCgpa();
			StdCount++;
		}else if(p instanceof Faculty){
			Faculty f = (Faculty) p;
			totalSal += f.getSal();
			facCount++;
		}else if (p instanceof Staff){
			Staff s = (Staff) p;
			if(s.getShift().equals("Night")){
			nightShiftCount++;
			}
		}
	}
	}
	
	System.out.println("------------------------");
	double avgpa = (StdCount>0)?(totalgpa/StdCount): 0.0;
	System.out.println("num of studennts: " + StdCount);
	System.out.println("averae gpa of studets "+ avgpa);
	System.out.println("faculty count: " + facCount);
	System.out.println("totalSal "+ totalSal);
	System.out.println("n8 shift count "+ nightShiftCount);
	}
	
	
	
}
	
	