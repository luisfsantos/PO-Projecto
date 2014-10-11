package arabiannights;

public class MagicLamp {
	public Genie [] _genies;
	private int _createdGenies;
	private int _createdDemons;
	private int _rubs;

	public MagicLamp(int genies){
		Genie [] _genies = new Genie[genies];
	}

	public void Rub(int wishes){
		if(even(_rubs)){
			_genies[_createdGenies]= new GrumpyGenie(wishes);
			_createdGenies+=1;
		} else {
			_genies[_createdGenies]= new FriendlyGenie(wishes);
			_createdGenies+=1;
		}
	}
	public boolean even(int num){
		return (num%2)==0;
	}

	public static void main(){
		MagicLamp arrabia = new MagicLamp(6);
		arrabia.Rub(4);
		arrabia._genies[0].toString();
		arrabia._genies[0].grantWish();
		arrabia._genies[0].toString();

	}

}