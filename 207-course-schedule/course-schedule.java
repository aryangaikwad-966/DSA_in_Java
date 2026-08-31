class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayList<Integer>[] graph = new ArrayList[numCourses];
       for(int i  = 0; i < numCourses ; i++){
        graph[i] = new ArrayList<>();
       }
       for( int[] p : prerequisites){
        graph[p[1]].add(p[0]);
       }
       boolean[] visited = new boolean[numCourses];
       boolean[] pathVisited = new boolean[numCourses];

       for( int i =0; i < numCourses ; i++){
        if(!visited[i]){
            if(dfs(i, graph , visited , pathVisited)){
                return false;
            }
        }

       }
       return true;

        
    }
    public boolean dfs(int node , ArrayList<Integer>[] graph, boolean[] visited, boolean[] pathVisited ){
        visited[node] = true;
        pathVisited[node] = true;

        for(int next : graph[node]){
            if(!visited[next]){
                if (dfs(next , graph , visited, pathVisited)){
                    return true;
                }
            }
            else if (pathVisited[next]){
                return true;
            }
        }
        pathVisited[node] = false;
        return false;

    }
}