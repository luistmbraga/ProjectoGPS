import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static List<String> findAll(String str, String pattern) {
        List<String> lines = new ArrayList<>();
        Matcher m = Pattern.compile(pattern).matcher(str);
        while (m.find()) {
            lines.add(m.group());
        }
        return lines;
    }
}
