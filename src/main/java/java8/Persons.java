package java8;

import org.junit.Test;

import java.io.Serializable;

public class Persons extends Animals implements Serializable{

	@Test
	public void test() {
		Persons persons = new Persons();
	}

    private int age;
    public Persons() {
	    System.out.println("person");
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

}
