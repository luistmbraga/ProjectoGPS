import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GProject {

    //  Nome da classe e respetiva linha de código
    static Map<String, Integer> classes;
    static Map<String, Ficheiro> ficheiros;

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


    public static void main(String[] args) throws Exception {
        String filename = "src/Ficheiro.java";
        String dir = "src/";
        new GProject().readFolder(filename);
    }


}
