class Solution {

    class Node {
        char l, r;
        int pre, suf, max, len;

        Node(char l, char r, int pre, int suf, int max, int len) {
            this.l = l;
            this.r = r;
            this.pre = pre;
            this.suf = suf;
            this.max = max;
            this.len = len;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(String str, String qc, int[] qi) {
        s = str.toCharArray();
        tree = new Node[4 * s.length];

        build(1, 0, s.length - 1);

        int[] ans = new int[qi.length];

        for (int i = 0; i < qi.length; i++) {
            s[qi[i]] = qc.charAt(i);
            update(1, 0, s.length - 1, qi[i]);
            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int n, int l, int r) {
        if (l == r) {
            tree[n] = new Node(s[l], s[l], 1, 1, 1, 1);
            return;
        }

        int m = (l + r) / 2;
        build(2 * n, l, m);
        build(2 * n + 1, m + 1, r);

        tree[n] = merge(tree[2 * n], tree[2 * n + 1]);
    }

    void update(int n, int l, int r, int idx) {
        if (l == r) {
            tree[n] = new Node(s[l], s[l], 1, 1, 1, 1);
            return;
        }

        int m = (l + r) / 2;

        if (idx <= m)
            update(2 * n, l, m, idx);
        else
            update(2 * n + 1, m + 1, r, idx);

        tree[n] = merge(tree[2 * n], tree[2 * n + 1]);
    }

    Node merge(Node a, Node b) {
        Node x = new Node(
            a.l, b.r,
            a.pre, b.suf,
            Math.max(a.max, b.max),
            a.len + b.len
        );

        if (a.r == b.l) {
            x.max = Math.max(x.max, a.suf + b.pre);

            if (a.pre == a.len)
                x.pre = a.len + b.pre;

            if (b.suf == b.len)
                x.suf = a.suf + b.len;
        }

        return x;
    }
}