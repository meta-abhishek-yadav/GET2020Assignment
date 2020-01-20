package assignment5;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;
public class TestNQueen {
	

		@Test
		public void NQueenForTrueCase()
		{
			NQueen nqueen=new NQueen();
			int i,j,n=4;
			int board[][]=new int[n][n];
			int index=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					board[i][j]=0;
				}
			}
			boolean result=nqueen.solution(board,n,index);
			assertEquals(true,result);
		}
		
		@Test
		public void NQueenForFalseCase()
		{
			NQueen nqueen=new NQueen();
			int i,j,n=3;
			int board[][]=new int[n][n];
			int index=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					board[i][j]=0;
				}
			}
			boolean result=nqueen.solution(board,n,index);
			assertEquals(false,result);

		}
		
		
		
	


}
