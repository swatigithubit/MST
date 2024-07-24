JAVA SOLUTION /// KRUSHKAL ALGORITHM
THE code is so simple :

here we take two array 1: parents array ,2: rank array/size array

1: first we will find the ultimate parents of vertices u and v using findParent fxn

2: then we get to know the rank  connect the smaller one with the larger one.

3: for all this purpose we create the priority queue which stores the edges based on their increasing order of their wieght .

4: so first put all the edges in priority queue.

5: after that one by one get all the elements from priotirt queue and find ultimate parent then rank after that according to rank merge them , then reapeat till (edges!vertices-1); 

6: return cost.