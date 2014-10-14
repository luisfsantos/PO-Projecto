//package arabiannights;
import arabiannights.*;


public class ArabianNights{

		public static void main(String[] args){
		MagicLamp arrabia = new MagicLamp(4);
		Genie alibaba1 = arrabia.rub(2);
		Genie alibaba2 = arrabia.rub(3);
		Genie alibaba3 = arrabia.rub(4);
		Genie alibaba4 = arrabia.rub(5);
		Genie alibaba5 = arrabia.rub(1);
		System.out.println(alibaba1.toString());
		System.out.println(alibaba2.toString());
		System.out.println(alibaba3.toString());
		System.out.println(alibaba4.toString());
		System.out.println(alibaba5.toString());

		alibaba1.grantWish();
		alibaba2.grantWish();
		alibaba3.grantWish();
		alibaba4.grantWish();
		alibaba5.grantWish();

		System.out.println(alibaba1.toString());
		System.out.println(alibaba2.toString());
		System.out.println(alibaba3.toString());
		System.out.println(alibaba4.toString());
		System.out.println(alibaba5.toString());

		alibaba1.grantWish();
		alibaba2.grantWish();
		alibaba3.grantWish();
		alibaba4.grantWish();
		alibaba5.grantWish();

		System.out.println(alibaba1.toString());
		System.out.println(alibaba2.toString());
		System.out.println(alibaba3.toString());
		System.out.println(alibaba4.toString());
		System.out.println(alibaba5.toString());

		arrabia.feedDemon((RecyclableDemon) alibaba5);
		System.out.println(alibaba5.canGrantWish());
		System.out.println(alibaba5.toString());
		Genie alibaba6 = arrabia.rub(7);

		System.out.println(alibaba6.toString());
	}

}