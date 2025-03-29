/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/

package librarySystem;

public class Member {

    private String Id;
    private String firstName;
    private String LastName;
    private int age;
    
    public Member(String id, String firstName, String lastName, int age) {
        Id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.age = age;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char[] getMembers() {
        return ("Member [Id=" + Id + ", firstName=" + firstName + ", LastName=" + LastName + ", age=" + age + "]").toCharArray();
    }
}
