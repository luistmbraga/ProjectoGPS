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
            }else{
                readFolder(file.getAbsolutePath());
            }
        }
    }


    public void printListaCodeSmells(String filename)throws Exception{
        FileWriter fw = new FileWriter(GProject.output+filename+".html");

        PrettyPrint.headerHTML(fw, "Normas encontradas no ficheiro: " + filename + ".java");

        //  TODO aqui coloquem o link para o vosso ficheiro, lembrem-se o vosso ficheiro tem que ser "nomeDoFicheiroAnalisado + CodeSmell + html, p.e GProjectLongMethod.html
        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>\n");
        fw.write("<li><a href=\"" + filename + "TiposPrimitivos.html\">Tipos Primitivos</a></li>\n");

        PrettyPrint.footerHTML(fw);
        fw.close();
    }

    public void printFicheiros()throws Exception {
        FileWriter fw = new FileWriter(GProject.output+"index.html");
        PrettyPrint.headerHTML(fw, "Ficheiros analisados: ");
        for (Map.Entry<String,Ficheiro> entry : ficheiros.entrySet()) {
            String newFileName = entry.getKey().split("\\.")[0];
            fw.write("<li><a href=\"" + newFileName + ".html\">" + entry.getKey() + "</a></li>\n");

            printListaCodeSmells(newFileName);  //  índice de cada ficheiro

            //  a seguir vamso gerar os respetivos ficheiros de cada codeSmell

            Ficheiro ficheiro = entry.getValue();

            PrettyPrint.LongMethod(ficheiro);
            PrettyPrint.tiposPrimitivos(ficheiro);
        }
        PrettyPrint.footerHTML(fw);
        fw.close();

    }



    public static void main(String[] args) throws Exception {
        String filename = "src/";
        GProject gProject = new GProject();
        gProject.readFolder(filename);
        gProject.printFicheiros();
    }


}
