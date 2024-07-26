class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] hospital)
    {
        // Code here
         Queue<Pair>q=new LinkedList<>();
        int time=0;
        int n=hospital.length;
        int m=hospital[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hospital[i][j]==2){
                    q.add(new Pair(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            int curr=q.size();
            time++;
            while(curr!=0){
                curr--;
            Pair p=q.remove();
            int a=p.i;
            int b=p.j;
            if(a-1>=0){
                if(hospital[a-1][b]==1){
                    hospital[a-1][b]=2;
                    q.add(new Pair(a-1,b));
                }
            }
            if(a+1<n){
                if(hospital[a+1][b]==1){
                    hospital[a+1][b]=2;
                    q.add(new Pair(a+1,b));
                }
            }
            if(b+1<m){
                if(hospital[a][b+1]==1){
                    hospital[a][b+1]=2;
                    q.add(new Pair(a,b+1));
                }
            }
            if(b-1>=0){
                if(hospital[a][b-1]==1){
                    hospital[a][b-1]=2;
                    q.add(new Pair(a,b-1));
                }
            }
        }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(hospital[i][j]==1){
                    return -1;
                }
            }
        }
        if(time==0){
            return 0;
        }
        return time-1;
    }
}