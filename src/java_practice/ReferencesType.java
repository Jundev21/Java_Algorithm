package java_practice;

public class ReferencesType {

	public static class Card{
		static int width;
		static int height;
		String color;
		int cardNumber;

	}

	public static void main(String[] args) {

		Card a = new Card();
		a.color = "yellow";
		a.cardNumber = 10;
		a.width = 20;
		a.height = 30;

		Card b = new Card();
		b.color = "brown";
		b.cardNumber = 20;

		ReferencesType getIncetence = new ReferencesType();

		Card copiedCard = getIncetence.copyCard(b);

		b.color = "dark brown";
		System.out.println(copiedCard.color);


	}


	public Card copyCard(Card card){
		Card temp = new Card();
		temp = card;
		return temp;
	}

}
