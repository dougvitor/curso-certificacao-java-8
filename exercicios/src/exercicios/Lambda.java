package exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Person {
	
    private String name;
    private int age;
    
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return name;
	}
	
}

@FunctionalInterface
interface Matcher<T>{
    boolean test(T t);
}

class PersonFilter{

    public List<Person> filter(List<Person> input, 
                               Matcher<Person> matcher){
        List<Person> output = new ArrayList<>();
        for (Person person : input) {
            if(matcher.test(person)){
                output.add(person);
            }
        }    
        return output;
    }
}

@FunctionalInterface
interface Calculator<T>{
    T function(T a, T b);
}

class A {
	
	int a = 0;
	
    public static void main(String[] args) {
    	final int j = 1;
        for(int i = 0; i < 10; i++){
            new Thread(() -> System.out.println(j)).start();
        }
        
        new A().method(1, a -> a > 0); 
    }
    
    private void method(int a, Predicate<Integer> d) {
        if(d.test(a)){ // B
            System.out.println(a);
        }
    }
}

public class Lambda {
	
	public static void main(String[] args) {
		
		PersonFilter pf = new PersonFilter();
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Maria", 18));
		persons.add(new Person("João", 42));
		persons.add(new Person("Pédro", 31));
		persons.add(new Person("Jaqueline", 4));
		persons.add(new Person("Victor", 12));
		
		List<Person> adults = pf.filter(persons, p -> p.getAge() >= 18);
		System.out.println(adults);
		
		
		Calculator<Integer> divide = 
		        (Integer a, Integer b) -> {return (Integer) a / b;};
		        
		System.out.println(divide);
		
	}
	
	

}
