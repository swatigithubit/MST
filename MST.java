class MST implements Comparable<MST>{
    int wt;
    int node;
    int par;
    public MST(int wt, int node, int par){
        this.wt = wt;
        this.node = node;
        this.par = par;
    }
    
    @Override
    public int compareTo(MST other) {
        return this.wt - other.wt;
    }
}


class Solution {
    static int FinParent(int u,int parent[]){
        if(u==parent[u]){
        return u;
        }
        return parent[u]=FinParent(parent[u],parent);
        
    }
    static void UnionByRank(int u,int v,int rank[],int parent[]){
        int pu=FinParent(u,parent);
        int pv=FinParent(v,parent);
        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }
        else if(rank[pu]<rank[pv]){
            parent[pu]=pv;
        }
        else{
            parent[pu]=pv;
            rank[pu]++;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<MST> q = new PriorityQueue<>();
        int cost =0;
        int parent[]=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
        int edges=0;
        int rank[]=new int[V];
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
           int v=adj.get(i).get(j)[0];
           int wt=adj.get(i).get(j)[1];
               q.add(new MST(wt, v, i)); 
            }
        }
        
        while(!q.isEmpty()){
            MST pair=q.remove();
            int weight=pair.wt;
            int u=pair.node;
            int v=pair.par;
            int pu=FinParent(u,parent);
            int pv=FinParent(v,parent);
            if(pu!=pv){
                cost+=weight;
                edges++;
                UnionByRank(u,v,rank,parent);
            }
            
            if(edges==V-1){
                break;
            }
        }
        return cost;
        
    }
}