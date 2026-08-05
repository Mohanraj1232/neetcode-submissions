
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        Queue<int[]> que = new LinkedList<>();

        for(int row = 0; row < R; row++){
            for(int col = 0; col < C; col++){
                if(grid[row][col] == 0){
                    que.offer(new int[] {row ,col ,0});
                }
            }
        }


        while(!que.isEmpty()){
            int []cur = que.poll();
            int row = cur[0];
            int col = cur[1];
            int moves = cur[2];

            //if(grid[row][col] != Integer.MAX_VALUE) continue;

            int diffs[][] = {{1 ,0} ,{-1 ,0} ,{0 ,1} ,{0 , -1}};

            for(int adj[] : diffs){
                int adjRow = row + adj[0];
                int adjCol = col + adj[1];

                if(checkBounds(R ,C ,adjRow ,adjCol) && grid[adjRow][adjCol] != -1 && grid[adjRow][adjCol] == 2147483647){
                    grid[adjRow][adjCol] = moves + 1;
                    que.offer(new int[] {adjRow ,adjCol ,moves + 1});
                }

            }
        }
    }

    private boolean checkBounds(int R ,int C ,int row ,int col){
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}
