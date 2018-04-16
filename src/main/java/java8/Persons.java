package java8;

import java.io.Serializable;

public class Persons extends Animals implements Serializable{

    private int age;
    public Persons() {}
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

}
