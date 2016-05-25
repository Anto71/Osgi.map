package osgi.map.dataService.api;

import osgi.map.arraySet.ArraySet;
import osgi.map.attribute.Attribute;
import osgi.map.attribute.DiscreteAttribute;
import osgi.map.item.Item;
import osgi.map.tuple.Tuple;

public interface dataService {
	
	public int getNumberOfExamples();
	public int getNumberOfExplanatoryAttributes();
	public Attribute[] getAttributeSchema();
	public Object getAttributeValue(int exampleIndex, int attributeIndex);
	public String toString();

	/*Input: indice sull’insieme di tuple (transazioni)

Output: un oggetto Tuple con gli Item (coppie Attributo-Valore) che lo

compongono

Comportamento: Crea e restituisce un oggetto Tuple costituito con le

coppie Attributo-valore della i-esima transazione. Allo stato attuale, si

implementi solo il caso discreto.*/
	public Object[][] getData();
    public 	Tuple getItemSet(int index);

	
    public int frequency(ArraySet idList, String v, DiscreteAttribute d) ;
	/*
	Input: numero di cluster da generare

	Output: array, di dimensione k, degli indici di Tuple-centroidi

	Comportamento: Metodo che inizializza i k-cluster assegnando a

	ciascuno di essi una Tupla dall’insieme in Data. L’assegnazione è randomica,

	perciò si consiglia l’uso della classe pre-definita Random. Il metodo

	restituisce un array, di dimensione k, di int con gli indici delle Tuple-centroidi

	selezionati rispetto all’insieme iniziale (e.g., indici in {0….13}). Nella selezione

	si verifichi che non sia scelta la stessa Tupla più volte.*/
	int[ ] sampling(int k);
	
	
	
	



   public 	Object computePrototype(ArraySet idList, Attribute attribute);

/*	Input: tuple appartenenti ad un cluster, attributo rispetto al quale

	calcolare il prototipo (centroide)

	Output: valore centroide rispetto ad attribute

	Comportamento: Invoca metodi appropriati per i casi discreto e

	continuo per la determinazione del prototipo (centroide) rispetto ad

	attribute (discreto o continuo)*/

	//public String computePrototype(ArraySet idList, DiscreteAttribute attribute);

	/*Input: tuple appartenenti ad un cluster, attributo discreto rispetto al

	quale calcolare il prototipo (centroide)

	Output: valore discreto centroide rispetto ad attribute

	Comportamento: Determina il prototipo, come valore più frequente,

	rispetto ad attribute*/
   
   
 //  public void update(dataService data, ArraySet clusteredData, Item i);
   public void update( ArraySet clusteredData, Item i);
    


   /*
   Input: oggetto data, tuple appartenenti ad un cluster

   Output:

   Comportamento: Rispetto all’insieme di tuple clusteredData

   appartenenti ad un cluster determina il centroide ristretto all’attributo

   Item sul quale è invocato tale metodo. Impiega il metodo Object

   computePrototype(ArraySet idList, Attribute attribute) che gli restituisce

   il valore centroide rispetto all’attributo Item sul quale è invocato*/

   public double avgDistance(Tuple t, int clusteredData[ ]);


}
