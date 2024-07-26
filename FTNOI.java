class pair{
    int i;
    int j;
    public pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
          Queue<pair>q=new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;
        int num=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    num++;
                    q.add(new pair(i,j));
                    grid[i][j]='0';
                        while(!q.isEmpty()){
                            pair np=q.remove();
                             int a=np.i;
                             int b=np.j;
                if(a-1>=0){
                    if(grid[a-1][b]=='1'){
                    grid[a-1][b]='0';
                        q.add(new pair(a-1,b));
                    }
                }
                if(a+1<row){
                    if(grid[a+1][b]=='1'){
                        grid[a+1][b]='0';
                        q.add(new pair(a+1,b));
                    }
                }
                if(b-1>=0){
                    if(grid[a][b-1]=='1'){
                        grid[a][b-1]='0';
                        q.add(new pair(a,b-1));
                    }
                }
                if(b+1<col){
                    if(grid[a][b+1]=='1'){
                        grid[a][b+1]='0';
                        q.add(new pair(a,b+1));
                    }
                }
                if(b-1>=0 && a-1>=0){
                    if(grid[a-1][b-1]=='1'){
                        grid[a-1][b-1]='0';
                        q.add(new pair(a-1,b-1));
                    }
                }
                if(b+1<col && a-1>=0){
                    if(grid[a-1][b+1]=='1'){
                        grid[a-1][b+1]='0';
                        q.add(new pair(a-1,b+1));
                    }
                }
                if(b-1>=0 && a+1<row){
                    if(grid[a+1][b-1]=='1'){
                        grid[a+1][b-1]='0';
                        q.add(new pair(a+1,b-1));
                    }
                }
                 if(b+1<col && a+1<row){
                    if(grid[a+1][b+1]=='1'){
                        grid[a+1][b+1]='0';
                        q.add(new pair(a+1,b+1));
                    }
                }
                        }
                    }
                }
            }
            return num;
        }
    }

