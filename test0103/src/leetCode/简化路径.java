package leetCode;

import java.util.Stack;

//输入："/a/../../b/../c//.//"
//输出："/c"
public class 简化路径 {
    public static void main(String[] args) {
        简化路径 ins = new 简化路径();
        String path = "/a/../../b/../c//.//";
        System.out.println(ins.simplifyPath(path));
    }

    public String simplifyPath(String path){
        String[] strArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String str : strArr){
            if(str.equals("") || str.equals(".")){}
            else if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stack.size();i++){
            sb.append("/" + stack.get(i));
        }
        String ret = sb.toString();
        if(ret.equals("")){
            ret = "/";
        }
        return ret;
    }
}
