package arabiannights;
/**
*RecyclableDemon e' a classe que define o Demon libertado pela MagicLamp quando esta fica sem genios.
*@see Genie
*/
public class RecyclableDemon extends Genie {
	private boolean _recycled;

	/**
	*Constroe RecyclableDemon com o numero de wishes a -1 pois tem numero ilimitado.
	*@param int wishes, indica o numero de desejos que o Demon pode realizar embora seja ignorado.
	*/
	public RecyclableDemon(int wishes) {
		super(-1); //wishes e' ignorado, recyclabledemon tem desejos ilimitados
	}

	/**
	* Realiza um desejo.
	*<p>O desejo so e' realizado se o Demon ainda nao estiver reciclado.
	*@return <code> true </code> caso o desejo seja realizado e
	* <code> false </code> caso contrario.
	*/
	@Override
	public boolean grantWish() {
		if(_recycled) {
			return false;
		} else {
			incrWishesGranted();
			return true;
		}
	}

	/**
	*Verifica se e' possivel realizar um desejo.
	*@return <code> true </code> caso o desejo possa ser realizado e <code> false </code> caso contrario.
	*/
	@Override
	 public boolean canGrantWish(){
	 	return !_recycled();
	 }

	 /**
	 *Verifica se o demonio foi reciclado ou nao.
	 *@return   <code> true </code> caso foi reciclado e <code> false </code> caso contrario.
	 */
	public  boolean recycled(){
		return _recycled;
	}

	/**
	*Recicla o demonio o qual ja nao pode realizar desejos.
	*/
	public void recycle(){
		_recycled = true;
	}

	/**
	* Interface do RecyclableDemon para indicar o numero de desejos realizados ou se foi reciclado
	* @return <code> String </code> que indica se foi reciclado. Em contrario
	*   indica o numero de desejos realizados.
	*/
	public String toString(){
		if (_recycled) {
			return "Demon has been recycled.";
		} else {
			return "Recyclable demon has granted" + getGrantedWishes() + " wishes.";
		}
	}
}
