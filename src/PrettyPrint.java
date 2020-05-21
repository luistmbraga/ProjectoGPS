import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class PrettyPrint {

    public static String importCss = "<head><link rel=\"stylesheet\" href=\"..\\styleSheets\\style.css\"></head>";

    public static void LongMethod(Ficheiro f)throws Exception{
        String newFileName = f.fileName.split("\\.")[0];
        FileWriter fw = new FileWriter(GProject.output +newFileName+"LongMethod.html");
        fw.write("<html>" +importCss);
        fw.write("<body>" +
                "   <h2>Long method</h2>");
        fw.write(printTableLongMethod(f.methods,"Método","Linhas"));
        fw.write("    </body>" +
                "</html>");
        fw.close();
    }

    private static String printTableLongMethod(Map<String,Method> map,String col1,String col2) {
        String result = "<table>\n" +
                "  <tr>\n" +
                "    <th>" + col1 + "</th>\n" +
                "    <th>" + col2 + "</th>\n" +
                "  </tr>\n";
        System.out.println(map);
        for (Map.Entry<String, Method> entry : map.entrySet()) {
            for (CodeSmell codeSmell : entry.getValue().codeSmells) {
                if (codeSmell.codeSmell.equals(CodeSmellType.LongMethod)) {
                    result += "  <tr>\n" +
                            "    <td>" + entry.getKey() + "</td>\n" +
                            "    <td>" + codeSmell.linhas + "</td>\n" +
                            "  </tr>\n";
                    System.out.println("Entrei");
                }
            }
        }
        result += "</table>";
        return result;
    }

}
