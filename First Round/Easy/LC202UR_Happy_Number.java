package Easy;

import java.util.HashSet;
import java.util.Set;

public class LC202UR_Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while(n !=1 && !record.contains(n)){
            record.add(n);
            n = getNextNumber(n);
        }
        return  n == 1;
    }

    public int getNextNumber(int n){
        int res = 0;
        while( n > 0 ){
            int temp = n % 10;
            res += temp * temp;
            n = n/10;
        }
        return res;
    }

    public static void main(String[] args) {
        int t1 = 193;
        LC202UR_Happy_Number a = new LC202UR_Happy_Number();
        System.out.println(a.isHappy(t1));
    }
}
