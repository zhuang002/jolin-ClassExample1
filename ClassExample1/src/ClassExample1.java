import java.util.ArrayList;

public class ClassExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human jolin=new Human();
		jolin.setName("Jolin");
		jolin.setAge(17);
		jolin.setGender(Gender.Female);
		
		Human zheng=new Human();
		zheng.setName("Huang Zheng");
		zheng.setAge(55);
		zheng.setGender(Gender.Male);
		
		System.out.println("jolin's info:"+jolin);
		System.out.println("zheng's info:"+zheng);
		
		WeekDays today=WeekDays.Sunday;
		System.out.println("Today is "+WeekDays.Monday);
		
		
		jolin.study();
		jolin.listen("music");
		jolin.listen("class");
		jolin.sleep("home");
		
		zheng.study();
		zheng.listen("pop");
		zheng.sleep("hotel");
		
		System.out.println("===============================");
		
		Mammal mammal1=new Mammal();
		Mammal mammal2=new Mammal();
		
		mammal1.setAge(5);
		mammal1.setGender(Gender.Female);
		
		mammal2.setAge(3);
		mammal2.setGender(Gender.Male);
		
		mammal1.move();
		mammal2.move();
		mammal1.makeSound();
		mammal2.makeSound();
		
		jolin.move();
		jolin.makeSound();
		
		
		Cat cat=new Cat();
		System.out.println("Cat has "+cat.noOfLegs()+" legs.");
		cat.makeSound();
		System.out.println(jolin.getName() + " has "+jolin.noOfLegs()+" legs.");
		
		ArrayList<Integer> xs=new ArrayList<>();
		ArrayList<Integer> ys=new ArrayList<>();
		
		//first method to represent a point.
		int point1_x=2;
		int point1_y=3;
		xs.add(point1_x);
		ys.add(point1_y);
		
		int p1_x=xs.get(0);
		int p1_y=ys.get(0);
		
		int point2_x=4;
		int point2_y=5;
		xs.add(point2_x);
		ys.add(point2_y);
		
		int p2_x=xs.get(1);
		int p2_y=ys.get(1);
		
		
		System.out.println("distance is "+calculateDistance(p1_x,p1_y,p2_x,p2_y));
		
		// second method to represent a point
		ArrayList<int[]> points=new ArrayList<>();
		int[] point1=new int[2];
		point1[0]=2;
		point1[1]=3;
		points.add(point1);
		int[] p1=points.get(0);
		
		int[] point2=new int[2];
		point2[0]=4;
		point2[1]=5;
		points.add(point2);
		int[] p2=points.get(0);
		
		System.out.println("distance is "+calculateDistance(p1,point2));
		
		
		
		//third method to represent a point
		Point pt1=new Point(2,3);
		ArrayList<Point> pointList=new ArrayList<>();
		pointList.add(pt1);
		Point pt_1=pointList.get(0);
		System.out.println(pt_1);
		
		Point pt2=new Point(4,5);
		System.out.println("distance is "+pt_1.distanceTo(pt2));
		
		
		

	}

	private static double calculateDistance(int[] p1, int[] p2) {
		// TODO Auto-generated method stub
		double a=p1[0]-p2[0];
		double b=p1[1]-p2[1];
		return Math.sqrt(a*a+b*b);
	}

	private static double calculateDistance(int p1_x, int p1_y, int p2_x, int p2_y) {
		// TODO Auto-generated method stub
		double a=p1_x-p2_x;
		double b=p1_y-p2_y;
		return Math.sqrt(a*a+b*b);
	}

}

class Point {
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public double distanceTo(Point pt) {
		// TODO Auto-generated method stub
		double a=pt.x-this.x;
		double b=pt.y-this.y;
		return Math.sqrt(a*a+b*b);
	}
	
	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	
}

class Mammal {
	int age=0;
	Gender gender=Gender.Male;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void move() {
		System.out.println(this+" is moving.");
	}
	
	public void makeSound() {
		System.out.println(this+" is making sound.");
	}
	
	public int noOfLegs() {
		return 4;
	}
	
}

class Cat extends Mammal {
	@Override
	public void makeSound() {
		System.out.println("Mew");
	}
}

class Human extends Mammal {
	private String name=null;
	
	public String getName() {
		return name;
	}
	public void sleep(String place) {
		// TODO Auto-generated method stub
		System.out.println(this.name + "is sleeping at "+place);
		
	}
	public void listen(String content) {
		// TODO Auto-generated method stub
		System.out.println(this.name + " is listenning to "+content);
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "["+this.name+","+this.age+","+this.gender+"]";
	}
	
	public void study() {
		System.out.println(this.name+" is studying");
	}
	
	@Override
	public void makeSound() {
		System.out.println(this.name+" is talking.");
	}
	
	@Override
	public void move() {
		System.out.println(this.name+ " is walking.");
	}
	
	@Override
	public int noOfLegs() {
		return 2;
	}
	
	
}

enum Gender {
	Male,
	Female
}

enum WeekDays {
	Monday,
	Tuesday,
	Wednesday,
	Thursday,
	Friday,
	Saturday,
	Sunday
}

class Student extends Human {
	int grade=1;
	ArrayList<Course> enrolledCourses=new ArrayList<>();
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public boolean enrole(Course course) {
		if (this.enrolledCourses.size()>=4)
			return false;
		this.enrolledCourses.add(course);
		return true;
	}
}

class Course {
	String id;
	String description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}