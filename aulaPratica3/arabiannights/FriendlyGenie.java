package arabiannights;

public class FriendlyGenie extends Genie {

	public FriendlyGenie(int wishes){
		super(wishes);
	}

	
	public toString(){
		System.out.println("Friendly genie has granted" + getGrantedWishes() +
		 " wishes and still has" + getRemainingWishes() + " to grant.");
	}

}