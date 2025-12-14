package AirlineJDBC;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;
public class AirlineRunner {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner me1 = new Scanner(System.in);
        String str ;
        int  choice;
        do {
            System.out.println(" Enter Your Choice :");
            System.out.println(" Enter 1 for Flight :");
            System.out.println(" Enter 2 for Create flight :");
            System.out.println(" Enter 3 for Finding flight :");
            System.out.println(" Enter 4 for Changing Source city :");
            System.out.println(" Enter 5 for Finding Cheap flight :");
            System.out.println(" Enter 6 for Finding Short Duration flight :");
            System.out.println(" Enter 7 for Updating Fare of a flight  :");
            System.out.println(" Enter 8 for Printing All flight's data :");
            System.out.println(" Enter 9 for Exit :");
            choice = me1.nextInt();

            switch (choice) {
                case 1 -> AirlineController.flight();
                case 2 -> AirlineController.create_Flight();
                case 3-> AirlineController.find_Flight();
                case 4-> AirlineController.change_Source();
                case 5-> AirlineController.cheap_Flight();
                case 6-> AirlineController.short_Duration();
                case 7-> AirlineController.update_Fare();
                case 8-> AirlineController.print_All();

                case 9->{
                    System.out.println(" Table is Terminated.");
                    return;
                }
                default -> System.out.println("Invalid choice - Enter correct choice");
            }
            System.out.println("Do you want to Continue ? ? ?");
            str = me1.next();
        } while (Objects.equals(str, "y") || Objects.equals(str, "Y"));
    }
}