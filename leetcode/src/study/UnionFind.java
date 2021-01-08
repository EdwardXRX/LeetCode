package study;

/**
 * @ProjectName: IDEA_PROJECT
 * @Package: study
 * @ClassName: UnionFind
 * @Author: EdwardX
 * @Description:
 * @Date: 2021/1/7 11:12
 * @Version: 1.0
 */
public class UnionFind {
    int[] roots;
    int size; // 集合数量

    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        size = n;
    }

    public int find(int i) {
        if (i == roots[i]) {
            return i;
        }
        return roots[i] = find(roots[i]);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            roots[pRoot] = qRoot;
            size--;
        }
    }
}
