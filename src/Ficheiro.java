import java.util.*;

public class Ficheiro {

    //  TODO pensar melhor como vamos guardar isto dos métodos
    //static Map<String, In > methods;    //  Ficheiro->tostring()
    String className;
    String[] linhas;
    int numeroLinhas = 0;
    //  apenas codesemells relacionados com a classe
    List<CodeSmell> codeSmells;
    boolean toString;
    boolean equals;
    boolean clone;
    boolean construtoVazio;
    boolean constutorParametrizado;
    boolean construtorCopia;

    // a flag de analisar o método está a ser usada
    boolean identifyMethod;
    boolean identifyPrimitives;

    //  chave: nome da variável
    Map<String, Integer> variaveisNaoPrivadas;
    //  chave: Nome do método - temos a info do número de linhas, e code smells
    Map<String, Method> methods;

    Map<String, Integer> usoVariaveisPrimitivas;

    List<String> dependencias;  //  dependências de classes;

    int linhaAtual;

    public Ficheiro(){
        this.codeSmells = new ArrayList<>();
        this.variaveisNaoPrivadas = new HashMap<>();
        this.methods = new HashMap<>();
        this.usoVariaveisPrimitivas = new HashMap<>();
        dependencias = new ArrayList<>();
    }

    public Ficheiro(String className, String[] linhas, int numeroLinhas, List<CodeSmell> codeSmells, boolean toString, boolean equals, boolean clone, boolean construtoVazio, boolean constutorParametrizado, boolean construtorCopia, Map<String, Integer> variaveisNaoPrivadas, Map<String, Method> methods, Map<String, Integer> usoVariaveisPrimitivas, List<String> dependencias) {
        this.className = className;
        this.linhas = linhas;
        this.numeroLinhas = numeroLinhas;
        this.codeSmells = codeSmells;
        this.toString = toString;
        this.equals = equals;
        this.clone = clone;
        this.construtoVazio = construtoVazio;
        this.constutorParametrizado = constutorParametrizado;
        this.construtorCopia = construtorCopia;
        this.variaveisNaoPrivadas = variaveisNaoPrivadas;
        this.methods = methods;
        this.usoVariaveisPrimitivas = usoVariaveisPrimitivas;
        this.dependencias = dependencias;
    }

    public void run(){
        linhaAtual = 0;
        int inicioMetodo;
        int chavetasInicio = 1, int chavetasFim = 0;
        int linhasMetodo = 1;
        for(String line : linhas){
            linhaAtual++;
            if(identifyMethod) {
                inicioMetodo = linhaAtual;
                if(checkChaveta()) {
                    if (chavetasInicio == chavetasFim) {
                        linhasMetodo = chavetasFim - chavetasInicio;

                    }
                }
            }
            else identifyMethod = checkMethod(line);

            if (checkVariaveis()){
                this.
            }

            }
        }

    }

    public boolean checkMethod(String line){
        String pattern = "(public|protected|private|static|\\s)* +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]) (throws)[\\ \\t]*[A-Za-z]* \\{";
        RegularExpression.findAll(line, pattern);
    }

    public boolean checkVariaveis(){

    }

    public boolean checkChaveta(String line) {

    }

    @Override
    public String toString() {
        return "Ficheiro{" +
                "className='" + className + '\'' +
                ", linhas=" + Arrays.toString(linhas) +
                ", numeroLinhas=" + numeroLinhas +
                ", codeSmells=" + codeSmells +
                ", toString=" + toString +
                ", equals=" + equals +
                ", clone=" + clone +
                ", construtoVazio=" + construtoVazio +
                ", constutorParametrizado=" + constutorParametrizado +
                ", construtorCopia=" + construtorCopia +
                ", variaveisNaoPrivadas=" + variaveisNaoPrivadas +
                ", methods=" + methods +
                ", usoVariaveisPrimitivas=" + usoVariaveisPrimitivas +
                ", dependencias=" + dependencias +
                '}';
    }
}
