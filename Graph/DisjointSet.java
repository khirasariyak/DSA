package Graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public void union(int u, int v) {
        int pU = find(u);
        int pV = find(v);

        if (pU == pV) {
            return;
        }

        int rU = rank.get(pU);
        int rV = rank.get(pV);

        if (rU < rV) {
            parent.set(pU, pV);
        } else if (rV < rU) {
            parent.set(pV, pU);
        } else {
            parent.set(pV, pU);
            rank.set(pU, rU + 1);
        }
    }

    public int find(int u) {
        if (parent.get(u) != u) {
            parent.set(u, find(parent.get(u)));
        }
        return parent.get(u);
    }

}
