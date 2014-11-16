package arabiannights;

/**
*Classe que cria genios e demonios
*/
public class MagicLamp {
	private int _genies;
	private int _createdGenies;
	private int _numReloads;
	private int _rubs;
/**
*Construtor da MagicLamp
*@param genies Numero maximo de genios que a lampada pode criar. 
*/
	public MagicLamp(int genies){
		_genies = genies;
	}
/**
*Esfrega a lampada libertando um dos genios ou um demonio.
*@param wishes Numero de desejos que o genio tera que realizar.
*@return A lampada pode ser esfregada um numero impar ou par de vezes, devolvendo um GrumpyGenie ou FriendlyGenie, respectivamente. 
*  Liberta RecyclableGenie quando nao tem genios disponiveis. 
*/
	public Genie rub(int wishes){
		_rubs+=1;
		if (_genies > _createdGenies)
		{
			_createdGenies+=1;
			if((_rubs-1)%2 == 0){
				return new GrumpyGenie(wishes);

			} else {
				return new FriendlyGenie(wishes);
			}
		} else {
			return new RecyclableDemon(wishes);
		}
	}
	
/**
*Recarrega a lampada reciclando um RecyclableDemon.
*@param demon RecyclableDemon que sera alimentado a lampada.
*/
	public void feedDemon (RecyclableDemon demon)
	{
		if (!demon.recycled())
		{
			demon.recycle();
			_createdGenies = 0;
			_rubs = 0;
			_numReloads += 1;
		}
		return;
	}

/**
*Devolve o numero de genios ainda disponiveis na lampada.
*@return Numero de genios disponiveis na lampada.
*/
	public int getGenies ()
	{
		return _genies - _createdGenies;
	}

/**
*Devolve o numero de vezes que a lampada foi recarregada.
*@return Numero de vezes que a lampada foi recarregada.
*/
	public int getDemons ()
	{
		return _numReloads;
	}


/**
*Devolve o numero maximo de genios que a lampada consegue criar.
*@return Numero maximo de genios que a lampada consegue criar.
*/
	public int maxGenies ()
	{
		return _genies;
	}


/**
*Verifica se as duas lampadas sao iguais.
*@return <code>true</code> se a capacidade, numero de genios disponiveis e numero de recarregamentos forem iguais em duas lampadas. 
*<code>false</code>  no caso contrario
*/
	public boolean equals (Object lamp2)
	{	
		if (lamp2 instanceof MagicLamp)
		{
			return _genies == ((MagicLamp) lamp2).maxGenies() &&
			getGenies() == ((MagicLamp) lamp2).getGenies() &&
			getDemons() == ((MagicLamp) lamp2).getDemons();
		}
		return false;
	}

}