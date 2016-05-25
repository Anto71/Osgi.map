package osgi.map.attribute;





public class DiscreteAttribute extends Attribute {

	private String values[];// array di oggetti String, uno per ciascun valore

	// discreto. I valori di intendono pre-ordinati lessicograficamente.

	
	public DiscreteAttribute(){ }
	public DiscreteAttribute(String name, int index, String values[]) {

		super(name, index);
		this.values = new String[values.length];
		System.arraycopy(values, 0, this.values, 0, values.length);
		/*
		 * Input: valori per nome simbolico dell&#39;attributo, identificativo
		 * numerico
		 * 
		 * dell&#39;attributo e valori discreti
		 * 
		 * Output : //
		 * 
		 * Comportamento: Invoca il costruttore della classe madre e
		 * 
		 * avvalora l'array values[ ] con i valori discreti in input.
		 */
	}

	public int getNumberOfDistinctValues() {

		/*
		 * Input: //
		 * 
		 * Output : numero di valori discreti dell&#39;attributo
		 * 
		 * Comportamento: Restituisce la cardinalità dell&#39;array values[]
		 */
		return this.values.length;

	}

	/*public int frequency(dataService _d, ArraySet idList, String v) {
		// TODO
		/*
		 * Input: oggetto Data, oggetto ArraySet di indici di tuple, valore
		 * discreto
		 * 
		 * Output: frequenza (intero) Comportamento: Determina il numero di
		 * occorrenze del valore v dato come argomento nel sotto-insieme di
		 * tuple nell’oggetto idList
		 */

	/*	int freq = 0;
		int[] array = idList.toArray();
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < _d.getItemSet(array[i]).getLength(); j++) {
				if (_d.getAttributeValue(array[i], getIndex()).equals(v))
					freq += 1;

			}

		}

		return freq;

	}*/

	public String getValue(int i) {

		/*
		 * Input: indice del valore rispetto all&#39;array membro
		 * 
		 * Output : valore discreto in posizione “i”
		 * 
		 * Comportamento: Restituisce valore discreto in posizione “i”
		 */
		return this.values[i];
	}
}
