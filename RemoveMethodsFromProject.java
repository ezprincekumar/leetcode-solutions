import java.util.*;

public class RemoveMethodsFromProject {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        boolean[] suspicious = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : invocations) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }

        dfs(k, graph, suspicious, indegree);

        for (int i = 0; i < n; i++) {
            if (suspicious[i] && indegree[i] > 0) {
                List<Integer> all = new ArrayList<>();
                for (int j = 0; j < n; j++) all.add(j);
                return all;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) ans.add(i);
        }
        return ans;
    }

    private void dfs(int u, List<Integer>[] graph, boolean[] suspicious, int[] indegree) {
        if (suspicious[u]) return;
        suspicious[u] = true;
        for (int v : graph[u]) {
            indegree[v]--;
            dfs(v, graph, suspicious, indegree);
        }
    }

    public static void main(String[] args) {
        RemoveMethodsFromProject sol = new RemoveMethodsFromProject();

        int n1 = 5, k1 = 0;
        int[][] invocations1 = {{0,1}, {1,2}, {2,3}, {3,4}};
        System.out.println("Remaining methods (Example 1): " + sol.remainingMethods(n1, k1, invocations1));

        int n2 = 4, k2 = 1;
        int[][] invocations2 = {{0,1}, {1,2}, {2,3}};
        System.out.println("Remaining methods (Example 2): " + sol.remainingMethods(n2, k2, invocations2));

        int n3 = 3, k3 = 2;
        int[][] invocations3 = {{0,1}, {1,2}};
        System.out.println("Remaining methods (Example 3): " + sol.remainingMethods(n3, k3, invocations3));
    }
}
