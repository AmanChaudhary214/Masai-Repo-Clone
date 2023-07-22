package Ques4;

public class Main {

	public static void main(String[] args) {
		
		EPFOAccount epfo = new EPFOAccount("EPF001", 25000.00);
		
		Employee e1 = new Employee("E001", "Anuj", 45000.00, epfo);
		System.out.println(e1);
	}
}
