
import java.util.*;


public class Person {
    public String name;
    public String address;
    public String phoneNumber;
    public String postNumber;
    public String Email;
    public String homephoneNumber;


    public Person(){}
    public Person(String name, String address, String phoneNumber, String postNumber, String email, String homephoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postNumber = postNumber;
        Email = email;
        this.homephoneNumber = homephoneNumber;
    }



    @Override
    public String toString() {
        return  "name='" + name + '\'' + ", address='" + address + '\'' + "," +
                " phoneNumber='" + phoneNumber + '\'' + ", postNumber='" + postNumber + '\'' + ", Email='" + Email + '\'' + "," +
                " homephoneNumber='" + homephoneNumber ;
    }


}
