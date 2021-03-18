
import java.util.Scanner;

public class Main {

    public static Node readNewNode(Scanner stdin) {
        int[] answer = new int[9];
        for(int i = 0; i < 9; i++) {
            answer[i] = stdin.nextInt();
        }
        return new Node(answer, 0);
    }

    public static void printPath(Node n) {
        Node cur = n;
        while(cur!=null) {
            Node.printTable(cur);
            cur = cur.father;
        }
    }
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        Node start = readNewNode(stdin);
        Node end = readNewNode(stdin);

        Graph g = new Graph(start, end);

        Node answer = g.DFS(g);
      //Node answer = g.BFS(g);
        //printPath(answer);
   } 
}
