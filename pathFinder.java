class pathFinder {

    public static void main(String args[]) {
        pathFinder ob = new pathFinder();
        int mat[][] = {{0, 0, 0, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 1, 1, 1}};
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
        System.out.println((cols - 1) + "," + start);
        ob.path((cols - 1), start, mat, 1,start);
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
    public int end(int mat[][])
    {
        int rows;
        rows = mat.length;
        for (int i = 0; i<rows; i++) {
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
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return false;
        }
        return true;
    }

    public void path(int x, int y, int[][] mat, int count,int st) {
        pathFinder ob = new pathFinder();
        int rows, cols, i, j;
        rows = mat.length;
        cols = mat[0].length;
        if (ob.isValid(x, y, mat) == false) {
            return;
        }

        if (count == 2) {
            mat[rows-1][st] = 1;
        }
        if (ob.isValid(x + 1, y, mat) == true && mat[x + 1][y] == 1) {
            mat[x][y] = count;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println((x + 1) + "," + y);
            path(x + 1, y, mat, count + 1,st);
        }
        if (ob.isValid(x - 1, y, mat) == true && mat[x - 1][y] == 1) {
            mat[x][y] = count;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println((x - 1) + "," + y);
            path(x - 1, y, mat, count + 1,st);
        }
        if (ob.isValid(x, y + 1, mat) == true && mat[x][y + 1] == 1) {
            mat[x][y] = count;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println(x + "," + (y + 1));
            path(x, y + 1, mat, count + 1,st);
        }
        if (ob.isValid(x, y - 1, mat) == true && mat[x][y - 1] == 1) {
            mat[x][y] = count;
            if (count == 1) {
                mat[x][y] = 0;
            }
            System.out.println(x + "," + (y - 1));
            path(x, y - 1, mat, count + 1,st);
        }
        if (x==0 && y==ob.end(mat)) 
        {
            mat[0][y]=count;
            for (i = 0; i < rows; i++) {
                for (j = 0; j < cols; j++) {
                    System.out.print(" " + mat[i][j]);
                }
                System.out.println();
            }
        }
    }
}
