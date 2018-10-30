import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PhoneDigitWords {

    private static Map<Integer, String> phoneStringMap = new HashMap<>();

    static {
        phoneStringMap.put(2, "ABC");
        phoneStringMap.put(3, "DEF");
        phoneStringMap.put(4, "GHI");
        phoneStringMap.put(5, "JKL");
        phoneStringMap.put(6, "MNO");
        phoneStringMap.put(7, "PQRS");
        phoneStringMap.put(8, "TUV");
        phoneStringMap.put(9, "WXYZ");
    }

    public static void main(String[] args) {
        final String digits = "459";
        new PhoneDigitWords().findWords(phoneStringMap, digits);
    }

    private void findWords(final Map<Integer, String> phoneStringMap, final String digits) {
        List<String> arr = new ArrayList<>();
        for (final char c : digits.toCharArray()) {
            String characterMappingOfDigit = phoneStringMap.get(Integer.parseInt(String.valueOf(c)));
            if (characterMappingOfDigit != null && !characterMappingOfDigit.isEmpty()) {
                arr = findCombinations(arr, characterMappingOfDigit);
            }
        }
        System.out.println(Arrays.toString(arr.toArray()));
    }

    private List<String> findCombinations(List<String> valueList, String appendValue) {
        final List<String> newValueList = new ArrayList<>();
        if (valueList.isEmpty()) {
            IntStream.range(0, appendValue.length()).forEach(index -> newValueList.add("" + appendValue.charAt(index)));
        } else {
            valueList.forEach(value -> IntStream.range(0, appendValue.length())
                    .forEach(index -> newValueList.add(value + appendValue.charAt(index))));
        }
        return newValueList;
    }
}