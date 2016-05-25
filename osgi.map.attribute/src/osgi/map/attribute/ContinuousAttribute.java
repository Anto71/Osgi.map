package osgi.map.attribute;
public class ContinuousAttribute extends Attribute {

	private double max;

	private double min;// rappresentano gli estremi dell'intervallo di valori

	// che l'attributo può assumere. Necessari per la normalizzazione min-max
	// in[0;1].

	public ContinuousAttribute(String name, int index, double min, double max) {

		super(name, index);
		this.max = max;
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	/*
	 * Input: estremi per la normalizzazione, identificativo numerico
	 * 
	 * dell&#39;attributo e nome dell’attributo
	 * 
	 * Output : //
	 * 
	 * Comportamento: Invoca il costruttore della classe madre e avvalora i
	 * 
	 * membri
	 */
	public double getScaledValue(ContinuousAttribute a, double v) {
		return (v - a.getMin()) / (a.getMax() - a.getMin());
	}

	/*
	 * Input: valore dell'attributo da normalizzare
	 * 
	 * Output : valore normalizzato
	 * 
	 * Comportamento: Esegue la normalizzazione usando il valore di input e
	 * 
	 * quello dei membri min,max come minA,maxA
	 */
}