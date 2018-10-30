import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class WordJumper {

    public static void main(String[] args) throws FileNotFoundException {
        String word = "hate";
        String finalWord = "mate";
        WordJumper wordJumper = new WordJumper();
        Set<String> words = wordJumper.readWords();
        Set<String> foundWords = new HashSet<>();
        wordJumper.findAllOneLetterChanges(word, words, foundWords, finalWord);
        System.out.println(foundWords.size());
        System.out.println(foundWords.contains(word) && foundWords.contains(finalWord));
    }

    private void findAllOneLetterChanges(String word, final Set<String> words, final Set<String> foundWords,
            final String target) {
        final Stack<String> stack = new Stack<>();
        stack.push(word);
        boolean found = false;
        int count = 0;
        while (!stack.empty()) {
            count++;
            final String stackWord = stack.pop();
            if (stackWord.equalsIgnoreCase(target)) {
                found = true;
            }
            if (!found) {
                System.out.print(stackWord + " -> ");
            }
            for (int j = 0; j < stackWord.length(); j++) {
                for (char i = 'a'; i <= 'z'; i++) {
                    String newWord = swap(stackWord, j, i);
                    if (words.contains(newWord)) {
                        if (!newWord.equalsIgnoreCase(stackWord) && !foundWords.contains(newWord)) {
                            stack.push(newWord);
                        }
                        foundWords.add(newWord);
                    }
                }
            }
        }
        System.out.println("Count: " + count);
    }

    private Set<String> readWords() throws FileNotFoundException {
        final Set<String> wordSet = new HashSet<>();
        File file = new File("src/main/resources/words_alpha.txt");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                wordSet.add(scanner.next());
            }
        }
        return wordSet;
    }

    private String swap(String val, int l, char c) {
        char[] charArray = val.toCharArray();
        charArray[l] = c;
        return String.valueOf(charArray);
    }

}
