class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int indegree[]=new int [V];
        Arrays.fill(indegree,0);
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
            int v=adj.get(i).get(j);
            indegree[v]++;
            }
        }
    
    int k=0;
    for(int i=0;i<V;i++){
        if(indegree[i]==0){
            k=i;
            break;
        }
    }
    Queue<Integer>q=new LinkedList<>();
    boolean  visited[]=new boolean[V];
    visited[k]=true;
    q.add(k);
    int topo[]=new int[V];
    int j=0;
    while(!q.isEmpty()){
        int b=q.remove();
        topo[j]=b;
        j++;
        for(int i=0;i<adj.get(b).size();i++){
            int d=adj.get(b).get(i);
            indegree[d]--;
        }
        for(int i=0;i<indegree.length;i++){
           if(indegree[i]==0 && visited[i]!=true){
                k=i;
                visited[k]=true;
                q.add(k);
            }
        }
    }
        return topo;
        
    }
}
