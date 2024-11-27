
class pathFinderM {

    public static void main(String args[]) {
        pathFinderM ob = new pathFinderM();
        // int mat[][] = {{0, 0, 0, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 1, 1,
        // 0, 0}, {0, 0, 1, 1, 1}};
        int mat[][] = { { 0, 0, 1, 1, 0, 0, 1, 0, 0, 0 },{ 0, 0, 0, 1, 0, 0, 1, 0, 0, 0 },{ 0, 1, 1, 1, 0, 0, 1, 1, 1, 1 },{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },{ 1, 1, 0, 0, 0, 0, 0, 1, 1, 1 },{ 1, 0, 0, 0, 0, 0, 0, 1, 0, 0 },{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 0 },{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },{ 0, 0, 1, 1, 0, 0, 1, 1, 1, 0 },{ 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 } };
        int rows, cols, start, i, j;
        rows = mat.length;
        cols = mat[0].length;
        start = ob.start(mat);
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
        System.out.println((cols - 1) + "," + 2);
        ob.path(cols-1, 2, mat, 1);
        System.out.println("");
        System.out.println((cols - 1) + "," + start);
        ob.path((cols - 1), start, mat, 1);
    }

    public int start(int mat[][]) {
        int rows, cols;
        rows = mat.length;
        cols = mat[0].length;
        for (int i = (cols - 1); i > 0; i--) {
            if (mat[(rows - 1)][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int end(int mat[][]) {
        int rows;
        rows = mat.length;
        for (int i = 0; i < rows; i++) {
            if (mat[0][i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public boolean isValid(int x, int y, int mat[][]) {
        int rows, cols;
        rows = mat.length;
        cols = mat[0].length;
        return !(x < 0 || y < 0 || x >= rows || y >= cols);
    }

    public void path(int x, int y, int[][] mat, int count) {
        pathFinderM ob = new pathFinderM();

        if (ob.isValid(x, y, mat) == false) {
            return;
        }
        if (ob.isValid(x + 1, y, mat) == true && mat[x + 1][y] == 1) {
            mat[x][y] = 0;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println((x + 1) + "," + y);
            path(x + 1, y, mat, count + 1);
        }
        if (ob.isValid(x - 1, y, mat) == true && mat[x - 1][y] == 1) {
            mat[x][y] = 0;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println((x - 1) + "," + y);
            path(x - 1, y, mat, count + 1);
        }
        if (ob.isValid(x, y + 1, mat) == true && mat[x][y + 1] == 1) {
            mat[x][y] = 0;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println(x + "," + (y + 1));
            path(x, y + 1, mat, count + 1);
        }
        if (ob.isValid(x, y - 1, mat) == true && mat[x][y - 1] == 1) {
            mat[x][y] = 0;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println(x + "," + (y - 1));
            path(x, y - 1, mat, count + 1);
        }
    }
}