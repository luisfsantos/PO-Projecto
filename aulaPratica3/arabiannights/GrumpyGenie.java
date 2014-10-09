package arabiannights;

public class GrumpyGenie extends Genie {

	public GrumpyGenie(int wishes){
		super(1);
	}

	
	public toString(){
		if (getGrantedWishes()) {
			System.out.println("Grumpy genie has granted a wish.");
		} else {
			System.out.println("Grumpy genie has  a wish to grant.");
		}
	}

}