class pathFinderS
{
    public static void main(String args[]) 
    {
        pathFinderS ob = new pathFinderS();
        int mat[][] ={{0,0,0,0,1,0},{1,1,1,1,1,0},{1,0,0,0,0,0},{1,0,1,1,1,0},{1,0,1,0,0,0},{1,1,1,0,0,0}};
        int rows, cols, i, j;
        rows = mat.length;
        cols = mat[0].length;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
        System.out.println(3 + "," + 4);
        ob.path(3, 4, mat);
    }
    public boolean isValid(int x, int y, int mat[][]) 
    {
        return !(x < 0 || y < 0 || x >= mat.length || y >= mat[0].length);
    }
    public void path(int x, int y, int[][] mat) {
        pathFinderS ob = new pathFinderS();
        if (ob.isValid(x, y, mat) == false) {
            return;
        }
        if (ob.isValid(x + 1, y, mat) == true && mat[x + 1][y] == 1) {
            mat[x][y] = 0;
            System.out.println((x + 1) + "," + y);
            path(x + 1, y, mat);
        }
        if (ob.isValid(x - 1, y, mat) == true && mat[x - 1][y] == 1) {
            mat[x][y] = 0;
            System.out.println((x - 1) + "," + y);
            path(x - 1, y, mat);
        }
        if (ob.isValid(x, y + 1, mat) == true && mat[x][y + 1] == 1) {
            mat[x][y] = 0;
            System.out.println(x + "," + (y + 1));
            path(x, y + 1, mat);
        }
        if (ob.isValid(x, y - 1, mat) == true && mat[x][y - 1] == 1) {
            mat[x][y] = 0;
            System.out.println(x + "," + (y - 1));
            path(x, y - 1, mat);
        }
    }
}
