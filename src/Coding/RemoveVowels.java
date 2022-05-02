package Coding;

import java.util.Set;

public class RemoveVowels {
    public String removeVowels(String str){
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();

        char[] charArray = str.toCharArray();
        for (Character ch: charArray){
            if(!vowels.contains(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
