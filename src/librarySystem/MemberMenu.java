package librarySystem;
import java.util.List;


public class MemberMenu {
    final static String DOTTED_DIVIDER = "------------------------------------------------------------------------------------------------------------------------------------------";

    public static void displayAllMembers(List<Member> memberList) {

        for (Member member : memberList) {

            String memberId = TableUtil.formatTwoDigitColumnString(member.getId(), 2);
            String memberFirstName = TableUtil.formatTable(member.getFirstName(), 20);
            String memberLastName = TableUtil.formatTable(member.getLastName(), 26);
            String memberAge = TableUtil.formatTwoDigitColumn(member.getAge(),2);
            

            System.out.println(String.format(
                    "| %s | %s | %s | %s | %s | %s | %s |",
                    memberId,
                    memberFirstName,
                    memberLastName,
                    memberAge));
        }
        System.out.println(DOTTED_DIVIDER);
    }

    }

    /*public static void addNewMember(List<Member> memberList) {
        // This method will allow the user to add a new member.
        // Implementation will be added later.
    }

    public static void checkOutmember() {
        // This method will allow the user to check out a member.
        // Implementation will be added later.
    }

    public static void checkInmember() {
        // This method will allow the user to check in a member.
        // Implementation will be added later.
    }

    public static void findMember() {
        // This method will allow the user to find a member.
        // Implementation will be added later.
    }

    public static void findmember() {
        // This method will allow the user to find a member.
        // Implementation will be added later.
    }
*/