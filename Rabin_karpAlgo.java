import java.util.Scanner;

public class Rabin_karpAlgo {

    public final static int d=126;     // number of characters

    public static void search(String txt, String pattern, int q){
        int m= pattern.length();
        int n= txt.length();
        int i, j;
        int p=0;    //hash value for pattern
        int t=0;    // hash vlaue for text
        int h=1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < m - 1; i++){
            h = (h * d) % q;
        }


        // Calculate the hash value of pattern and first
        // window of text
        for(i=0;i<m;i++){
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one

        for (i = 0; i <= n - m; i++) {
            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
              for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pattern.charAt(j))
                  break;
              }

              // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
      
              if (j == m)
                System.out.println("Pattern is found at position: " + (i + 1));
            }
      

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;


              // We might get negative value of t,
                // converting it to positive
                if (t < 0){
                    t = (t + q);
                }
                
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s=sc.nextLine();

        String pattern= sc.nextLine();

        int q=13;

        search(s, pattern, q);

    }
}
