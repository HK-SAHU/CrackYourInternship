import java.nio.channels.ScatteringByteChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class printAllDuplicatesInString {

    // using no extra space and sorting

    public static void printDuplicates(String str){
        int n= str.length();
        char[] ch= str.toCharArray();
        Arrays.sort(ch);
        String sortedStr= new String(ch);

        for(int i=0;i<n;i++){
            int count=1;
            while(i<n-1 && sortedStr.charAt(i)==sortedStr.charAt(i+1)){
                count++;
                i++;
            }
            if(count>1){
                System.out.println(sortedStr.charAt(i)+ ", count = " + count);
            }
        }
    }



        // using hashing
        private static void PrintDuplicates(String str){
            int n= str.length();

            HashMap<Character, Integer> mp= new HashMap<>();
            // for(int i=0;i<n;i++){

            //     if(mp.containsKey(str.charAt(i))){
            //         mp.put(str.charAt(i), mp.get(str.charAt(i)+1));
            //     }
            //     else{
            //         mp.put(str.charAt(i), 1);
            //     }
            // }

            for (char c : str.toCharArray()) {
                mp.put(c, mp.getOrDefault(c, 0) + 1);
            }

            for(HashMap.Entry<Character,Integer> mapElement : mp.entrySet()){    // iterating through unorderd map
                if(mapElement.getValue() >1){
                    System.out.println(mapElement.getKey()+ ", count = " + mapElement.getValue());
                }

            }
        }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        printDuplicates(str);
        PrintDuplicates(str);
    }  
}
