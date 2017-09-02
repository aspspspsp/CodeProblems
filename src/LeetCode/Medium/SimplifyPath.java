package LeetCode.Medium;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return "/";
        }
        
        //將路徑以"/"的方式進行切割，切出每個文件夾的名稱
        String[] names = path.split("/");
        Stack<String> stack = new Stack<>();
        
        //歷遍所有文件夾的名稱
        for(int i = 0; i < names.length; i ++) {
            //若遇到"."則可以略過(相同文件夾)
            if(names[i].equals(".") == true || names[i].equals("")) {
                continue;
            }
            
            //若遇到".."則可以推出一個文件夾(上一個文件夾)
            if(names[i].equals("..") == true) {
                //需要避免stack為空的情況
                if(stack.isEmpty() == false) {
                    stack.pop();
                }
            //其他情況則可以添加文件夾
            } else {
                stack.push(names[i]);
            }
        }
        
        //若stack為空，可以直接輸出結果
        if(stack.isEmpty() == true) {
            return "/";
        }
        
        //開始進行結果的拼接
        String result = "";
        int i = 0;
        while(stack.isEmpty() == false) {
            String folder_name = stack.pop();
            //首個文件夾前面不加"/"，到最後才添加，避免混亂
            if(i == 0) {
                result = folder_name;
            } else {
                result = folder_name + "/" +result;
            }
            i ++;
        }
        
        //在首個文件夾名稱前面添加"/"
        result = "/" + result;
        
        return result;
    }
}