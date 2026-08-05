class Solution {
    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int fresh = 0;
        Queue<int[]> que = new LinkedList<>();

        for(int row = 0; row < R; row++){
            for(int col = 0; col < C; col++){
                if(grid[row][col] == 2){
                    que.offer(new int[]{row ,col});
                }else if(grid[row][col] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int res = 0;

        while(!que.isEmpty()){
            int size = que.size();

            while(size-- > 0){
                int []cur = que.poll();

                int row = cur[0];
                int col = cur[1];

                int diffs[][] = {{1 ,0} ,{-1 ,0} ,{0 ,1} ,{0 , -1}};

                for(int adj[] : diffs){
                    int adjRow = row + adj[0];
                    int adjCol = col + adj[1];

                    if(checkBounds(R ,C ,adjRow ,adjCol) && grid[adjRow][adjCol] == 1){
                        grid[adjRow][adjCol] = -1;
                        fresh--;
                        if(fresh == 0) return res + 1;
                        que.offer(new int[] {adjRow ,adjCol});
                    }

                }
            }

            res++;
        }

        return -1;
    }

     private boolean checkBounds(int R ,int C ,int row ,int col){
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}
