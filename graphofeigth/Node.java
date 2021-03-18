
class Node {
    int[] table;
    String tableString;
    Node father;
    int height;
    int heuristic;
    int missingPiece;

    Node(int[] table, int height) {
        this.table = table;
        this.tableString = tableToText(table);
        this.height = height;
        this.father = null;
        this.missingPiece = findMissingPiece(table);
    }

    Node(int[] table, String tableString, int height) {
        this.table = table;
        this.tableString = tableString;
        this.height = height;
        this.father = null;
        this.missingPiece = findMissingPiece(table);
    }

    Node(int[] table, String tableString, int height, Node father) {
        this.table = table;
        this.tableString = tableString;
        this.height = height;
        this.father = father;
        this.missingPiece = findMissingPiece(table);
    }

    public boolean equals(Node n) {
        if (this == n) return true;
        return this.tableString.equals(n.tableString);
    }

    public int compareTo(Node n) {
        if (this.heuristic > n.heuristic) return +1;
        if (this.heuristic < n.heuristic) return -1;
        return 0;
    }

    public static String tableToText(int[] table) {
        String ans = "";
        for(int i = 0; i < table.length; i++){
            ans += table[i];
        }
        return ans;
    }

    public int findMissingPiece(int[] table) {
        int pos = -1;
        for(int i = 0; i < table.length; i++)
            if(table[i]==0) pos = i;
        return pos;
    }

    public static void printTable(Node n) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(" " + n.table[3*i+j]);
            }
            System.out.println();
        }
        //System.out.println("The missing piece is in " + n.missingPiece);
        //System.out.println("We're " + n.height + " steps away from start.");
        System.out.println("-------------");
    }

}
