package arabiannights;

public class RecyclableDemon extends Genie {
	private boolean _recycled;

	public RecyclableDemon(int wishes){
		super(-1);
	}

	@Override
	public boolean grantWish() {
		if(_recycled) {return false;}
		else{
			incrWishesGranted();
			return true;
		}
	}
}