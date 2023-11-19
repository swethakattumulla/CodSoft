//NUMBER GAME
import java.util.Scanner;
public class numberGame
{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int chances=8;
        int finals=0;
        boolean playAgain=true;
        System.out.println("Welcome!");
        System.out.println("You have about  "+chances+"  to win the game");
        while(playAgain){
        int rand = getrandN(1,100);
        boolean guess=false;
        for(int i=0;i<chances;i++){
             System.out.println("chance"+(i+1)+" Enter your guess:");
            int user=sc.nextInt(); 
            if(user==rand) {
                guess=true;
                finals+=1;
            System.out.println("Y0u Won it");
        break;
        }
        else if(user>rand) {
            System.out.println("Too High");
        }
        else
        {
            System.out.println("Too L0w");
        }
        }
        if(guess==false) {
            System.out.println("Sorry.You lost the chances.The number is "+rand);
        }
        System.out.println("Do you want to play Again(Yes/No)");
        String PA=sc.next();
        playAgain=PA.equalsIgnoreCase("y");
    }
    System.out.println("Hope you enjoyed it");
    System.out.println("Here is your Score"+finals); }
    public static int getrandN(int min,int max)
    {
        return(int)(Math.random()*(max-min+1)+min);
    }
}

 
    

