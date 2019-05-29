package Algorithm.PAT.B;
import java.util.*;

public class Floyd {
    public static int[][] path;
    public static int[][] floyd(int[][] C,int n)
    {
        path=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                path[i][j]=-1;
            }
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(C[i][k]!=Integer.MAX_VALUE&&C[k][j]!=Integer.MAX_VALUE&&C[i][k]+C[k][j]<C[i][j])
                    {
                        C[i][j]=C[i][k]+C[k][j];
                        path[i][j]=k;
                    }

                }
            }
        }
        return C;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a=Integer.MAX_VALUE;
        int[][] C= {{0,a,10,a,30,100},{a,0,5,a,a,a},{a,a,0,50,a,a},{a,a,a,0,a,10},
                {a,a,a,20,0,60},{a,a,a,a,a,0}};
        int n=C.length;
        int[][] route=floyd(C,n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j) continue;
                else if(route[i][j]==a)
                    System.out.println(i+"到"+j+"之间没路径");
                else
                    System.out.println(i+"到"+j+"之间的最短路径长度为："+route[i][j]);
            }
        }

    }

}
