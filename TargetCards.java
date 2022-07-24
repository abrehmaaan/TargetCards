import java.util.Random;
import java.util.Scanner;

public class TargetCards {
	public void shuffle(int[] list) {
		int totalElements = list.length;
		// initialize random number generator
		Random random = new Random();
		for (int i = 0; i < totalElements; i++) {
		   // get the list element at current index
		   int currentElement = list[i];
		   // generate a random index within the range of list size
		   int randomIndex = i + random.nextInt(totalElements - i);
		   // set the element at current index with the element at random
		   // generated index
		   // set the element at random index with the element at current loop
		   // index
		   int temp = list[i];
		   list[i] = list[randomIndex];
		   list[randomIndex] = temp;
		}
	}
	public static void main(String[] args) {
		//11 = ACE
		//12 = JACK
		//13 = QUEEN
		//14 = KING
		int[] deck = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14 };
		TargetCards tc = new TargetCards();
		int target = 51;
		Scanner sc = new Scanner(System.in);
		int[] P1Scores = {0,0,0,0};
		int[] P2Scores = {0,0,0,0};
		for(int i = 1; i <= 4; i++) {
			tc.shuffle(deck);
			System.out.println("GAME "+i+":");
			Stack P1 = new LinkedStack();
			Stack P2 = new LinkedStack();
			int P1Cards, P2Cards;
			if(i%2!=0) {
				System.out.println("Player 1 has 1st guess");
				System.out.print("Guess the number of cards: ");
				P1Cards = sc.nextInt();
				for(int j = 0; j<P1Cards;j++) {
					P1.push(deck[j]);
				}
				System.out.println("Player 1 has guessed "+P1Cards+" cards.");
				tc.shuffle(deck);
				System.out.println("Player 2 has 2nd guess");
				System.out.print("Guess the number of cards: ");
				P2Cards = sc.nextInt();
				for(int j = 0; j<P2Cards;j++) {
					P2.push(deck[j]);
				}
				System.out.println("Player 2 has guessed "+P2Cards+" cards.");
			}
			else {
				System.out.println("Player 2 has 1st guess");
				System.out.print("Guess the number of cards: ");
				P2Cards = sc.nextInt();
				for(int j = 0; j<P2Cards;j++) {
					P2.push(deck[j]);
				}
				System.out.println("Player 2 has guessed "+P2Cards+" cards.");
				tc.shuffle(deck);
				System.out.println("Player 1 has 2nd guess");
				System.out.print("Guess the number of cards: ");
				P1Cards = sc.nextInt();
				for(int j = 0; j<P1Cards;j++) {
					P1.push(deck[j]);
				}
				System.out.println("Player 1 has guessed "+P1Cards+" cards.");
			}
			int P1Sum = 0;
			int P2Sum = 0;
			int P1Score, P2Score;
			boolean P1Ace = false;
			boolean P2Ace = false;
			System.out.print("Player 1: ");
			while(!P1.isEmpty()) {
				if(P1.peek()==11) {
					System.out.print("A ");
					P1Sum+=11;
					P1Ace = true;
				}
				else if(P1.peek()==12) {
					System.out.print("J ");
					P1Sum+=10;
				}
				else if(P1.peek()==13) {
					System.out.print("Q ");
					P1Sum+=10;
				}
				else if(P1.peek()==14) {
					System.out.print("K ");
					P1Sum+=10;
				}
				else {
					System.out.print(P1.peek()+" ");
					P1Sum+=P1.peek();
				}
				P1.pop();
			}
			if(P1Sum > target) {
				if(P1Ace) {
					P1Sum -= 10;
				}
			}
			P1Score = target - P1Sum;
			if(P1Score<0) {
				P1Score = target;
			}
			System.out.println("\tSum = "+P1Sum+" Score = "+P1Score);
			System.out.print("Player 2: ");
			while(!P2.isEmpty()) {
				if(P2.peek()==11) {
					System.out.print("A ");
					P2Sum+=11;
					P2Ace = true;
				}
				else if(P2.peek()==12) {
					System.out.print("J ");
					P2Sum+=10;
				}
				else if(P2.peek()==13) {
					System.out.print("Q ");
					P2Sum+=10;
				}
				else if(P2.peek()==14) {
					System.out.print("K ");
					P2Sum+=10;
				}
				else {
					System.out.print(P2.peek()+" ");
					P2Sum+=P2.peek();
				}
				P2.pop();
			}
			if(P2Sum > target) {
				if(P2Ace) {
					P2Sum -= 10;
				}
			}
			P2Score = target - P2Sum;
			if(P2Score<0) {
				P2Score = target;
			}
			System.out.println("\tSum = "+P2Sum+" Score = "+P2Score);
			P1Scores[i-1] = P1Score;
			P2Scores[i-1] = P2Score;
		}
		int P1Total = 0;
		int P2Total = 0;
		for(int i = 0; i < 4; i++) {
			P1Total+=P1Scores[i];
			P2Total+=P2Scores[i];
		}
		System.out.println("Player 1 total is "+ P1Total);
		System.out.println("Player 2 total is "+ P2Total);
		if(P1Total<P2Total) {
			System.out.println("Player 1 wins!");
		}
		else if(P1Total>P2Total) {
			System.out.println("Player 2 wins!");
		}
		else {
			System.out.println("Game Draw!");
		}
	}

}
