import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GProject {

    //  Nome da classe e respetiva linha de código
    static Map<String, Integer> classes;
    Map<String, Ficheiro> ficheiros;
    static String dir = new File("src/Ficheiro.java").getAbsolutePath();


    public GProject(){
        //this.methods = new HashMap<>();
        this.classes = new HashMap<>();
        this.ficheiros = new HashMap<>();
    }

    public static String[] readLines(String filename) throws IOException {

        return new String(Files.readAllBytes(Paths.get(filename))).split("\r\n|\r|\n");

    }

    public void readFolder(String dir) throws IOException {
        File[] filenames = new File(dir).listFiles(); // .list();
        System.out.println(Arrays.toString(filenames));

        for(File file : filenames) {
            if(file.isFile()){
                Ficheiro ficheiro = new Ficheiro();
                ficheiro.linhas = readLines(file.getAbsolutePath());
                ficheiro.numeroLinhas = ficheiro.linhas.length;
                this.ficheiros.put(file.getName(), ficheiro);
        }else{
                readFolder(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) throws IOException{
        GProject gp = new GProject();
        System.out.println(dir);
        //gp.readFolder(dir);
        Ficheiro ficheiro = new Ficheiro();
        ficheiro.linhas = readLines(new File("src/Ficheiro.java").getAbsolutePath());
        System.out.println(ficheiro.linhas.length);
        ficheiro.numeroLinhas = ficheiro.linhas.length;
        ficheiro.run();
        //this.ficheiros.put(file.getName(), ficheiro);
        /*
        for(Ficheiro file : gp.ficheiros.values()){
            file.run();
        }*/
        return;
    }


}
