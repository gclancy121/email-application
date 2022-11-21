import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String altEmail;
    private String companySuffix = "GoogleWaterCompany.com";

    //Constructor to receive the first and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for department, return department
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(10);
        System.out.println("Your password is: " + this.password);

        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for department
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "accounting"; }
        else {return ""; }
    }


    //Generate random password
    private String randomPassword(int length) {
        String passwordSet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    //Set the alt email
    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    //Change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAltEmail() { return altEmail; }
    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
