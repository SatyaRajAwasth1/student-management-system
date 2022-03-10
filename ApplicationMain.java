import service.StudentService;

import java.util.Scanner;

public class ApplicationMain {
    static Scanner userInput;

    static void loginScreen() {
        Scanner userInput = new Scanner(System.in);
        //StudentService crtStdObj = new StudentService();
       // ReadDataFile rdfObj = new ReadDataFile();

        System.out.print("Hey, Enter your username: ");
        String userName = userInput.nextLine();
        System.out.print("\nAwesome, "+userName+" Enter your password: ");
        String userPwd = userInput.nextLine();

        if (userName.equals("admin")){
            if (userPwd.equals("root")){
                System.out.println("\n Welcome! "+userName+" to Student Management System");
                System.out.println("\t\t  --------------------\n   ~ Student management System--> SMS ~ "
                        +"\n\t\t  ____________________\n");

                // Main Dashboard --> quit and go to SMS
                System.out.println("\n \t Enter what you wish: ");
                System.out.println("\n 1 > Go to Student Dashboard \t\t 2 > Quit");
                System.out.print("Waiting for your response, please press either 1 or 2 and enter > ");
                int option = userInput.nextInt();
                try {
                    if (option==1){
                        System.out.println("\n\t  --------------------\n ~ Student Management System ~ "+"\n\t\t Main Dashboard"
                                +"\n\t  ____________________");
                        System.out.println("\n \t Select or Go to:");
                        System.out.println(" 1 > CREATE STUDENT \t\t\t\t\t 2 > READ ALL STUDENT \n" +
                                " 3 > READ INDIVIDUAL STUDENT DATA \t\t 4 > UPDATE STUDENT DETAIL" +
                                "\n 5 > DELETE STUDENT RECORD \t\t\t\t 6 > QUIT");
                        System.out.print("\nEnter the number mentioned in which you wish to: ");
                        int smsDashboard = userInput.nextInt();
                        System.out.println();

                        switch (smsDashboard){
                            case 1:
                             createStudent();
                                break;

                            case 2:
                                readAllStudentData();
                                break;

                            case 3:
                              readIndividualStudentData();
                                break;

                            case 4:
                               updateStudentData();
                                break;

                            case 5:
                                deleteStudentData();
                                break;

                            case 6:
                                System.out.println(" Application terminated successfully...");
                                break;

                            default:
                                System.out.println("something wrong happened, can't do task as your input");
                        }


                    }
                    else if (option==2){
//                System.out.println("Are you sure to quit the app Y/N");
//                String quitOption = userInput.next();
//                quitOption = quitOption.toUpperCase();
//                if (quitOption.equals("Y")){
                        System.out.println("Application Halted Successfully");
                    }
                    // else if (quitOption.equals("N")){ ---code snippet}
                    else {
                        System.out.println("your input doesn't match , try again by entering 1 or 2");
                    }

                }

                catch (Exception e){
                    System.out.println(" Error happened "+e);
                }
            }
            else {
                System.out.println(" Sorry the password you entered is wrong for the username "+userName);
            }
        }
        else if (userName != "admin"){
            System.out.println(" Think that the username you entered is wrong");
        }
        else {
            System.out.println(" something went wrong cant get in...");
        }

    }
     public static void createStudent() {
      userInput = new Scanner(System.in);
        try {
            System.out.println("\t  --------------------\n   ~ Create Student--> SMS ~ "
                    +"\n\t  ____________________\n");

            System.out.print(" Enter students \n\n\t Student ID: ");
            int ID = userInput.nextInt();

            System.out.print("\n\t First Name: ");
            String firstName = userInput.nextLine();

            System.out.print("\n\t Last Name: ");
            String lastName = userInput.nextLine();

            System.out.print("\t Address: ");
            String address = userInput.nextLine();


            System.out.print("\t Age: ");
            int age = userInput.nextInt();

            System.out.print("\t Class: ");
            int stdClass = userInput.nextInt();

            String tempData[] = {String.valueOf(ID), firstName, lastName, address, String.valueOf(age), String.valueOf(stdClass)};
            new StudentService().createStudent(tempData);

        }
        catch (Exception e){
            System.out.println(" Error occured either in data entered by you or storing it");
        }
    }

// method to read the file or all student data

     static void readAllStudentData() {
         System.out.println(" the format of reading follows as : [ std ID, First name, Last Name, address, ");
        System.out.println(new StudentService().readAllStudentData().toString());
    }

    // method to read the individual student data by student id
    static void readIndividualStudentData() {
        userInput=new Scanner(System.in);
        System.out.println("\t  --------------------\n   ~ Read individual Student By ID--> SMS ~ "
                +"\n\t  ____________________\n");
        System.out.print("Enter the Student's ID: ");
        Integer studentID =userInput.nextInt();
        System.out.println(new StudentService().readIndividualStudentData(studentID));
    }
    // method to update the data on the text
    static void updateStudentData() {
        userInput = new Scanner(System.in);
        try {
            System.out.println("\t  --------------------\n   ~ Update Student Data--> SMS ~ "
                    +"\n\t  ____________________\n");
            System.out.print(" Enter students \n\n\t Student ID: ");
            int ID = userInput.nextInt();

            System.out.println("\n\t First Name: ");
            String firstName = userInput.nextLine();

            System.out.print("\n\t Last Name: ");
            String lastName = userInput.nextLine();

            System.out.print("\t Address: ");
            String address = userInput.nextLine();


            System.out.print("\t Age: ");
            int age = userInput.nextInt();

            System.out.print("\t Class: ");
            int stdClass = userInput.nextInt();

            String tempData[] = {String.valueOf(ID), firstName, lastName, address, String.valueOf(age), String.valueOf(stdClass)};
            new StudentService().updateStudentData(tempData);

        }catch(Exception e) {

            System.out.println("Cannot update data, it mean there got happening error"+e);
        }

    }
    // delete student data or student-data.txt file
    static void deleteStudentData() {
        new StudentService().deleteStudentData(null);
    }

    public static void main(String[] args) {
        loginScreen();
    }
}
