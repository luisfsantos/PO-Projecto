package arabiannights;
/**
*Classe que implementa o FriendlyGenie que e' libertado quando a 
*esfregamos a lampada um numero impar de vezes.
*@see Genie
*/
public class GrumpyGenie extends Genie {
	/**
	*Constroe o GrumpyGenie com 1 desejo possivel, como na natureza dele.
	* @param wishes numero de desejos pedido ao Genie, embora seja ignorado.
	*/
	public GrumpyGenie(int wishes){
		super(1);
	}

	/**
	* Interface do GrumpyGenie para indicar se ja concedeu ou nao o pedido.
	* @return <code> String </code> que indica que tem um desejo que pode conceder. Em contrario
	*   indica que ja nao pode conceder mais desejos
	*/
	public String toString(){
		if (getGrantedWishes()!=0) {
			return "Grumpy genie has granted a wish.";
		} else {
			return "Grumpy genie has a wish to grant.";
		}
	}

}