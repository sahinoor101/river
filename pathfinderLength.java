class pathfinderLength
{
    public static void main(String args[])
    {
        pathfinderLength ob = new pathfinderLength();
        // int mat[][] = {{0, 0, 0, 1, 0}, {0, 1, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 1, 1,
        // 0, 0}, {0, 0, 1, 1, 1}};
        int mat[][] = { { 0, 0, 1, 1, 0, 1, 1, 0, 0, 0 },{ 0, 0, 0, 1, 0, 0, 1, 0, 0, 0 },{ 0, 1, 1, 1, 0, 0, 1, 1, 1, 1 },{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 1 },{ 1, 1, 0, 0, 0, 0, 0, 1, 1, 1 },{ 1, 0, 0, 0, 0, 0, 0, 1, 0, 0 },{ 1, 1, 1, 1, 0, 0, 0, 1, 1, 0 },{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 },{ 0, 0, 1, 1, 0, 0, 1, 1, 1, 0 },{ 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 } };
        int rows, cols, start, i, j,l1,l2;
        rows = mat.length;
        cols = mat[0].length;
        start = ob.start(mat);
        for (i = 0; i < rows; i++) 
        {
            for (j = 0; j < cols; j++) 
            {
                System.out.print(" " + mat[i][j]);
            }
            System.out.println();
        }
        l1=ob.length(cols-1, 2, mat, 1);
        l2=ob.length((cols - 1), start, mat, 1);
        if(l1>l2)
        {
            System.out.println("The first river is Lonegest");
        }
        else if(l1<l2)
        {
            System.out.println("The second river is Lonegest");
        }
        else
        {
            System.out.println("Both the rivers are of same length");
        }
        System.out.println(l1);
        System.out.println(l2);
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
    public boolean isValid(int x, int y, int mat[][]) 
    {
        return !(x < 0 || y < 0 || x >= mat.length || y >= mat[0].length);
    }
    public int length(int x, int y, int[][] mat, int count) 
    {
        pathfinderLength ob = new pathfinderLength();
        if (ob.isValid(x, y, mat) == false) {
            return -1;
        }
        if (ob.isValid(x + 1, y, mat) == true && mat[x + 1][y] == 1) {
            mat[x][y] =0;
            return length(x + 1, y, mat, count + 1);
        }
        if (ob.isValid(x - 1, y, mat) == true && mat[x - 1][y] == 1) {
            mat[x][y] = 0;
            return length(x - 1, y, mat, count + 1);
        }
        if (ob.isValid(x, y + 1, mat) == true && mat[x][y + 1] == 1) {
            mat[x][y] = 0;
            return length(x, y + 1, mat, count + 1);
        }
        if (ob.isValid(x, y - 1, mat) == true && mat[x][y - 1] == 1) {
            mat[x][y] = 0;
            return length(x, y - 1, mat, count + 1);
        }
        return count;
    }
}