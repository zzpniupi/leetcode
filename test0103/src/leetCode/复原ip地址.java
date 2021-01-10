package leetCode;

import java.util.ArrayList;
import java.util.List;

public class 复原ip地址 {
    public static void main(String[] args) {
        String s = "010010";
        复原ip地址 ins = new 复原ip地址();

        ins.restoreIpAddresses(s);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        int length = s.length();
        String a, b, c, d;

        for(int i = 1; i <= 3; i++) {
            if(i > length)
                continue;
            a = s.substring(0, i);
            for(int j = 1; j <= 3; j++) {
                if(j + i > length)
                    continue;
                b = s.substring(i, i + j);
                for(int k = 1; k <= 3; k++){
                    if(i + j + k > length)
                        continue;
                    c = s.substring(i + j, i + j + k);
                    for(int m = 1 ; m <= 3 ; m++){
                        if(i + j + k + m > length)
                            continue;
                        d = s.substring(i + j + k, i + j + k + m);
                        if(i + j + k + m == length) {
                            if(isLessThan255(a) && isLessThan255(b) && isLessThan255(c) && isLessThan255(d) &&
                                    !isBeginWith0(a) && !isBeginWith0(b) && !isBeginWith0(c) && !isBeginWith0(d)){
                                String str = a + "." + b + "." + c + "." + d;
                                list.add(str);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public Boolean isLessThan255(String strNum){
        int num = Integer.parseInt(strNum);
        if(num <= 255)
            return true;
        else
            return false;
    }

    public Boolean isBeginWith0(String num){
        if(num.length() > 1 && num.charAt(0) == '0'){
            return true;
        }else{
            return false;
        }
    }
}
