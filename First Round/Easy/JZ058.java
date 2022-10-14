package Easy;
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
//比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

public class JZ058 {
    public String reverseLeftWords(String s, int n) {
        char[] ini = s.toCharArray();
        char[] tail = new char[n];

        for(int i=0, j=n; j < ini.length || i < n; i++, j++){
            if(i < n) tail[i] = ini[i];
            if(j < ini.length) ini[i] = ini[j];
        }

        for(int i = ini.length - n , j=0; i < ini.length; i++, j++){
            ini[i] = tail[j];
        }

        return new String(ini);

    }

    public static void main(String[] args) {
        String t1 = "lrloseumgh";
        JZ058 a = new JZ058();
        System.out.println(a.reverseLeftWords(t1,6));;
    }
}
