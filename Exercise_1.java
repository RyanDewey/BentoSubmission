
import java.io.File;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Comparator;
import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

public class Exercise_1 {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Input is required to run this code. Try entering a valid directory path.");
            return;
        }
        printFilesBySize(args[0]);
    }


    /*  Description: Prints path, name, and size of all found files and sorts by the file's size
     *  Parameters: String directoryPath - starting directory of the file search
     *  Return: void
     */
    public static void printFilesBySize(String directoryPath) {

        // Create a File object from directoryPath parameter
        File folder = new File(directoryPath);
        // Check if folder is a folder, return with a warning if not.
        if(!folder.isDirectory()){
            System.out.println("Enter a valid directory path to see a result.");
            return;
        }

        // Create an ArrayList to store the result of directoryToArrayList
        ArrayList<Pair<String, Long>> filesBySize = directoryToArrayList(folder, new ArrayList<>());

        // Create a Comparator object to override the Collections.sort Comparator.
        // Referenced: https://stackoverflow.com/questions/29920027/how-can-i-sort-a-list-of-pairstring-integer
        Comparator<Pair<String, Long>> c = reverseOrder(comparing(Pair::getValue));
        // Sort the filesBySize list by file size ascending
        filesBySize.sort(c);

        // Print the sorted file list
        for(int i=0; i<filesBySize.size(); i++) {
            System.out.println(filesBySize.get(i).getKey() + " - " + filesBySize.get(i).getValue() + " bytes");
        }
    }

    /*  Description: Recursive function that searches for and stores files directories
     *  Parameters: File folder - either a directory that will prompt another recursion or a file to be stored
     *              ArrayList listOfFiles - a store of all the files found in the directories
     *  Return: void
     */
    public static ArrayList<Pair<String, Long>> directoryToArrayList(File folder, ArrayList<Pair<String, Long>> listOfFiles){
        // Loop through the directories and add found files to listOfFiles
        for(File file : folder.listFiles()) {
            // If directory, recurse into the folder structure
            if (file.isDirectory()) {
                directoryToArrayList(file, listOfFiles);
            } else {
                listOfFiles.add(new Pair(file.getAbsolutePath() + " - " + file.getName(), file.length()));
            }
        }
        return listOfFiles;
    }

}
