import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GProject {

    //  Nome da classe e respetiva linha de código
    static Map<String, Integer> classes;
    static Map<String, Ficheiro> ficheiros;
    static String output = "output/";

    public static String[] readLines(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename))).split("\r\n|\r|\n");
    }

    public GProject(){
        classes = new HashMap<>();
        ficheiros = new HashMap<>();
    }

    // funciona tanto para 1 ficheiro como para 1 diretoria
    public void readFolder(String dir) throws Exception {
        File[] files;
        File f = new File(dir);
        if (f.isFile()) { // caso seja apenas 1 ficheiro
            files = new File[1];
            files[0] = f;
        }
        else { // caso seja uma diretoria
            files = new File(dir).listFiles();
        }
        for(File file : files) {
            if(file.isFile()){
                Ficheiro ficheiro = new Ficheiro(file.getName());
                ficheiro.linhas = readLines(file.getAbsolutePath());
                ficheiro.numeroLinhas = ficheiro.linhas.length;
                ficheiro.run();
                ficheiros.put(file.getName(), ficheiro);
                if(ficheiro.fileName.equals("Ficheiro.java"))
                System.out.println(ficheiro.methods);
            }else{
                readFolder(file.getAbsolutePath());
            }
        }
    }


    public void printListaCodeSmells(String filename)throws Exception{
        FileWriter fw = new FileWriter(GProject.output+filename+".html");
        fw.write("<html>\n" +
                "    <body>\n" +
                "        <ul>");

        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>\n");
        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>\n");
        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>\n");
        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>\n");
        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>\n");
        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>\n");


        fw.write("</ul>\n" +
                "    </body>\n" +
                "</html>");
        fw.close();
    }

    public void printFicheiros()throws Exception {
        FileWriter fw = new FileWriter(GProject.output+"index.html");
        fw.write("<html>\n" +
                "    <body>\n" +
                "        <ul>");
        for (Map.Entry<String,Ficheiro> entry : ficheiros.entrySet()) {
            String newFileName = entry.getKey().split("\\.")[0];
            fw.write("<li><a href=\"" + newFileName + ".html\">" + entry.getKey() + "</a></li>\n");

            printListaCodeSmells(newFileName);
            PrettyPrint.LongMethod(entry.getValue());
        }
        fw.write("</ul>\n" +
                "    </body>\n" +
                "</html>");
        fw.close();

    }



    public static void main(String[] args) throws Exception {
        String filename = "src/";
        GProject gProject = new GProject();
        gProject.readFolder(filename);
        gProject.printFicheiros();
    }


}
