import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

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
                showMenu();
            } else if (n == 0) {
                System.out.println("Bye!!!");
                System.exit(1);
            } else {
                System.out.println("Invalid Input, try again [0,1]");
            }
        }
    }
    private static void showMenu() {
        System.out.println("\n1: View Files\n2: File Operations\n0: Exit\n");
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
        Arrays.stream(new File(PATH2MAIN).listFiles()).sorted().forEach(System.out::println);
        showMenu();
    }
    public static void copyFile(String from, String to) throws IOException {
        Path src = Paths.get(from);
        Path dest = Paths.get(to);
        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
    }
    private static void deleteFile() {
        String fileName = promptUserToInputFileName();
        File file = new File("./main/" + fileName);
        if(file.exists()) {
            if (file.delete()) {
                System.out.println("Success! File " + file.getName() + " Deleted\n\n");
            } else {
                System.out.println("Failed to delete the file:" + file.getName() + "\n\n");
            }
        }else{
            System.out.println("File:" + file.getName() + " does not exists\n\n");
        }
        fileOperations();

    }
    private static String promptUserToInputFileName() {
        System.out.println("Please enter the file name: ");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        if ("".equalsIgnoreCase(fileName.trim())) {
            promptUserToInputFileName();
        }
        return fileName;
    }

    private static void searchFileByName() {
        String fileName = promptUserToInputFileName();
        File files = new File("./main/");
        Optional<String> searchedFileOptional = Arrays.stream(files.listFiles()).filter(file -> file.getName().startsWith(fileName)).map(file -> file.getName()).findFirst();

        if(searchedFileOptional.isPresent()){
            System.out.println("File Found:" + searchedFileOptional.get());
        }else {
            System.out.println("File Not Found!!!!!!");
        }
        showMenu();
    }
    private static void addNewFile() {
        String fileName = promptUserToInputFileName();
        try {
            File file = new File("./main/" + fileName);
            if (file.createNewFile()) {
                System.out.println("Success! File  " + file.getName() + " created\n\n");
            } else {
                System.out.println("File already exists.\n\n");
            }
            fileOperations();
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage() +"\n\n");
            e.printStackTrace();
            fileOperations();
        }
    }

}
