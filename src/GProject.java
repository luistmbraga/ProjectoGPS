import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class GProject {
    //  TODO pensar melhor como vamos guardar isto dos métodos
    static Map<String, Integer> methods;    //  Ficheiro->tostring()
    static Map<String, Integer> classes;
    Map<String, Ficheiro> ficheiros;

    public GProject(){
        this.methods = new HashMap<>();
        this.classes = new HashMap<>();
        this.ficheiros = new HashMap<>();
    }

    public static String[] readLines(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename))).split("\r\n|\r|\n");
    }

    public void readFolder(String dir) throws IOException {
        String[] filenames = new File(dir).list();
        for(String filename : filenames) {
            File f = new File(filename);
            if(f.isFile()){
                Ficheiro ficheiro = new Ficheiro();
                ficheiro.linhas = readLines(filename);
                this.ficheiros.put(filename, ficheiro);
            }else{
                readFolder(filename);
            }
        }
    }

    public static void main(String[] args) {

    }


}
