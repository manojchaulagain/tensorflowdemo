public class Permutation {
    public static void main(String[] args) {
        String value = "abcd";
        new Permutation().permute(value, 0, value.length() - 1);
    }

    private void permute(String val, int l, int r) {
        if (l == r) {
            System.out.println(val);
        } else {
            for (int i = l; i <= r; i++) {
                val = swap(val, l, i);
                permute(val, l + 1, r);
                val = swap(val, l, i);
            }
        }
    }

    private String swap(String val, int l, int r) {
        char temp;
        char[] charArray = val.toCharArray();
        temp = charArray[l];
        charArray[l] = charArray[r];
        charArray[r] = temp;
        return String.valueOf(charArray);
    }
}
