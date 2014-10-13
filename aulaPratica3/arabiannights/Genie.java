package arabiannights;
/**
*Classe que define Genie, Superclasse abstrata.
*@see FriendlyGenie.
*@see GrumpyGenie.
*@see RecyclableGenie.
*/
abstract class Genie {
	private int _wishes;
	private int _wishesGranted;
	/**
	*Construto'i Genie com o nu'mero de desejdos desejado e 
	*inicializa _wishesGranted a 0.
	*@param Recebe o nu'mero de desejos que pode realizar e ignora
	*_wishesGranted.
	*/
	public Genie(int wishes){
		_wishes = wishes;
	}
	/**
	*Incrementa o contador de desejos realizados.
	*/
	protected void incrWishesGranted () {
		_wishesGranted+=1;
	}
	/**
	*Realiza um desejo incrementando os desejos realizados.
	*@return <code>true</code> se o desejo for realizado e 
	*<code>false</code> se nao for.
	*/
	public boolean grantWish(){
		if ((_wishes - _wishesGranted)>0){
			_wishesGranted+=1;
			return true;
		}
		return false;
	}
	/**
	*Devolve o valor do contador de desejos realizados.
	*@return Devolve o valor do contador de desejos realizados.
	*/
	public int getGrantedWishes(){
		return _wishesGranted;
	}
	/**
	*Devolve o nu'mero de desejos que ainda pode ser realizados.
	*@return Devolve o nu'mero de desejos que ainda pode ser 
	*realizados.
	*/
	public int getRemainingWishes(){
		return (_wishes - _wishesGranted);
	}
	/**
	*Verifica se o Genie pode realizar desejos.
	*@return <code>true</code> se poder realizar desejos e 
	*<code>false</code> se nao poder.
	*/
	public boolean canGrantWish() {
		if (getRemainingWishes()==0) {
			return false;
		} else {
			return true;
		}
	}
	/**
	*Interface do Genie, a ser definido pelas subClasses.
	*/ 
	public abstract String toString();
}