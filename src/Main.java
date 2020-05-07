import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        // String to be scanned to find the pattern.
        String line = new String(Files.readAllBytes(Paths.get("/Users/josepereira/Desktop/teste/src/Main.java")));

        //String pattern = "(.*)(\\d+)(.*)";
        String pattern = "main(.|\n|\t)*";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        while (m.find( )) {
            String res = m.group();
            String[] arr = res.split("\r\n|\r|\n");

            System.out.println(arr.length);
        }

    }

    public static void findMethods(String[] ficheiro){
        String pattern = "(public|protected|private|static|\\s)* +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]) (throws)[\\ \\t]*[A-Za-z]* \\{";

        //  [public|private|protected]*[\ \n\t]*[static]*[\ \n\t]*\w
        for(String line : ficheiro){

        }
    }


}
