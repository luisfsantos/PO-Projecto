package arabiannights;

public class GrumpyGenie extends Genie {

	public GrumpyGenie(int wishes){
		super(1);
	}

	
	public String toString(){
		if (getGrantedWishes()!=0) {
			System.out.println("Grumpy genie has granted a wish.");
			return "Grumpy genie has granted a wish.";
		} else {
			System.out.println("Grumpy genie has a wish to grant.");
			return "Grumpy genie has a wish to grant.";
		}
	}

}