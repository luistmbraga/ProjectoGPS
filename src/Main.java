import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        // String to be scanned to find the pattern.
        String line = new String(Files.readAllBytes(Paths.get("/Users/josepereira/Desktop/teste/src/Main.java")));

        //String pattern = "(.*)(\\d+)(.*)";


        // Create a Pattern object


        // Now create matcher object.
        Matcher m = r.matcher(line);
        while (m.find( )) {
            String res = m.group();
            String[] arr = res.split("\r\n|\r|\n");

            System.out.println(arr.length);
        }
        */
        /*String pattern = "";
        System.out.println(RegularExpression.findAll("{}{£43}{", pattern).toString());*/

        String regex = "(public|protected|private|static)(\\ |\t)+[A-Za-z-0-9]+(\\ |\\t)*\\((\\ |\\t)*\\)";
        String regex1 = "(public|protected|private|static)(\\ |\t)+[A-Za-z-0-9]+(\\ |\\t)*\\((\\ |\\t|.*)*\\)";
        System.out.println(RegularExpression.findAll("public Class( int a, float x, User user ){}", regex1));
    }

    public static void findMethods(String[] ficheiro){
        String pattern = "(public|protected|private|static|\\s)* +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]) (throws)[\\ \\t]*[A-Za-z]* \\{";

        //  [public|private|protected]*[\ \n\t]*[static]*[\ \n\t]*\w
        for(String line : ficheiro){

        }
    }


}
