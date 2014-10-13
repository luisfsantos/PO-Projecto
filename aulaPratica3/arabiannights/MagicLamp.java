package arabiannights;

public class MagicLamp {
	private int _genies;
	private int _createdGenies;
	private int _createdDemons;
	private int _rubs;

	public MagicLamp(int genies){
		_genies = genies;
	}

	public Genie Rub(int wishes){
		_rubs+=1;
		if(even(_rubs-1)){
			_createdGenies+=1;
			return new GrumpyGenie(wishes);

		} else {
			_createdGenies+=1;
			return new FriendlyGenie(wishes);
		}
	}
	
	public boolean even(int num){
		return (num%2)==0;
	}


}