import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import static java.lang.Long.compare;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.comparingLong;


/**
 * @author pribic (Priyank Doshi)
 * @see <a href="https://codeforces.com/problemset/problem/4/C" target="_top">https://codeforces.com/problemset/problem/4/C</a>
 * @since 18/05/22 4:01 PM
 */

public class WaterSortPuzzleSolution {
    private static final long mod = 998244353;//(long) (1e9 + 7);
    private static final int oneE5 = (int) 1e5;
    private static final int oneE9 = (int) 1e9;
    private static final long BIG = 2_000_000_010L;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    static FastScanner sc = new FastScanner(System.in);
    static Map<Character, int[]> direction = new HashMap<>();
    static Set<Character> openingBrackets;
    static Set<Character> closingBrackets;
    static Map<Character, Character> bracketsMatching = new HashMap<>();
    static ArrayList<Integer>[] al;
    static int[] parent;
    static Map<Integer, List<Integer>> factorsCache = new HashMap<>();
    static char nullChar = '\u0000';
    static char emptyBar = '@';

    public static void main(String[] args) {
        prebuild();
        //System.out.println(Integer.toBinaryString(16));
        try (PrintWriter out = new PrintWriter(System.out)) {
            int T = 1;//sc.nextInt();
            for (int tt = 1; tt <= T; tt++) {

                String str = sc.next();
                int totalBottles = 2;
                for (char c : str.toCharArray())
                    if (c == ';')
                        totalBottles++;
                char[][] grid = new char[totalBottles][4];
                int idx = 0;
                for (String bottle : str.split(";")) {
                    grid[idx++] = bottle.toCharArray();
                }
                grid[idx++] = new char[]{emptyBar, emptyBar, emptyBar, emptyBar};
                grid[idx++] = new char[]{emptyBar, emptyBar, emptyBar, emptyBar};
                List<int[]> moves = new ArrayList<>();
                solve(grid, moves, new HashSet<>());
                System.out.println(totalBottles);

            }
        }
    }

    static int findHash(char[][] grid) {
        StringBuilder str = new StringBuilder(new String());
        for (char[] gr : grid)
            str.append(gr[0]).append(gr[1]).append(gr[2]).append(gr[2]);
        return str.toString().hashCode();
    }

