import java.util.ArrayList;
import java.util.List;

public class Method {
    int linhas;
    List<CodeSmell> codeSmells;

    public Method(){
        this.codeSmells = new ArrayList<>();
    }

    public Method(int linhas, List<CodeSmell> codeSmells) {
        this.linhas = linhas;
        this.codeSmells = codeSmells;
    }

    @Override
    public String toString() {
        return "Method{" +
                "linhas=" + linhas +
                ", codeSmells=" + codeSmells +
                '}';
    }
}
