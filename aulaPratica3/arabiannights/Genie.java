package arabiannights;

public class Genie {
	private int _wishes;
	private int _wishesGranted;

	protected void incrWishesGranted () {
		_wishesGranted+=1;
	}

	public Genie(int wishes){
		_wishes = wishes;
	}

	public boolean grantWish(){
		if ((_wishes - _wishesGranted)>0){
			_wishesGranted+=1;
			return true;
		}
		return false;
	}

	public int getGrantedWishes(){
		return _wishesGranted;
	}

	public int getRemaningWishes(){
		return (_wishes - _wishesGranted);
	}

	public boolean canGrantWish(){
		return (boolean)(_wishes - _wishesGranted);
	}
}