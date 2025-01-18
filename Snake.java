package snake;
import java.util.*;

public class Snake {
	private char[][] board=null;
	Queue<Node> queue=new LinkedList<Node>();
	
	Snake(int row,int col)
	{
		this.board=new char[row][col];
		this.queue.add(new Node(0,0));
		this.board[0][2]='x';
		this.board[2][3]='x';
		this.board[3][1]='x';
		this.board[0][5]='x';
		this.board[5][5]='x';
		this.board[5][0]='x';
		
	}
	
	public void snakeMove(int row,int col)
	{
		if(row>=0 && col>=0 && row<board.length && col<board.length)
		{
			if(board[row][col]=='.') {
				System.out.println("<<<<GAME OVER>>>>>");
				System.exit(0);
				}
			queue.add(new Node(row,col));
			if(board[row][col]!='x')
			{
				Node node=queue.poll();
				int r=node.getRow();
				int c=node.getColumn();
				board[r][c]='\0';
			}
			board[row][col]='.';
			while(!queue.isEmpty()){
				printSnake();
				Scanner scan=new Scanner(System.in);
				System.out.print("Enter Direction:");
				char direction=scan.next().toUpperCase().charAt(0);
				if(direction=='U')
					snakeMove(--row,col);
				if(direction=='D')
					snakeMove(++row,col);
				if(direction=='R')
					snakeMove(row,++col);
				if(direction=='L')
					snakeMove(row,--col);
				}
			}
		else {
			System.out.println("Invalid Move");
			System.exit(0);
			}
		}
	public void printSnake()
	{
		for(char[] ch:board)
		{
			for(int j=0;j<board[0].length;j++)
			{
				System.out.print(ch[j]+" ");
			}
			System.out.println();
		}
	}
}
