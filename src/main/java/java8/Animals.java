package java8;

import java.io.Serializable;

public class Animals implements Serializable{

    private String name;
    public Animals() {  }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    private void readObjectNoData() {
        this.name = "zhangsan";
    }
}
