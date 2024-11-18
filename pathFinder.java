import java.util.*;
class pathFinder
{
    public static void main(String args[])
    {
        pathFinder ob=new pathFinder();
        int mat[][]={{0,0,0,1,0},{0,1,1,1,0},{0,1,0,0,0},{0,1,1,0,0},{0,0,1,1,0}};
        int rows,cols,start,i,j;
        rows=mat.length;
        cols=mat[0].length;
        start=ob.start(mat);
        System.out.println((cols-1)+","+start);
        for(i=0;i<rows;i++)
        {
            for(j=0;j<cols;j++)
            {
                System.out.print(" "+mat[i][j]);
            }
            System.out.println();
        }
        ob.path((cols-1),start,mat);
    }
    public int start(int mat[][])
    {
        int rows,cols;
        rows=mat.length;
        cols=mat[0].length;
        for(int i=(cols-1);i>0;i--)
        {
            if(mat[(rows-1)][i]==1)
            {
                return i;
            }
        }
        return -1;
    }
    public boolean isValid(int x,int y,int mat[][])
    {
        int rows,cols;
        rows=mat.length;
        cols=mat[0].length;
        if(x<0 || y<0 || x>= rows || y>=cols)
        {
            return false;
        }
        return true;   
    }
    public void path(int x,int y,int [][]mat)
    {
        int arr[]={-1,-1,-1,-1,-1,-1,-1,-1};
        pathFinder ob=new pathFinder();
        if(ob.isValid(x,y,mat) ==false)
        {
            return ;
        }
        if(ob.isValid(x+1,y,mat) == true && mat[x+1][y]==1)
        {
            mat[x][y]=0;
            System.out.println((x+1)+","+y);
            path(x+1,y,mat);
        }
        if(ob.isValid(x-1,y,mat)== true && mat[x-1][y]==1)
        {
            mat[x][y]=0;
            System.out.println((x-1)+","+y);
            path(x-1,y,mat);
        }
        if(ob.isValid(x,y+1,mat)== true && mat[x][y+1]==1)
        {
            mat[x][y]=0;
            System.out.println(x+","+(y+1));
            path(x,y+1,mat);
        }
        if(ob.isValid(x,y-1,mat)== true && mat[x][y-1]==1)
        {
            mat[x][y]=0;
            System.out.println(x+","+ (y-1));
            path(x,y-1,mat);
        }
    }
}
