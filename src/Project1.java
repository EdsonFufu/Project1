import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {

    }
    private static void getMenu() {
        System.out.println("1: View Files\n2: File Operations\n0: Exit");
        Scanner input = new Scanner(System.in);
        while (true) {
            Integer in = input.nextInt();
            switch (in) {
                case 1:
                    retrieve();
                    break;
                case 2:
                    fileOperations();
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    System.out.println("Invalid Input, Try [1,2] or 0 to exit");
            }
        }
    }

    private static void fileOperations() {
    }

    private static void retrieve() {
    }
}
