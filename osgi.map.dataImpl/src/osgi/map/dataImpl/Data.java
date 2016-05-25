package osgi.map.dataImpl;

import java.util.Random;

import aQute.bnd.annotation.component.*;
import osgi.map.arraySet.ArraySet;
import osgi.map.attribute.Attribute;
import osgi.map.attribute.DiscreteAttribute;
import osgi.map.dataService.api.dataService;
import osgi.map.item.DiscreteItem;
import osgi.map.item.Item;
import osgi.map.tuple.Tuple;


@Component(name="data",provide = dataService.class,// immediate = true,

 properties = { " service.ranking:Integer =100 "})

public class Data implements dataService {

	// modellare l'insieme di transazioni

	private Object data[][]; // una matrice nXm di tipo Object che contiene

	// l'insieme di transazioni è ed organizzato come numero di transazioni X

	// numero di attributi

	private int numberOfExamples; // cardinalità dell’insieme di transazioni

	private Attribute explanatorySet[]; // array di riferimenti a oggetti-
@Deactivate
  public void stop(){
	
}
	public Data() {
		/*
		 * Input:
		 * 
		 * Output :
		 * 
		 * Comportamento: Popola la matrice data [ ][ ] con le transazioni (14
		 * 
		 * esempi e 5 attributi);
		 * 
		 * Avvalora 'array explanatorySet [ ]: istanzia 5 oggetti di tipo
		 * 
		 * DiscreteAttribute per ciascun attributo assegnando, a ciascuno di
		 * 
		 * essi, l'array dei valori discreti dell'attributo corrispondente.
		 */
		explanatorySet = new Attribute[5];
		String[] values = new String[3];
		values[0] = "Sunny";
		values[1] = "Overcast";
		values[2] = "Rain";

		DiscreteAttribute A1 = new DiscreteAttribute("OutLook", 1, values);

		values = new String[3];
		values[0] = "Hot";
		values[1] = "Mild";
		values[2] = "Cool";

		DiscreteAttribute A2 = new DiscreteAttribute("Temeparture", 2, values);

		values = new String[2];
		values[0] = "High";
		values[1] = "Normal";

		DiscreteAttribute A3 = new DiscreteAttribute("Humidity", 3, values);

		values = new String[2];
		values[0] = "Weak";
		values[1] = "Strong";

		DiscreteAttribute A4 = new DiscreteAttribute("Wind", 4, values);

		values = new String[2];
		values[0] = "No";
		values[1] = "Yes";

		DiscreteAttribute A5 = new DiscreteAttribute("PlayTennis", 5, values);

		this.explanatorySet[0] = A1;
		this.explanatorySet[1] = A2;
		this.explanatorySet[2] = A3;
		this.explanatorySet[3] = A4;
		this.explanatorySet[4] = A5;

		this.data = new Object[14][5];
		this.data[0][0] = A1.getValue(0);
		this.data[0][1] = A2.getValue(0);
		this.data[0][2] = A3.getValue(0);
		this.data[0][3] = A4.getValue(0);
		this.data[0][4] = A5.getValue(0);
		this.data[1][0] = A1.getValue(0);
		this.data[1][1] = A2.getValue(0);
		this.data[1][2] = A3.getValue(0);
		this.data[1][3] = A4.getValue(1);
		this.data[1][4] = A5.getValue(0);
		this.data[2][0] = A1.getValue(1);
		this.data[2][1] = A2.getValue(0);
		this.data[2][2] = A3.getValue(0);
		this.data[2][3] = A4.getValue(0);
		this.data[2][4] = A5.getValue(1);
		this.data[3][0] = A1.getValue(2);
		this.data[3][1] = A2.getValue(1);
		this.data[3][2] = A3.getValue(0);
		this.data[3][3] = A4.getValue(0);
		this.data[3][4] = A5.getValue(1);
		this.data[4][0] = A1.getValue(2);
		this.data[4][1] = A2.getValue(2);
		this.data[4][2] = A3.getValue(1);
		this.data[4][3] = A4.getValue(0);
		this.data[4][4] = A5.getValue(1);
		this.data[5][0] = A1.getValue(2);
		this.data[5][1] = A2.getValue(2);
		this.data[5][2] = A3.getValue(1);
		this.data[5][3] = A4.getValue(1);
		this.data[5][4] = A5.getValue(0);
		this.data[6][0] = A1.getValue(1);
		this.data[6][1] = A2.getValue(2);
		this.data[6][2] = A3.getValue(1);
		this.data[6][3] = A4.getValue(1);
		this.data[6][4] = A5.getValue(1);
		this.data[7][0] = A1.getValue(0);
		this.data[7][1] = A2.getValue(1);
		this.data[7][2] = A3.getValue(0);
		this.data[7][3] = A4.getValue(0);
		this.data[7][4] = A5.getValue(0);
		this.data[8][0] = A1.getValue(0);
		this.data[8][1] = A2.getValue(2);
		this.data[8][2] = A3.getValue(1);
		this.data[8][3] = A4.getValue(0);
		this.data[8][4] = A5.getValue(1);
		this.data[9][0] = A1.getValue(2);
		this.data[9][1] = A2.getValue(1);
		this.data[9][2] = A3.getValue(1);
		this.data[9][3] = A4.getValue(0);
		this.data[9][4] = A5.getValue(1);
		this.data[10][0] = A1.getValue(0);
		this.data[10][1] = A2.getValue(1);
		this.data[10][2] = A3.getValue(1);
		this.data[10][3] = A4.getValue(1);
		this.data[10][4] = A5.getValue(1);
		this.data[11][0] = A1.getValue(1);
		this.data[11][1] = A2.getValue(1);
		this.data[11][2] = A3.getValue(0);
		this.data[11][3] = A4.getValue(1);
		this.data[11][4] = A5.getValue(1);
		this.data[12][0] = A1.getValue(1);
		this.data[12][1] = A2.getValue(0);
		this.data[12][2] = A3.getValue(1);
		this.data[12][3] = A4.getValue(0);
		this.data[12][4] = A5.getValue(1);
		this.data[13][0] = A1.getValue(2);
		this.data[13][1] = A2.getValue(1);
		this.data[13][2] = A3.getValue(0);
		this.data[13][3] = A4.getValue(1);
		this.data[13][4] = A5.getValue(0);
		this.numberOfExamples = this.data.length;

	}

