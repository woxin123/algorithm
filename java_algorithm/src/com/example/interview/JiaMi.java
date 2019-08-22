import java.util.*;

public class JiaMi {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] ss = new int[s.length()];
        int[] tmp = new int[k];
        int[] res = new int[n];
        for (int i = 0; i < s.length(); i++) {
            ss[i] = s.charAt(i) - '0';
        }
        res[0] = ss[0];
        tmp[0] = 1;
        int l = 1;
        for (int i = 1; i < n; i++) {
            int t = tmp[0];
            for (int j = 1; j < l; j++) {
                t ^= tmp[j];
            }
            res[i] = t ^ ss[i];
            int count = 0;
            for (int j = i; j >= 0 && count < k-1; j--) {
                tmp[count++] = res[j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
    }
}
