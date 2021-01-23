/*
There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where connections[i] = [a, b] represents a connection between computers a and b. Any computer can reach any other computer directly or indirectly through the network.

Given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected. Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1. 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/


// DFS

class Solution {
    public  List<Integer>[] graph;
    public  boolean[] visited ;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1){
            return -1;
        }
        
        graph = new ArrayList[n];

        visited = new boolean[n];

        for(int i = 0; i < n ; i ++ ){
            graph[i] = new ArrayList<>();

        }
        for(int[] connection : connections){
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        
        }
        int res = 0 ;
        for(int i = 0 ; i < n; i ++ ){
            if(!visited[i]){
                dfs(i);
                res ++ ;
            }
        }
        return res -1;
    }
    public void dfs(int x){
        visited[x] = true;
        for(int i = 0 ; i < graph[x].size(); i ++) {
            if(visited[graph[x].get(i)] == false){
                dfs(graph[x].get(i));
            }
        }
    }
    
}
