import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        getContest(
                "Replace All ?'s to Avoid Consecutive Repeating Characters3\n" +
                        "Number of Ways Where Square of Number Is Equal to Product of Two Numbers5\n" +
                        "Minimum Deletion Cost to Avoid Repeating Letters5\n" +
                        "Remove Max Number of Edges to Keep Graph Fully Traversable"
        );
        System.out.println("************************* Top FB Questions ***********************************");
        printCamelCase(
//                "Merge k Sorted Lists",
//                "Product of Array Except Self",
        );
        getReplaced(
                Arrays.asList(
                        "[[1,1,1],[0,1,0],[1,1,1]]",
                        "[[0,0,0],[0,1,0],[0,0,0]]",
                        "[[1,1,0,1,1],[1,1,1,1,1],[1,1,0,1,1],[1,1,0,1,1]]"
                ),
                Arrays.asList("[", "{"),
                Arrays.asList("\"", "'"),
                Arrays.asList("]", "}")
        ).forEach(System.out::println);
    }

    private static void getContest(String input) {
        String[] strings = input.split("\n");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(getCamelCase(i != strings.length - 1 ? strings[i].substring(0, strings[i].length() - 1) : strings[i]));
        }
    }

    private static void printCamelCase(String... input) {
        Arrays.stream(input).map(Tools::getCamelCase).forEach(System.out::println);
    }

    private static String getCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (sb.length() == 0 && Character.isDigit(c)) {
                    continue;
                } else if (capitalize) {
                    sb.append(Character.toUpperCase(c));
                    capitalize = false;
                } else {
                    sb.append(c);
                }
            } else {
                capitalize = true;
            }
        }
        return sb.toString();
    }

    private static List<String> getReplaced(List<String> input, List<String>... replaces) {
        return input.parallelStream().map(val -> getReplaced(val, replaces)).collect(Collectors.toList());
    }

    private static String getReplaced(String input) {
        return input
                .replace("[", "{")
                .replace("]", "}")
                .replace("\"", "'");
    }

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }
}
