import java.util.*;
public class NumberGuessingGame
{
	public static void main(String[] args) {
		System.out.println("         Hello Dear...Welcome To The World's Famous Number Guessing Game         ");
		System.out.println("                                Game Rules:-                                     ");
		System.out.println("         1)A Random Number From 1-100 Is Choosen By Me\n         2)You Need To Guess The Number    ");
		System.out.println("         Please Add Total Number Of Rounds You Want To Play                  ");
		try{
		Scanner sc=new Scanner(System.in);
		int roundsInGame=sc.nextInt();
		int numberOfAttemps=6;
		for(int i=0;i<roundsInGame;i++)
		{
		    System.out.println("Round:"+(i+1));
		    Random r=new Random();
		    int rN=r.nextInt(101);
		    System.out.println("   I Have Choosen A Random Number...Its Your Turn");
		    int userInput=sc.nextInt();
		    int f_score=letsPlayTheGame(rN,userInput,numberOfAttemps);
		    System.out.println("    Your score:"+f_score);
		}
		System.out.println("You Played Really Well...Thanks For Playing With Us...Have A Nice Day");
		}
		catch(InputMismatchException x)
		{
		    System.out.println("InputMismatchException Caught...");
		    System.out.println(x);
		    System.out.println("Please Enter Valid Number To Play The Game");
		}
	}
	public static int letsPlayTheGame(int rN,int userInput,int numberOfAttemps)
	{
	    int score=100;
		int t=0;
		Scanner sc=new Scanner(System.in);
		while(t<numberOfAttemps-1)
		{
		    if(userInput==rN)
		    {
		        System.out.println("Hurrah You Did It...You Did A Great Job."+" Your Score is");
		        return score;
		    }
		    else if(userInput<rN)
		    {
		        score=score-20;
		        System.out.println("You Entered Lower Number Than Generated Number...\"Go Up\"");
		        userInput=sc.nextInt();
		    }
		    else{
		        score=score-20;
		        System.out.println("You Entered Greater Number Than Generated Number...\"Go Down\"");
		        userInput=sc.nextInt();
		    }
		    t++;
		}
		    System.out.println("Limits are exceeded");
		return score;
	}
}