    private static boolean solve(char[][] grid, List<int[]> moves, Set<Integer> visited) {
        int hash = findHash(grid);
        if (visited.contains(hash))
            return false;
        //check if grid is solved
        //we should have 2 empty bottles, all other bottles should have same color
        int emptyBottleCount = 0;
        int sameColorBottleCount = 0;
        boolean solved = true;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == '@')
                emptyBottleCount++;
            else {
                //all should be same
                if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] == grid[i][3])
                    sameColorBottleCount++;
                else
                    solved = false;
            }
        }
        if (emptyBottleCount == 2 && solved) {
            //print answer
            System.out.println("moves===");
            for (int[] move : moves)
                System.out.println(move[0] + " " + move[1]);
            return true;
        }

        int bottles = grid.length;
        for (int i = 0; i < bottles - 1; i++) {
            for (int j = 0; j < bottles; j++) {
                // i is source bottle
                // j is target bottle
                //if source bottle is empty, we can skip this.
                if (i == j || isBottleFullWithSameColor(grid[i]) || isEmptyBottle(grid[i]) || isFullyFillBottle(grid[j]))
                    continue; // skipping empty source bottle case; and target bottle full case
                //can we swap ith and jth bottle
                if (canSwapBottle(grid[i], grid[j])) {
                    List<int[]> moveClone = copy(moves);
                    moveClone.add(new int[]{i, j});
                    Set<Integer> hashes = copy1(visited);
                    hashes.add(findHash(grid));
                    char[][] gridCopy = copy2(grid);
                    for (int k = 0; k < 4; k++)
                        swapBottle(gridCopy, i, j);
                    boolean isSolve = solve(gridCopy, moveClone, hashes);
                    if (isSolve)
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean isBottleFullWithSameColor(char[] bottle) {
        for (int i = 1; i < 4; i++) {
            if ((bottle[i] == emptyBar || bottle[i] != bottle[i - 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFullyFillBottle(char[] grid) {
        return grid[3] != emptyBar;
    }

    private static char[][] copy2(char[][] grid) {
        char[][] ans = new char[grid.length][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                ans[i][j] = grid[i][j];
        }
        return ans;
    }

    private static Set<Integer> copy1(Set<Integer> visited) {
        return new HashSet<>(visited);
    }

    private static List<int[]> copy(List<int[]> moves) {
        List<int[]> ans = new ArrayList<>();
        for (int[] move : moves)
            ans.add(new int[]{move[0], move[1]});
        return ans;
    }

    private static void swapBottle(char[][] grid, int i, int j) {
        if (i == j || isEmptyBottle(grid[i]) || isFullyFillBottle(grid[j]))
            return;
        if (!isEmptyBottle(grid[j]) && grid[i][getBottleTop(grid[i])] != grid[j][getBottleTop(grid[j])])
            return;
        //move top non-empty element from ith bottle to jth bottle
        int sourceTopElementIdx = getBottleTop(grid[i]);
        int targetTopelementIdx = getBottleTop(grid[j]);
        grid[j][targetTopelementIdx + 1] = grid[i][sourceTopElementIdx]; // move top element from source to target
        grid[i][sourceTopElementIdx] = emptyBar; // mark source top element as empty
        //
    }

    private static boolean isEmptyBottle(char[] grid) {
        return grid[0] == emptyBar;
    }

    private static boolean canSwapBottle(char[] source, char[] target) {
        // if b2 is empty
        if (isEmptyBottle(target))
            return true;
        //
        int sourceTopIdx = getBottleTop(source);
        int targetTopIdx = getBottleTop(target);
        char b1Top = source[sourceTopIdx];
        char b2Top = target[targetTopIdx];
        return b1Top == b2Top;
    }

    //b1 will never be empty. It will at least have 1 bar
    private static int getBottleTop(char[] b) {
        for (int i = b.length - 1; i >= 0; i--)
            if (b[i] != emptyBar)
                return i;
        return -1;
    }


    private static int[][] calculateMEXForEachSubArray(int[] arr) {
        int n = arr.length;
        int[][] mex = new int[n][n];
        //calculate mex for each sub array
        for (int l = 0; l < n; l++) {
            boolean[] present = new boolean[n + 1];
            int k = 0; // current mex
            for (int r = l; r < n; r++) { // active: [l, r]
                present[arr[r]] = true;
                while (present[k])
                    k++;
                mex[l][r] = k;
            }
        }
        return mex;
    }

    //checks if ith bit is set or not in num
    private static boolean isBitSet(int num, int i) {
        return ((num >> i) & 1) == 1;
    }

    private static boolean isBitSet(long num, int i) {
        return ((num >> i) & 1) == 1;
    }

    private static boolean present(char[][] table, int col, char c) {
        for (int i = 0; i < table.length; i++) {
            if (table[i][col] == c)
                return true;
        }
        return false;
    }


    private static long max(int... arr) {
        return IntStream.of(arr).max().getAsInt();
    }

    private static boolean alldiff(int... arr) {
        Set<Integer> aa = new HashSet<>();
        for (int i : arr) aa.add(i);
        return aa.size() == 10;
    }

    private static void print(int[][] diff) {
        System.out.println("printing 2d array");
        for (int[] d : diff) {
            print(d);
        }
    }

    private static void print(boolean[][] arr) {
        System.out.println("printing 2d array");
        for (boolean[] d : arr) {
            print(d);
        }
    }


    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr)
            sb.append(a).append(" ");
        System.out.println(sb);
    }

    private static void print(boolean[] arr) {
        StringBuilder sb = new StringBuilder();
        for (boolean a : arr)
            sb.append(a).append(" ");
        System.out.println(sb);
    }

    private static void dfs(int u, int parent, int[] size) {
        for (int v : al[u]) {
            if (v != parent) {
                dfs(v, u, size);
                size[u] += 1 + size[v];
            }
        }
    }

    // Function returns the
// minimum number of swaps
// required to sort the array
    public static int minSwaps(int[] nums) {
        boolean isAdjacentNumber = false;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(nums[i], i);

        Arrays.sort(nums);

        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        // Initialize result
        int ans = 0;
        for (int i = 0; i < len; i++) {

            // already swapped and corrected or
            // already present at correct pos
            if (visited[i] || map.get(i + 1) == i)
                continue;

            int j = i, cycle_size = 0;
            List<Integer> visitedNums = new ArrayList<>();
            while (!visited[j]) {
                visited[j] = true;
                visitedNums.add(j);
                // move to next node
                j = map.get(nums[j]);
                cycle_size++;
            }
            //System.out.println("visitedNums = " + visitedNums);
            // Update answer by adding current cycle.
            if (cycle_size > 0) {
                ans += (cycle_size - 1);
                Collections.sort(visitedNums);
                for (int k = 0; k < visitedNums.size(); k++) {
                    if (Math.abs(visitedNums.get(k) - visitedNums.get((k + 1) % visitedNums.size())) == 1)
                        isAdjacentNumber = true;
                }
            }

        }
        return isAdjacentNumber ? Math.max(0, ans - 1) : ans + 1;
    }



  /*
8

1 2 3 4 5 6 7 8
   */

    //removes the top element from this pq if they are higher than tar since they are useless to us
    private static void removeHigher(PriorityQueue<Integer> scissors, int tar) {
        while (!scissors.isEmpty() && scissors.peek() > tar)
            scissors.remove();
    }


    private static boolean period(String a, int len, String base) {
        for (int j = 0; j < a.length(); j++)
            if (a.charAt(j) != base.charAt(j % len))
                return false;
        return true;
    }

    /*
    98280 has 128 factors - just in case needed for checking worst case scenario
     */
    private static List<Integer> factors(int n) {
        if (factorsCache.containsKey(n))
            return factorsCache.get(n);
        List<Integer> fact = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                fact.add((int) i);
                if (n / i != i)
                    fact.add((int) (n / i));
            }
        }
        Collections.sort(fact);
        factorsCache.put(n, fact);
        return fact;
    }

    private static void reverse(long[] arr) {
        for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
            long t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
        }
    }

    private static void reverse(int[] arr) {
        for (int l = 0, r = arr.length - 1; l < r; l++, r--) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
        }
    }

    private static boolean outside(int u1, int v1, int v2) {
        return !(u1 <= v2 && v2 <= v1);
    }

    //[l, r]
    private static boolean inside(int l, int r, int x) {
        return l <= x && x <= r;
    }

    private static long[] prefixSum(int[] arr) {
        long[] ps = new long[arr.length];
        long cs = 0;
        for (int i = 0; i < arr.length; i++) {
            cs += arr[i];
            ps[i] = cs;
        }
        return ps;
    }

    //sum of arr[l..r]
    private static long rangeSum(long[] arr, int l, int r) {
        return l > 0 ? arr[r] - arr[l - 1] : arr[r];
    }

    private static long convert(long val) {
        List<Integer> digits = getDigits(val);
        Collections.reverse(digits);
        long binary = 0;
        for (int d : digits)
            binary = binary * 2 + d % 2;
        return binary;
    }

    private static List<Integer> getDigits(long val) {
        List<Integer> digits = new ArrayList<>();
        while (val > 0) {
            digits.add((int) (val % 10));
            val /= 10;
        }
        return digits;
    }

    private static int getDigitsSum(long val) {
        List<Integer> digits = getDigits(val);
        return digits.stream().reduce(Integer::sum).get();
    }

    /*
    if they touch even on end points, we consider them as intersecting
     */
    private static boolean intersect(int[] a, int[] b) {
        if (a[0] <= b[0]) // a starts before b
            return a[1] >= b[0]; // a should end after start of b
        else
            return intersect(b, a); // swap a and b and then ans
    }

    private static void prebuild() {
        direction.put('L', new int[]{0, -1});
        direction.put('R', new int[]{0, 1});
        direction.put('U', new int[]{-1, 0});
        direction.put('D', new int[]{1, 0});
        bracketsMatching.put('<', '>');
        bracketsMatching.put('{', '}');
        bracketsMatching.put('(', ')');
        bracketsMatching.put('[', ']');
        openingBrackets = bracketsMatching.keySet();
        closingBrackets = new HashSet<>(bracketsMatching.values());
    }

    private static boolean checkValidParanthesis(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (openingBrackets.contains(s.charAt(i)))
                cnt++;
            else cnt--;
            if (cnt < 0)
                return false;
        }
        return cnt == 0;
    }

    private static long nc2(long n) {
        return n * (n - 1) / 2;
    }

    private static Map<Integer, Integer> generateMapping(Set<Integer> colors) {
        int id = 0;
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int c : colors)
            mapping.put(c, id++);
        return mapping;
    }

    private static int[][] rotate(int[][] grid) {
        int[][] ans = new int[grid[0].length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans[j][grid.length - 1 - i] = grid[i][j];
            }
        }
        return ans;
    }

    private static void sort(int[] arr) {
        sort(arr, comparingInt(a -> a));
    }

    private static void sort(long[] arr) {
        sort(arr, comparingLong(a -> a));
    }

    private static void sort(int[] arr, Comparator<Integer> comparator) {
        List<Integer> ls = new ArrayList<>();
        for (int n : arr) ls.add(n);
        Collections.sort(ls, comparator);
        for (int i = 0; i < arr.length; i++) arr[i] = ls.get(i);
    }

    private static void sort(long[] arr, Comparator<Long> comparator) {
        List<Long> ls = new ArrayList<>();
        for (long n : arr) ls.add(n);
        Collections.sort(ls, comparator);
        for (int i = 0; i < arr.length; i++) arr[i] = ls.get(i);
    }

    //sorts based on first element
    private static void sort(int[][] arr) {
        List<int[]> ls = new ArrayList<>();
        for (int[] n : arr) ls.add(n);
        Collections.sort(ls, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < arr.length; i++) arr[i] = ls.get(i);
    }

    //sorts based on first element
    private static void sort(long[][] arr) {
        List<long[]> ls = new ArrayList<>();
        for (long[] n : arr) ls.add(n);
        Collections.sort(ls, (a, b) -> a[0] != b[0] ? compare(a[0], b[0]) : compare(a[1], b[1]));
        for (int i = 0; i < arr.length; i++) arr[i] = ls.get(i);
    }

    /*
      op 4
    0 1 0 0 1 1 1 1 1 1 0 0 0 1 1

    1 1 1 1 0 0 1 1 0 1 0 0 1 1 0

       */
    static class Queries {
        int queryId;
        int idx;
        int k;

        public Queries(int queryId, int idx, int k) {
            this.queryId = queryId;
            this.idx = idx;
            this.k = k;
        }
    }

    static class Kosaraju {
        int n;
        HashSet<Integer>[] al;
        HashSet<Integer>[] ral;
        List<Integer> order;
        int[] comp; // component
        boolean[] assignment;
        boolean[] used;

        Kosaraju(int n) {
            this.n = n;
            al = new HashSet[n + 1];
            ral = new HashSet[n + 1];
            comp = new int[n + 1];
            Arrays.fill(comp, -1); // -1 indicates this is not yet assigned to any component
            assignment = new boolean[n + 1];
            used = new boolean[n + 1];
            order = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                al[i] = new HashSet<>();
                ral[i] = new HashSet<>();
            }
        }

        void dfs1(int u) {
            if (used[u])
                return;
            used[u] = true;
            for (int v : al[u])
                dfs1(v);
            order.add(u);
        }

        void dfs2(int u, int id) {
            if (comp[u] != -1)
                return;
            comp[u] = id;
            for (int v : ral[u])
                dfs2(v, id);
        }

        boolean solve_2SAT() {
            order.clear();
            Arrays.fill(used, false);
            for (int i = 0; i < n; i++)
                dfs1(i);
            Arrays.fill(comp, -1);
            for (int i = 0, id = 0; i < n; i++) {
                int v = order.get(n - i - 1);
                if (comp[v] == -1)
                    dfs2(v, id++);
            }
            Arrays.fill(assignment, false);
            for (int i = 0; i < n; i += 2) {
                if (comp[i] == comp[i + 1]) // a and !a are part of same strongly connected component, so we can not solve this system
                    return false;
                assignment[i / 2] = comp[i] > comp[i + 1];
            }
            return true;
        }

        void addEdge(int u, int v) {
            al[u].add(v);
            ral[v].add(u);
            //System.out.println("add edge from: " + u + ", to: " + v);
        }

        // u || v means add following two edges:
        // not u -> v
        // not v -> u
        void add_disjunction(int u, int v) {
            addEdge(u ^ 1, v);
            addEdge(v ^ 1, u);
        }

        void add_xor_edge(int u, int v) {
            add_disjunction(u, v);
            add_disjunction(u ^ 1, v ^ 1);
            //System.out.println("adding xor edge from: " + u + ", to: " + v);
        }

        void add_not_xor_edge(int u, int v) {
            add_disjunction(u ^ 1, v);
            add_disjunction(u, v ^ 1);
        }
    }

    static class SegmentTree { // [) - inclusive - exclusive range query

        int size;
        long[] arr;

        int inputSize;

        private long neutralElement = Long.MIN_VALUE / 2;

        public SegmentTree(int n) {
            size = 1;
            inputSize = n;
            while (size < n) size *= 2;
            arr = new long[2 * size - 1];
            Arrays.fill(arr, neutralElement);
        }

        public void print() {
            //Arrays.stream(arr).forEachOrdered(x -> System.out.print(x + " "));
        }

        private void build(long[] input, int x, int lx, int rx) {
            if (rx - lx == 1) {
                if (lx < inputSize)
                    arr[x] = input[lx];
                return;
            }
            int mid = (lx + rx) / 2;
            build(input, 2 * x + 1, lx, mid);
            build(input, 2 * x + 2, mid, rx);
            arr[x] = op(arr[2 * x + 1], arr[2 * x + 2]);
        }

        public void build(long[] arr) {
            build(arr, 0, 0, size);
        }

        private void set(int index, long val, int x, int lx, int rx) {
            if (rx - lx == 1) {
                arr[x] = val;
                return;
            }
            int mid = (lx + rx) / 2;
            if (index < mid) {
                set(index, val, 2 * x + 1, lx, mid);
            } else {
                set(index, val, 2 * x + 2, mid, rx);
            }
            arr[x] = op(arr[2 * x + 1], arr[2 * x + 2]);
        }

        public void set(int index, long val) {
            set(index, val, 0, 0, size);
        }

        public long get(int l, int r) {
            return get(l, r, 0, 0, size);
        }

        public long get(int l, int r, int x, int lx, int rx) {
            if (lx >= r || l >= rx)
                return neutralElement;
            if (lx >= l && rx <= r)
                return arr[x];
            int mid = (lx + rx) / 2;
            long max1 = get(l, r, 2 * x + 1, lx, mid);
            long max2 = get(l, r, 2 * x + 2, mid, rx);
            return op(max1, max2);
        }

        private long op(long a, long b) {
            return Math.max(a, b);
        }
    }

    static class SegmentTreeRangeMin { // [) - inclusive - exclusive range query

        int size;
        long[] arr;

        int inputSize;

        private long neutralElement = Long.MAX_VALUE / 2;

        public SegmentTreeRangeMin(int n) {
            size = 1;
            inputSize = n;
            while (size < n) size *= 2;
            arr = new long[2 * size - 1];
            Arrays.fill(arr, neutralElement);
        }

        public void print() {
            //Arrays.stream(arr).forEachOrdered(x -> System.out.print(x + " "));
        }

        private void build(long[] input, int x, int lx, int rx) {
            if (rx - lx == 1) {
                if (lx < inputSize)
                    arr[x] = input[lx];
                return;
            }
            int mid = (lx + rx) / 2;
            build(input, 2 * x + 1, lx, mid);
            build(input, 2 * x + 2, mid, rx);
            arr[x] = op(arr[2 * x + 1], arr[2 * x + 2]);
        }

        public void build(long[] arr) {
            build(arr, 0, 0, size);
        }

        private void set(int index, long val, int x, int lx, int rx) {
            if (rx - lx == 1) {
                arr[x] = val;
                return;
            }
            int mid = (lx + rx) / 2;
            if (index < mid) {
                set(index, val, 2 * x + 1, lx, mid);
            } else {
                set(index, val, 2 * x + 2, mid, rx);
            }
            arr[x] = op(arr[2 * x + 1], arr[2 * x + 2]);
        }

        public void set(int index, long val) {
            set(index, val, 0, 0, size);
        }

        public long get(int l, int r) {
            return get(l, r, 0, 0, size);
        }

        public long get(int l, int r, int x, int lx, int rx) {
            if (lx >= r || l >= rx)
                return neutralElement;
            if (lx >= l && rx <= r)
                return arr[x];
            int mid = (lx + rx) / 2;
            long max1 = get(l, r, 2 * x + 1, lx, mid);
            long max2 = get(l, r, 2 * x + 2, mid, rx);
            return op(max1, max2);
        }

        private long op(long a, long b) {
            return Math.min(a, b);
        }
    }

  /*

  91 1 2 4 3 10

  N , root(n)

  N = 100
  10
  left[i] = j , j < i and arr[j] < arr[i] and (i - j) minimize

   */

    static class UnionFind { // 0 based indexing
        int[] parent;
        int[] size;
        int sz;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < parent.length; i++)
                parent[i] = i;
            sz = n;
        }

        int get(int x) {
            return parent[x] == x ? x : get(parent[x]);
        }

        boolean union(int a, int b) {
            int pa = get(a);
            int pb = get(b);
            if (pa == pb)
                return false;
            //we want pa to be new parent
            if (size[pa] < size[pb]) {
                int t = pa;
                pa = pb;
                pb = t;
            }
            size[pa] += size[pb];
            parent[pb] = pa;
            sz--;
            return true;
        }

        int getSize() {
            return sz;
        }
    }

    static class Pair {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    // 1 2 3
// 2 3 2
    static class BIT {
        long[] val;

        BIT(int size) {
            this.val = new long[size + 1];
        }

        long query(int idx) {
            long sum = 0;
            while (idx > 0 && idx < val.length) {
                sum += val[idx];
                idx -= idx & -idx;
            }
            return sum;
        }

        // [l, r]
        long query(int l, int r) {
            return query(r) - query(l - 1);
        }

        void update(int idx, long delta) {
            while (idx < val.length) {
                val[idx] += delta;
                idx += idx & -idx;
            }
        }
    }


    static class GeoMetryUtil {

        public static boolean checkRightAngled(int x1, int y1, int x2, int y2, int x3, int y3) {
            int A = (int) Math.pow(x2 - x1, 2) + (int) Math.pow(y2 - y1, 2);
            int B = (int) Math.pow(x2 - x3, 2) + (int) Math.pow(y2 - y3, 2);
            int C = (int) Math.pow(x3 - x1, 2) + (int) Math.pow(y3 - y1, 2);
            return (A > 0 && B > 0 && C > 0) && (A == B + C || B == C + A || C == A + B);
        }

        public static boolean checkRightAngled(int[] x, int[] y, int[] z) {
            return checkRightAngled(x[0], x[1], y[0], y[1], z[0], z[1]);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f), 32768);
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        int[] nextArrayInt(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
