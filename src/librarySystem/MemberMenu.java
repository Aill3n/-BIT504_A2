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
        // Prints the header of the members table
        memberHeader();

        for (Member member : memberList) {
            // Print the members in the correct format with a given lenght
            String memberId = TableUtil.formatTwoDigitColumnString(member.getId(), 2);
            String memberFirstName = TableUtil.formatTable(member.getFirstName(), 20);
            String memberLastName = TableUtil.formatTable(member.getLastName(), 26);
            String memberAgeFormat = TableUtil.formatTwoDigitColumn(member.getAge(), 2);
            String memberAge = TableUtil.formatTable(String.valueOf(memberAgeFormat), 10);

            // Print dividers + the strings
            System.out.println(String.format(
                    "| %s | %s | %s | %s |",
                    memberId,
                    memberFirstName,
                    memberLastName,
                    memberAge));
        }
        System.out.println(DOTTED_DIVIDER);
    }

    public static void addNewMember(List<Member> memberList, Scanner scanner) {

        while (true) {
            // Member ID
            System.out.println("Please enter a member ID, it has to be unique:");
            String id = scanner.nextLine().trim();
            // Validate blank spaces and existing Id
            validateId(id, scanner, memberList);

            // First Name
            System.out.println("Please enter the First Name:");
            String firstName = scanner.nextLine().trim();
            validateBlankField(firstName, scanner);

            // Last Name
            System.out.println("Please enter the Last Name:");
            String lastName = scanner.nextLine().trim();
            validateBlankField(lastName, scanner);

            // Age
            System.out.println("Please enter the age:");
            String age = scanner.nextLine().trim();
            // Validate age is between 0 to 125
            int treatedAge = ageRangeValidation(age, scanner);

            // Create member object with given input
            Member member = new Member(id, firstName, lastName, treatedAge);

            // Add member to the end of the list
            memberList.add(member);

            // Confirm book has been added
            if (memberList.get(memberList.size() - 1).getId().trim().equals(id.trim())) {
                System.out.println("\nThe member has been added successfully!");
                break;
            } else {
                System.out.println("Failed to add the member. Please try again.");
            }
        }
    }

    public static void memberHeader() {
        String id = TableUtil.formatTable(" ID", 4);
        String firstName = TableUtil.formatTable(" First  Name", 22);
        String lastName = TableUtil.formatTable(" Last Name", 28);
        String age = TableUtil.formatTable(" Age", 12);

        List<String> headers = List.of(id, firstName, lastName, age);

        String headerDivider = "|";

        // Print the Members header with the dividers and lines
        System.out.println(DOTTED_DIVIDER);
        for (String header : headers) {
            System.out.print(headerDivider + header);
        }
        System.out.println(headerDivider + "\n" + DOTTED_DIVIDER);
    }

    // Validates the age input
    public static int ageRangeValidation(String age, Scanner scanner) {
        while (true) {
            try {
                int ageInt = Integer.parseInt(age);
                if (ageInt < 0 || ageInt > 125) {
                    System.out.println("Please enter a number between 0 to 125:");
                    age = scanner.nextLine().trim();
                } else {
                    return ageInt;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
                age = scanner.nextLine().trim();
            }
        }
    }

    // Validates age is integer
    public static void ageIntegerValidation(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Age should be a number. Please enter a valid age:");
            scanner.next();
        }
    }

    // Validate blank fields can't be entered
    public static String validateBlankField(String field, Scanner scanner) {
        while (field.isBlank()) {
            System.out.println("Only blank space entered. Please enter a valid input:");
            field = scanner.nextLine();
        }
        return field;
    }

    // Validate id is unique
    public static void isIdUnique(String id, Scanner scanner, List<Member> memberList) {
        while (true) {
            boolean idUnique = true;
            for (Member member : memberList) {
                if (id.equals(member.getId())) {
                    idUnique = false;
                    System.out.println("ID must be unique. Please enter a different member ID:");
                    id = scanner.nextLine();
                    break;
                }
            }
            if (idUnique) {
                return;
            }
        }
    }

    
    public static void validateId(String id, Scanner scanner, List<Member> memberList) {
        while (true) {
            // Validate that id is blank
            if (id.isBlank()) {
                System.out.println("ID cannot be blank. Please enter a valid ID:");
                id = scanner.nextLine();
                continue;
            }

            // Validate that id is unique
            boolean isUnique = true;
            for (Member member : memberList) {
                if (id.equals(member.getId())) {
                    System.out.println("ID must be unique. Please enter a different ID:");
                    id = scanner.nextLine();
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                break;
            }
        }
    }
}