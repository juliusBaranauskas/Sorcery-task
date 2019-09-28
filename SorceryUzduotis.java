public class SorceryUzduotis{

    public static void main(String[] args) {
        System.out.println(isMagic(142856));
    }

    static boolean isMagic(long numToCheck){
        long num = 0;
        short multiples = 2;
        for(long i = 0; i < multiples; i++){ // multiples is the number of multiples to check if the intitial number's permutations are magic
            num+=numToCheck;
            if(!isAPerm(num, numToCheck)){
               return false;
            }
        }
        return true;
    }
    static boolean isAPerm(long num, long numToCheck){
        // make both nums to strings
        String numA = Long.toString(num);
        String numB = Long.toString(numToCheck);
        // compare their length and return false if one is shorter
        if(numA.length() != numB.length()){
            return false;
        }
        // find a symbol in the 2nd string that matches the first one in the first string.
        int indexFirst = 0;
        int indexSecond = 0;
        for(; indexSecond < numA.length(); indexSecond++){
            if(numA.charAt(indexFirst) == numB.charAt(indexSecond)){
                if(areSubstrEqual(numA, numB, indexSecond)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean areSubstrEqual(String a, String b, int index){  // make two substrings, concat and see if they are the same as other string from beginning
        String substr = b.substring(index, b.length())+b.substring(0, index); // ABCD and CDAB  AB+CD from 2nd and compare it with ABCD
        return a.equals(substr);
    }
}