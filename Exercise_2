
import java.util.*;

public class Exercise_2 {

    public static void main(String[] args) {

        String wordList = "vase bat gods latte name apres spit joke ham dog act tale parse pits asper tab table mane late god cat table save spare";
        findAnagram(wordList);
    }

    /*  Description: Prints all found anagrams in a passed in String of words.
     *  Parameters: String wordList - list of words that potentially have anagrams
     *  Return: void
     */
    public static void findAnagram(String wordList) {

        // Check if the input is valid
        if(wordList == null || wordList.isEmpty())
        {
            System.out.println("Input is required to run this code. Try entering some words separated by spaces.");
            return;
        }

        // Create array of the entered words
        String[] wordArray = wordList.split(" ");

        // Create a HashMap to record found anagrams
        HashMap<String, String> anagramMap = new HashMap<>();

        // Loop through the array of words and add any unique anagrams to the HashMap
        for(String word : wordArray){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            // Check if the sortedString exists as a key in the HashMap
            if(anagramMap.containsKey(sortedString)) {
                // Get the existing list of anagrams
                String tempStr = anagramMap.get(sortedString);
                // Insert if the word is not already added
                if (!tempStr.contains(word)) {
                    anagramMap.put(sortedString, tempStr + " " + word);
                }
            } else {
                // Create a new key/value pair with the new anagram
                anagramMap.put(sortedString, word);
            }

        }

        // Print the found anagrams
        for(String anagram : anagramMap.values()){
            // Ignore single record strings
            if(anagram.contains(" ")){
                System.out.println(anagram);
            }
        }
    }
}
