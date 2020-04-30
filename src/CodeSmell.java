import java.util.ArrayList;
import java.util.List;

public class CodeSmell {
    //TODO colocar os restantes!!!
    enum codeSmells {LongMethod, ComentáriosNoMeioDoCodigo};

    List<Integer> linhas;   //  linhas onde ocorre

    public CodeSmell(){
        this.linhas = new ArrayList<>();
    }

    public CodeSmell(List<Integer> linhas) {
        this.linhas = linhas;
    }

    @Override
    public String toString() {
        return "CodeSmell{" +
                "linhas=" + linhas +
                '}';
    }
}
