class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        generate(current, 0, 0, n, result);

        return result;
    }

    public void generate(
            StringBuilder current,
            int open,
            int close,
            int n,
            List<String> result) {

       
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        
        if (open < n) {
            current.append('(');

            generate(current, open + 1, close, n, result);

            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');

            generate(current, open, close + 1, n, result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}