	public Object[][] getData() {
		return this.data;
	}

	public int getNumberOfExamples() {

		/*
		 * Input://
		 * 
		 * Output: cardinalità dell&#39;insieme di transazioni
		 * 
		 * Comportamento: restituisce il valore del membro numberOfExamples
		 */
		return this.numberOfExamples;
	}

	public int getNumberOfExplanatoryAttributes() {

		/*
		 * Input://
		 * 
		 * Output: cardinalità ;insieme degli attributi
		 * 
		 * Comportamento: restituisce la cardinalità del membro explanatorySet[
		 * ]
		 */
		return this.explanatorySet.length;

	}

	public Attribute[] getAttributeSchema() {

		/*
		 * Input: //
		 * 
		 * Output: array degli attributi
		 * 
		 * Comportamento: restituisce l'array membro explanatorySet[]
		 */
		return this.explanatorySet;

	}

	public Object getAttributeValue(int exampleIndex, int attributeIndex) {

		/*
		 * Input: indice di riga per la matrice data [][] per una specifica
		 * transazione
		 * 
		 * Output: Object associato all'attributo per la transazione indicizzata
		 * in
		 * 
		 * input
		 * 
		 * Comportamento: restituisce il valore dell' attributo attributeIndex
		 * per la
		 * 
		 * transazione exampleIndex
		 */
		return data[exampleIndex][attributeIndex];

	}

	public String toString() {

		/*
		 * Input: //
		 * 
		 * Comportamento: per ogni transazione, legge i valori di tutti gli
		 * attributi in
		 * 
		 * data [ ][ ] e li concatena in un oggetto String che restituisce come
		 * 
		 * risultato finale in forma di sequenze di testi.
		 */

		String tabella = new String();
		for (int i = 0; i <= getNumberOfExplanatoryAttributes() - 2; i++) {
			tabella = tabella + this.explanatorySet[i] + "\t";
		}
		tabella = tabella + this.explanatorySet[getNumberOfExplanatoryAttributes() - 1] + "\n";

		for (int r = 0; r < this.numberOfExamples; r++) {

			tabella = tabella + " " + (r + 1) + " ";
			for (int c = 0; c < getNumberOfExplanatoryAttributes() - 1; c++) {
				tabella = tabella + getAttributeValue(r, c) + "\t";

			}

			tabella = tabella + getAttributeValue(r, getNumberOfExplanatoryAttributes() - 1) + "\n";
		}

		return tabella;

	}

