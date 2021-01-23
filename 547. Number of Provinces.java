/*

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

*/

class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        for(int i = 0 ; i < M.length; i++){
            for(int j = 0; j < M[0].length ; j++){
                if(M[i][j] == 1){
                    res ++;
                    infect(M,i,j);
                }
            }
        }
        return res;
    }
    public void infect(int[][] board, int i ,int j){
        board[i][j] = 2;
        for(int k = 0; k < board[0].length; k ++){
            if(board[i][k] == 1 ){
                infect(board,i,k);
            }
        }
        for(int k = 0; k < board.length; k ++){
            if(board[k][j] == 1 ){
                infect(board,k,j);
            }
        }
    }
}
