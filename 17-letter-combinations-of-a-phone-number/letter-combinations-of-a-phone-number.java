class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        generate(0, "", digits, map, ans);
        return ans;
    }
    private void generate(int index, String current,String digits, String[] map ,List<String> ans) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for (char ch : letters.toCharArray()) {
            generate(index+1,current+ch, digits, map, ans);
        }
    }
}