	@Override
	public Tuple getItemSet(int index) {
		Tuple tuple=new Tuple(explanatorySet.length);
		Item item=null;
		int i=0;
		for(i=0;i<explanatorySet.length;i++){
			item= new DiscreteItem(explanatorySet[i],(String)data[index][i]);
			tuple.add(item,i);}
		return tuple;

		
		
		
	
	}

	@Override
	public int[] sampling(int k) {
		int centroidIndexes[]=new int[k];
		//choose k random different centroids in data.
		Random rand=new Random();
		rand.setSeed(System.currentTimeMillis());
		
		for (int i=0;i<k;i++){
			boolean found=false;
			int c;
			do
			{
				found=false;
				c=rand.nextInt(getNumberOfExamples());
				// verify that centroid[c] is not equal to a centroide already stored in CentroidIndexes
				for(int j=0;j<i;j++)
					if(compare(centroidIndexes[j],c)){
						found=true;
						break;
					}
			}
			while(found);		
			centroidIndexes[i]=c;
		}
		return centroidIndexes;

	}

	/*
	 * Input: indici di due Tuple nell’insieme in Data
	 * 
	 * Output: esito dell’uguaglianza tra due Tuple
	 * 
	 * Comportamento: Verifica se due Tuple sono coincidenti (medesima
	 * 
	 * Tupla) mediante i loro indici. Metodo usato in int[ ] sampling(int k)
	 */

	private boolean compare(int i, int j) {
		
		boolean equal=true;
		for(int k=0;k<getNumberOfExplanatoryAttributes();k++)
			if(!data[i][k].equals(data[j][k])){
				equal=false;
				break;
			}
		return equal;

	}

	@Override
	public Object computePrototype(ArraySet idList, Attribute attribute) {
		return computePrototype(idList, (DiscreteAttribute)attribute);
	}


	private String computePrototype(ArraySet idList, DiscreteAttribute attribute) {
		String prototype=attribute.getValue(0);
		int maxFrequency=frequency(idList, prototype,attribute);
		// most frequent label
		
		for(int j=1;j<attribute.getNumberOfDistinctValues();j++)
		{
			int f=frequency(idList, (String)attribute.getValue(j),attribute);
			if(f>maxFrequency){
				maxFrequency=f;
				prototype=attribute.getValue(j);
			}
			
		}
		return prototype;

	}

	@Override
	public int frequency(ArraySet idList, String v, DiscreteAttribute d) {
		/*
		 * Input: oggetto Data, oggetto ArraySet di indici di tuple, valore
		 * discreto
		 * 
		 * Output: frequenza (intero) Comportamento: Determina il numero di
		 * occorrenze del valore v dato come argomento nel sotto-insieme di
		 * tuple nell’oggetto idList
		 */

		int freq = 0;
		int[] array = idList.toArray();
		for (int i = 0; i < array.length; i++) {
		
				if ((getAttributeValue(array[i], d.getIndex()-1).equals(v)))
					freq+=1;

		}

		return freq;
	}

	@Override
//	public void update(dataService data, ArraySet clusteredData, Item i) {
	/*
	 * 	
	void update(Data data, ArraySet clusteredData){
		value=data.computePrototype(clusteredData,attribute);
	}

	 */
		public void update( ArraySet clusteredData, Item i) {
		Object value= computePrototype(clusteredData, i.getAttribute());
		i.setValue(value);
	}

	@Override
	public double avgDistance(Tuple t, int[] clusteredData) {
		double summdist=0.0;
		double distMedia=0.0;
		for (int i=0;i<clusteredData.length;i++){
			summdist  +=t.getDistance(getItemSet(clusteredData[i]));
		}
		distMedia=summdist/clusteredData.length;
		return distMedia;
	}
}