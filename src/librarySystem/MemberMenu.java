/* 
BIT504 A2
Aillen Teixeira 
Student ID: 2021712
*/
package librarySystem;
import java.util.List;
import java.util.Scanner;

public class MemberMenu {
    final static String DOTTED_DIVIDER = "-----------------------------------------------------------------------";

    public static void displayAllMembers(List<Member> memberList) {
        memberHeader();

        for (Member member : memberList) {

            String memberId = TableUtil.formatTwoDigitColumnString(member.getId(), 2);
            String memberFirstName = TableUtil.formatTable(member.getFirstName(), 20);
            String memberLastName = TableUtil.formatTable(member.getLastName(), 26);
            String memberAgeFormat = TableUtil.formatTwoDigitColumn(member.getAge(), 2);
            String memberAge = TableUtil.formatTable(String.valueOf(memberAgeFormat), 10);
            

            System.out.println(String.format(
                    "| %s | %s | %s | %s |",
                    memberId,
                    memberFirstName,
                    memberLastName,
                    memberAge));
        }
        System.out.println(DOTTED_DIVIDER);
    }

    public static void memberHeader() {
        String id =TableUtil.formatTable(" ID", 4);
        String firstName =TableUtil.formatTable(" First  Name", 22);
        String lastName =TableUtil.formatTable(" Last Name", 28);
        String age =TableUtil.formatTable(" Age", 12);

        List<String> headers = List.of(id, firstName, lastName,age);

        String headerDivider = "|";
        System.out.println(DOTTED_DIVIDER);
        for (String header : headers) {
            System.out.print(headerDivider + header);
        }
        System.out.println(headerDivider + "\n" + DOTTED_DIVIDER);
    }

public static void addNewMember(List<Member> memberList, Scanner scanner) {
    
        //TODO: Aillen add validations
        
        System.out.println("ADD A NEW MEMBER MENU. \n");

        System.out.println("Please enter the member ID, it has to be unique:");
        String id = scanner.nextLine();

        System.out.println("Please enter the First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Please enter the Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Please enter the age:");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer for age rating.");
            scanner.next(); // Consume invalid input
        }

        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline after integer input

        Member member = new Member(id, firstName, lastName, age);

        memberList.add(member);
        if (memberList.stream().anyMatch(b -> b.getId().trim().equals(id.trim()))) {
            System.out.println("\nThe member has been added successfully!");
        } else {
            System.out.println("Failed to add the member. Please try again.");
        }
    }
}
/* 
    public static void checkOutmember() {
        // This method will allow the user to check out a member.
        // Implementation will be added later.
    }

    public static void checkInmember() {
        // This method will allow the user to check in a member.
        // Implementation will be added later.
    }

    public static void findmember() {
        // This method will allow the user to find a member.
        // Implementation will be added later.
    }
*/