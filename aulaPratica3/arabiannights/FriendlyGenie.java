package arabiannights;
/**
*Classe que implementa o FriendlyGenie que e' libertado quando a 
*lampada esta' contente.
*@see Genie.
*/
public class FriendlyGenie extends Genie {
	/**
	*Construtor de FriendlyGenie.
	*@param Recebe o nu'mero de desejos que o Genie podera' conceber.
	*/
	public FriendlyGenie(int wishes){
		super(wishes);
	}

	/**
	*Interface do FriendlyGenie que indica quantos desejos realizou
	*e quantos ainda pode realizar.
	*@return String a indicar desejos realizados e disponi'veis.
	*/
	public String toString(){
		return "Friendly genie has granted" + getGrantedWishes() +
		" wishes and still has" + getRemainingWishes() + " to grant.";
	}

}