import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class SimplifyPath {

    public static String simplifyPath(String path) {

        Deque<String> stack = new ArrayDeque<String>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));

        String[] arrs = path.split("/");

        for (String dir : arrs) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }

        String res = "";
        for (String dir : stack)
            res = "/" + dir + res;

        return res.isEmpty() ? "/" : res;

    }


    public static void main(String[] args) {

        String path = "./test/../Mac/User/sthota18//testfolder/";

        System.out.println("Path is: " + simplifyPath(path));
    }
}
