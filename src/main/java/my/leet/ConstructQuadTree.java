package my.leet;

/** 427. 建立四叉树 */
public class ConstructQuadTree {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    static Node retrieve(int[][] grid, int i, int j, int l) {
        if (l==1) return new Node(grid[i][j]==1, true);
        Node leftUp = retrieve(grid, i, j, l/2);
        Node leftDown = retrieve(grid, i+l/2, j, l/2);
        Node rightUp = retrieve(grid, i, j+l/2, l/2);
        Node rightDown = retrieve(grid, i+l/2, j+l/2, l/2);
        if ((leftUp.val==leftDown.val && leftDown.val==rightUp.val && rightUp.val==rightDown.val) &&
                (leftUp.isLeaf && leftDown.isLeaf && rightUp.isLeaf && rightDown.isLeaf)) {
            return new Node(leftUp.val, true);
        }
        Node node = new Node(false, false);
        node.topLeft = leftUp;
        node.topRight = rightUp;
        node.bottomLeft = leftDown;
        node.bottomRight = rightDown;
        return node;
    }

    static Node func(int[][] grid) {
        return retrieve(grid, 0, 0, grid.length);
    }

    public static void main(String[] args) {
//        int[][] grid = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0},
//                {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
        int[][] grid = {{1,1,0,0},{0,0,1,1},{1,1,0,0},{0,0,1,1}};
        Node node = func(grid);
        System.out.println(node);
    }
}
