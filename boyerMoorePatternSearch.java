public class boyerMoorePatternSearch {
    static int noOfChars=265;

    // static int max(int a, int b){
    //     return (a>b)?a:b;
    // }

    static void badCharacterHeurisitc(char[] str, int size, int[] badChar){
        //initialize all occureence as -1;
        for(int i=0;i<noOfChars;i++){
            badChar[i]=-1;
        }

        // Fill the actual value of last occurrence
        // of a character (indices of table are ascii and
        // values are index of occurrence)
        for(int i =0;i<size;i++){
            badChar[(int) str[i]]=1;
        }
    }

    static void search(char pat[], char[] txt){
            int m= pat.length;
            int n = txt.length;

            int badChar[] = new int[noOfChars];

            // fill the bad character array by calling the preprocessing function badCharHeuristic()
            //for given pattern

            badCharacterHeurisitc(pat, m, badChar);

            int s=0;
            // s is shift of the pattern with respect to text 

            // there are n-m+1 potential alignment
            while(s<=(n-m)){
                int j=m-1;

                /* Keep reducing index j of pattern while
               characters of pattern and text are
               matching at this shift s */
                while(j>=0 && pat[j]==txt[s+j]){
                    j--;
                    /* If the pattern is present at current
               shift, then index j will become -1 after
               the above loop */
                    if(j<0){
                        System.out.println("pattern occur at shift = "+s);

                        /* Shift the pattern so that the next
                   character in text aligns with the last
                   occurrence of it in pattern.
                   The condition s+m < n is necessary for
                   the case when pattern occurs at the end
                   of text */
                // txt[s+m] is character after the pattern
                // in text
                        s+=(s + m < n)? m - badChar[txt[s+m]] : 1;
                    }

                    else{
                        /* Shift the pattern so that the bad
                   character in text aligns with the last
                   occurrence of it in pattern. The max
                   function is used to make sure that we get
                   a positive shift. We may get a negative
                   shift if the last occurrence  of bad
                   character in pattern is on the right side
                   of the current character. */
                        s+=Math.max(1, j-badChar[txt[s + j]]);
                    }
                }
            }

        }
    public static void main(String[] args) {
        char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        search(txt, pat);
    }
}
