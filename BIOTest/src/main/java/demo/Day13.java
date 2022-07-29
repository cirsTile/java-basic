package demo;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/7/19
 */

public class Day13 {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteChar = ransomNote.toCharArray();
        int[] ransomNoteCount = new int[26];
        for (char c : ransomNoteChar) {
            ransomNoteCount[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            ransomNoteCount[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomNoteCount[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
