package Medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path == null || path.equals("") == true)
            return "";
        
        String[] eles = path.split("/");

        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < eles.length; i ++) {
            if(eles[i].equals(""))
                continue;
                
            if(eles[i].equals(".") == true) {
                
            } else if(eles[i].equals("..") == true) {
                if(stack.isEmpty() != true)
                    stack.pop();
            } else {
                stack.push(eles[i]);
            }
        }
        
        String result = "";
        int i = 0;
        while(stack.isEmpty() == false) {
            String folder_name = stack.pop();
            if(i == 0)
                result = folder_name;
            else
                result = folder_name + "/" +result;
            i ++;
        }
        
        result = "/" + result;
        return result;
    }
}