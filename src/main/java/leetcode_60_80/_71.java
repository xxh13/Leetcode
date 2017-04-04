import java.util.Stack;

public class _71{

    public static void main(String[] args) {
        String path = "/a/b/../../c/";
        _71 demo = new _71();
        System.out.println(demo.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        StringBuilder subPath = new StringBuilder();
        Stack<String> stack = new Stack<>();
        char[] pathArray = path.toCharArray();

        for (int i = 0; i < pathArray.length; i++) {
            if (pathArray[i] != '/') {
                subPath.append(pathArray[i]);
            } else {
                String tempPath = subPath.toString();
                if (tempPath.equals("")) {
                    continue;
                } else if (tempPath.equals(".")) {
                    continue;
                } else if (tempPath.equals("..")) {
                    if (!stack.empty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(tempPath);
                }
                subPath = new StringBuilder();
            }
            if (pathArray[i] != '/' && i == pathArray.length - 1 && subPath.length() != 0) {
                stack.push(subPath.toString());
            }
        }

        if (stack.empty()) {
            return "/";
        }

        while (!stack.empty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, '/');
        }

        return sb.toString();
    }
}