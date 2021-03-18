
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Graph {
   Node start;
   Node goal;
   LinkedList<Node> frontier;
   HashMap<String, Node> explored;

   public Graph(Node start, Node goal) {
       this.start = start;
       this.goal  =  goal;
       frontier = new LinkedList<>();
       explored = new HashMap<>();
   }

   public void expand(Node n) {
      int line = n.missingPiece/3;
      int col  = n.missingPiece%3;

      int moveDown  = n.missingPiece-3;
      int moveUp    = n.missingPiece+3;
      int moveLeft  = n.missingPiece-1;
      int moveRight = n.missingPiece+1;
      
      if(line < 2) {
        int[] nextMap = Arrays.copyOf(n.table, 9);
       // System.out.println("Can move down! Missingpiece: " + n.missingPiece);
        nextMap[n.missingPiece] = nextMap[moveUp];
        nextMap[moveUp] = 0;
        String nextMapString = Node.tableToText(nextMap);
        Node nextMove = new Node(nextMap, nextMapString, n.height + 1, n);
        if(!frontier.contains(nextMove) && explored.get(nextMapString) == null)
            frontier.add(nextMove);
      }
  
      if(line > 0) {
        int[] nextMap = Arrays.copyOf(n.table, 9);
       // System.out.println("Can move up! Missingpiece: " + n.missingPiece);
        nextMap[n.missingPiece] = nextMap[moveDown];
        nextMap[moveDown] = 0;
        String nextMapString = Node.tableToText(nextMap);
        Node nextMove = new Node(nextMap, nextMapString, n.height + 1, n);
        if(!frontier.contains(nextMove) && explored.get(nextMapString) == null)
            frontier.add(nextMove);
      }
  
      if(col  < 2) {
        int[] nextMap = Arrays.copyOf(n.table, 9);
      //  System.out.println("Can move right! Missingpiece: " + n.missingPiece);
        nextMap[n.missingPiece] = nextMap[moveRight];
        nextMap[moveRight] = 0;
        String nextMapString = Node.tableToText(nextMap);
        Node nextMove = new Node(nextMap, nextMapString, n.height + 1, n);
        if(!frontier.contains(nextMove) && explored.get(nextMapString) == null)
            frontier.add(nextMove);
 
      }
  
      if(col  > 0) {
        int[] nextMap = Arrays.copyOf(n.table, 9);
       // System.out.println("Can move left! Missingpiece: " + n.missingPiece);
        nextMap[n.missingPiece] = nextMap[moveLeft];
        nextMap[moveLeft] = 0;
        String nextMapString = Node.tableToText(nextMap);
        Node nextMove = new Node(nextMap, nextMapString, n.height + 1, n);
        if(!frontier.contains(nextMove) && explored.get(nextMapString) == null)
            frontier.add(nextMove);
 
      }
  
   }

    public Node DFS(Graph g) {
       frontier.add(g.start);
       while(!frontier.isEmpty()) {
          // System.out.println("frontier size: " + frontier.size());
           Node cur = frontier.pollLast();
           //Node.printTable(cur);
           if(cur.equals(g.goal)){
               System.out.println("found it at " + cur.height);
               return cur;
           }
           explored.put(cur.tableString, cur);
           expand(cur);
       } 
       return null;
    }

    public Node BFS(Graph g) {
       frontier.add(g.start);
       while(!frontier.isEmpty()) {
          // System.out.println("frontier size: " + frontier.size());
           Node cur = frontier.pollFirst();
           //Node.printTable(cur);
           if(cur.equals(g.goal)){
               System.out.println("found it at " + cur.height);
               return cur;
           }
           explored.put(cur.tableString, cur);
           expand(cur);
       } 
       return null;
   }
}
