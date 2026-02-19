// LeetCode 547
// Number of Provinces
// Topic: Graphs (BFS)
// Difficulty: Medium
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected){
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,isConnected,vis);
                count++;
            }
        }
        return count;
    }

    private void bfs(int start,int[][] adj,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=true;

        while(!q.isEmpty()){
            int node=q.poll();
            for(int j=0;j<adj.length;j++){
                if(adj[node][j]==1 && !vis[j]){
                    vis[j]=true;
                    q.add(j);
                }
            }
        }
    }
}
