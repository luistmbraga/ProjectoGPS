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

    public GProject(){
        classes = new HashMap<>();
        ficheiros = new HashMap<>();
    }

    public static String[] readLines(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename))).split("\r\n|\r|\n");
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
            files = f.listFiles();
        }
        for(File file : files) {
            if(file.isFile()){
                Ficheiro ficheiro = new Ficheiro(file.getName());
                ficheiro.linhas = readLines(file.getAbsolutePath());
                ficheiro.numeroLinhas = ficheiro.linhas.length;
                ficheiro.run();
                //System.out.println(ficheiro.methods);
                ficheiros.put(file.getName(), ficheiro);
            }else{
                readFolder(file.getAbsolutePath());
            }
        }
    }


    public void printListaCodeSmells(String filename)throws Exception{
        FileWriter fw = new FileWriter(GProject.output+filename+".html");

        PrettyPrint.headerHTML(fw, "Normas encontradas no " + filename + ".java");

        //  TODO aqui coloquem o link para o vosso ficheiro, lembrem-se o vosso ficheiro tem que ser "nomeDoFicheiroAnalisado + CodeSmell + html, p.e GProjectLongMethod.html
        fw.write("<li><a href=\"" + filename + "LongMethod.html\">Long Method</a></li>");
        fw.write("<li><a href=\"" + filename + "TiposPrimitivos.html\">Tipos Primitivos</a></li>");
        fw.write("<li><a href=\"" + filename + "Comentarios.html\">Comentários no interior de métodos</a></li>");
        fw.write("<li><a href=\"" + filename + "Construtores.html\">Ausência de Construtores</a></li>");
        fw.write("<li><a href=\"" + filename + "Excessao.html\">Métodos sem Exceção</a></li>");
        fw.write("<li><a href=\"" + filename + "InputOutput.html\">Métodos sem Input/Output Genérico</a></li>");
        fw.write("<li><a href=\"" + filename + "VariaveisPrivadas.html\">Ausência de Variáveis Privadas</a></li>");
        fw.write("<li><a href=\"" + filename + "VariaveisUmCaracter.html\">Variáveis com um caracter</a></li>");
        fw.write("<li><a href=\"" + filename + "UsoHeranca.html\">Utilização de Herança</a></li>");

        fw.write("<li><a href=\"" + filename + "LargeClass.html\">Classes possívelmente longas</a></li>");
        fw.write("<li><a href=\"" + filename + "NoToStringNoEqualsOrNoClone.html\">toString(), equals() ou clone() não implementados</a></li>");
        fw.write("<li><a href=\"" + filename + "FinalVariables.html\">Uso de variáveis \"final\"</a></li>");

        PrettyPrint.footerHTML(fw);
        fw.close();
    }

    public void printFicheiros()throws Exception {
        FileWriter fw = new FileWriter(GProject.output+"index.html");
        PrettyPrint.headerHTML(fw, "Ficheiros analisados: ");
        for (Map.Entry<String,Ficheiro> entry : ficheiros.entrySet()) {
            String newFileName = entry.getKey().split("\\.")[0];
            fw.write("<li><a href=\"" + newFileName + ".html\">" + entry.getKey() + "</a></li>");

            printListaCodeSmells(newFileName);  //  índice de cada ficheiro

            //  a seguir vamso gerar os respetivos ficheiros de cada codeSmell

            Ficheiro ficheiro = entry.getValue();

            PrettyPrint.LongMethod(ficheiro);
            PrettyPrint.tiposPrimitivos(ficheiro);
            PrettyPrint.comentarios(ficheiro);
            PrettyPrint.construtores(ficheiro);
            PrettyPrint.metodoSemExceccao(ficheiro);
            PrettyPrint.inputOutput(ficheiro);
            PrettyPrint.variaveisPrivadas(ficheiro);
            PrettyPrint.variaveisComUmCaracter(ficheiro);
            PrettyPrint.usoDeHeranca(ficheiro);
        }
        PrettyPrint.footerHTML(fw);
        fw.close();

    }



    public static void main(String[] args) throws Exception {
        System.err.println("A pasta output/ tem que ser criada!!!!");
        String filename = "src/Ficheiro.java";
        GProject gProject = new GProject();
        gProject.readFolder(filename);
        gProject.printFicheiros();
    }


}
