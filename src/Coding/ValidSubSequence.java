package Coding;

public class ValidSubSequence {
    public boolean isSubSequence(String str, String seq){
        int i = 0;
        int j = 0;
        while (i < str.length() && j < seq.length()){
            if(str.charAt(i) == seq.charAt(j)){
                j++;
            }
            i++;
        }
        return j == seq.length();
    }

    public static void main(String[] args) {
        ValidSubSequence ss = new ValidSubSequence();
        System.out.println(ss.isSubSequence("abcde", "ace"));
    }
}
