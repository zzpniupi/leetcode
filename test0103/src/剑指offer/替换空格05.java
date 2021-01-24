package 剑指offer;

public class 替换空格05 {
    public static void main(String[] args) {
        String s = "We are happy.";
        替换空格05 ins = new 替换空格05();

        System.out.println(ins.replaceSpace(s));
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        for(Character c : s.toCharArray()){
            if(c.equals(' '))
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
