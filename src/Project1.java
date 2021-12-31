import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 {
    static String PATH2MAIN = "main";
    static String PATH2DOTIDEA = ".idea";

    public static void main(String[] args) throws IOException {
        File directory = new File(PATH2MAIN);
        //Check if main directory exists and create if not
        if (! directory.exists()){
            directory.mkdirs();
        }
        //check if directory id empty and copy files
        if(directory.list().length < 1){
            System.out.println("Copying Files .....................");
            copyFile(PATH2DOTIDEA,PATH2MAIN);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("=================== Welcome to the  Project1 ========================");
        System.out.println("!!!!!!!!! To continue type 1 to start using application or 0 to exit !!!!!!!!!");
        while (true) {
            int n = input.nextInt();
            if (n == 1) {
                getMenu();
            } else if (n == 0) {
                System.out.println("Bye!!!");
                System.exit(1);
            } else {
                System.out.println("Invalid Input, try again [0,1]");
            }
        }
    }
    private static void getMenu() {
        System.out.println("1: View Files\n2: File Operations\n0: Exit");
        Scanner input = new Scanner(System.in);
        while (true) {
            Integer in = input.nextInt();
            switch (in) {
                case 1:
                    viewFiles();
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

    private static void viewFiles() {
        Arrays.stream(new File(PATH2MAIN).listFiles()).forEach(System.out::println);
        getMenu();
    }
    public static void copyFile(String from, String to) throws IOException {
        Path src = Paths.get(from);
        Path dest = Paths.get(to);
        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
    }

}
