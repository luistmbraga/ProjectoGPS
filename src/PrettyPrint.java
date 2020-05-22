import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrettyPrint {

    public static String importCss = "<head><link rel=\"stylesheet\" href=\"..\\styleSheets\\style.css\"></head>";

    //  MÉTODOS GENÉRICOS #############################################################################################
    //  ###############################################################################################################

    /**
     * Converte um Map do tipo <String, Integer> para um tabela HTML
     * @param data dados (Map)
     * @param column1 nome da coluna de 1 da tabela
     * @param column2 nome da coluna de 2 da tabela
     * @returnm retorna a string HTML da tabela
     */
    private static String convertMapStringIntegerToHTMLTable(Map<String, Integer> data, String column1, String column2){
        String result = "<table>" +
                "  <tr>" +
                "    <th>" + column1 + "</th>" +
                "    <th>" + column2 + "</th>" +
                "  </tr>";
        List<Map.Entry<String, Integer>> list = new ArrayList<>(data.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : list) {
            result += "  <tr>" +
                    "    <td>" + entry.getKey() + "</td>" +
                    "    <td>" + entry.getValue() + "</td>" +
                    "  </tr>";
        }
        result += "</table>";
        return result;
    }

    private static String convertListIntegerToHTMLTable(List<Integer> data, String column1){
        String result = "<table>" +
                "  <tr>" +
                "    <th>" + column1 + "</th>" +
                "  </tr>";

        Collections.sort(data);
        for (Integer value : data) {
            result += "  <tr>" +
                    "    <td>" + value + "</td>" +
                    "  </tr>";
        }
        result += "</table>";
        return result;
    }

    /**
     * Gera o ínicio de um ficheiro HTML.
     * @param fw file writer do ficheiro
     * @param title título da página
     * @throws IOException
     */
    public static void headerHTML(FileWriter fw, String title) throws IOException {
        fw.write("<html>" +importCss);
        fw.write("<body>" +
                "   <h2>" + title + "</h2>");
    }

    /**
     * Gera o fim de uma página html
     * @param fw file writer do ficheiro
     * @throws IOException
     */
    public static void footerHTML(FileWriter fw) throws IOException {
        fw.write("    </body>" +
                "</html>");
        fw.close();
    }

    //  MÉTODOS GENÉRICOS #############################################################################################
    //  ###############################################################################################################

    //  LONG METHOD ---------------------------------------------------------------------------------

    public static void LongMethod(Ficheiro ficheiro)throws Exception{
        String newFileName = ficheiro.fileName.split("\\.")[0];
        FileWriter fw = new FileWriter(GProject.output +newFileName+"LongMethod.html");

        headerHTML(fw, "Long Method no " + ficheiro.fileName);

        fw.write(printTableLongMethod(ficheiro.methods,"Método","Linhas"));

        footerHTML(fw);

        fw.close();
    }

    private static String printTableLongMethod(Map<String,Method> map,String col1,String col2) {
        String result = "<table>" +
                "  <tr>" +
                "    <th>" + col1 + "</th>" +
                "    <th>" + col2 + "</th>" +
                "  </tr>";
        for (Map.Entry<String, Method> entry : map.entrySet()) {
            for (CodeSmell codeSmell : entry.getValue().codeSmells) {
                if (codeSmell.codeSmell.equals(CodeSmellType.LongMethod)) {
                    result += "  <tr>" +
                            "    <td>" + entry.getKey() + "</td>" +
                            "    <td>" + codeSmell.linhas + "</td>" +
                            "  </tr>";
                }
            }
        }
        result += "</table>";
        return result;
    }

    // LONG METHOD ---------------------------------------------------------------------------------

    //  TIPOS PRIMITIVOS ---------------------------------------------------------------------------

    public static void tiposPrimitivos(Ficheiro ficheiro) throws IOException {
        String newFileName = ficheiro.fileName.split("\\.")[0];
        FileWriter fw = new FileWriter(GProject.output +newFileName+"TiposPrimitivos.html");
        headerHTML(fw, "Tipos Primitivos no " + ficheiro.fileName);
        if(ficheiro.usoVariaveisPrimitivas.size() != 0)
            fw.write(convertMapStringIntegerToHTMLTable(ficheiro.usoVariaveisPrimitivas,"Nome da variável ou função","Linha"));
        else
            fw.write("Não foram encontrados problemas com esta norma!");
        footerHTML(fw);
        fw.close();
    }

    //  TIPOS PRIMITIVOS ---------------------------------------------------------------------------

    //  COMENTÁROS EM MÉTODOS ----------------------------------------------------------------------

    public static void comentarios(Ficheiro ficheiro) throws IOException {
        String newFileName = ficheiro.fileName.split("\\.")[0];
        FileWriter fw = new FileWriter(GProject.output +newFileName+"Comentarios.html");
        headerHTML(fw, "Comentários no interior de métodos no " + ficheiro.fileName);
        if(ficheiro.linhasDeComentarios.size() != 0)
            fw.write(convertListIntegerToHTMLTable(ficheiro.linhasDeComentarios,"Linha"));
        else
            fw.write("Não foram encontrados problemas com esta norma!");
        footerHTML(fw);
        fw.close();
    }

    //  COMENTÁROS EM MÉTODOS ----------------------------------------------------------------------


    //  CONSTRUTORES -------------------------------------------------------------------------------

    public static void construtores(Ficheiro ficheiro) throws IOException {
        String newFileName = ficheiro.fileName.split("\\.")[0];
        FileWriter fw = new FileWriter(GProject.output +newFileName+"Construtores.html");
        headerHTML(fw, "Ausência de Construtores no " + ficheiro.fileName);

        if(ficheiro.construtoVazio && ficheiro.constutorParametrizado)
            fw.write("Não foram encontrados problemas com esta norma!");
        else {
            fw.write("<ul>");
            if (ficheiro.construtoVazio == false)
                fw.write("<li><p style=\"color: red\";>Falta a definição do Construtor Vazio</p></li>");
            if (ficheiro.constutorParametrizado == false)
                fw.write("<li><p style=\"color: red\";>Falta a definição do Construtor Parametrizado</p></li>");
            fw.write("</ul>");
        }
        footerHTML(fw);
        fw.close();
    }

    //  CONSTRUTORES -------------------------------------------------------------------------------

    //  TODO verifiquem os métodos genéricos acima, já foram definidos métodos que fazem tables HTML a partir de Maps e Lists
}
