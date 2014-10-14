//package arabiannights;
import arabiannights.*;


public class ArabianNights{

		public static void main(String[] args){
		MagicLamp arrabia = new MagicLamp(4);
		Genie alibaba1 = arrabia.Rub(2);
		Genie alibaba2 = arrabia.Rub(3);
		Genie alibaba3 = arrabia.Rub(4);
		Genie alibaba4 = arrabia.Rub(5);
		Genie alibaba5 = arrabia.Rub(1);
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
		Genie alibaba6 = arrabia.Rub(7);

		System.out.println(alibaba6.toString());
	}

}