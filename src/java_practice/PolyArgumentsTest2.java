package java_practice;

import java.util.ArrayList;

public class PolyArgumentsTest2 {

	public static class Product {
		int price;
		int bonusPoint;

		Product(int price) {
			this.price = price;
			bonusPoint = price / 10;
		}

	}

	public static class Tv extends Product {

		Tv(int price) {
			super(price);
		}
	}

	public static class Computer extends Product {

		Computer(int price) {
			super(price);
		}
	}

	public static class Audio extends Product {

		Audio(int price) {
			super(price);
		}
	}

	public static class Buyer {
		int money = 10000;
		int bonusPoint = 0;
		ArrayList<Product> products = new ArrayList<>();

		void buy(Product p) {
			if (money < p.price) {
				System.out.println("not enough money");
				return;
			}

			products.add(p);
			money -= p.price;
			bonusPoint += p.bonusPoint;
		}

		void summery(){
			int totalPrice = 0;
			StringBuffer stringBuffer = new StringBuffer();

			for(Product p : products){
				totalPrice+= p.price;
				stringBuffer.append(p.getClass().getSimpleName());
				stringBuffer.append(" "
					+ "");
			}
			System.out.println("총 구매 : " + totalPrice);
			System.out.println("총 구매목록 : " + stringBuffer.toString());
		}

	}

	public static void main(String[] args) {

		Buyer newBuyer = new Buyer();

		newBuyer.buy(new Computer(3000));
		newBuyer.buy(new Audio(1000));
		newBuyer.buy(new Tv(5000));

		newBuyer.summery();

	}
}
