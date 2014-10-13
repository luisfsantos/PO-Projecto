package arabiannights;

public class RecyclableDemon extends Genie {
	private boolean _recycled;

	public RecyclableDemon(int wishes) {
		super(-1);
	}

	@Override
	public boolean grantWish() {
		if(_recycled) {
			return false;
		} else {
			incrWishesGranted();
			return true;
		}
	}

	public  boolean recycled(){
		return _recycled;
	}

	public void recycle(){
		_recycled = true;
	}

	public String toString(){
		if (_recycled) {
			return "Demon has been recycled.";
		} else {
			return "Recyclable demon has granted" + getGrantedWishes() + " wishes.";
		}
	}
}
