package arabiannights;
/**

*/
public class GrumpyGenie extends Genie {

	public GrumpyGenie(int wishes){
		super(1);
	}

	
	public String toString(){
		if (getGrantedWishes()!=0) {
			return "Grumpy genie has granted a wish.";
		} else {
			return "Grumpy genie has a wish to grant.";
		}
	}

}