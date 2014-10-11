package arabiannights;

abstract class Genie {
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

	public int getRemainingWishes(){
		return (_wishes - _wishesGranted);
	}

	public boolean canGrantWish() {
		if (getRemainingWishes()==0) {
			return false;
		} else {
			return true;
		}
	}

	public abstract String toString();
}