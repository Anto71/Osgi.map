package osgi.map.tuple;


import osgi.map.item.Item;

//import aQute.bnd.annotation.component.Component;


//@Component
public class Tuple {

/*	Definire la classe Tuple che rappresenta una tupla dell’insieme di

	transazioni*/


	Item [] tuple; //membro che rappresenta in forma di array di Item la tupla



	public Tuple(int size){
		tuple= new Item[size];
	}
	/*Input: cardinalità dell’insieme di Item della tupla

	Output:

	Comportamento: costruttore che inizializza l&#39;array tuple con

	l’argomento size
*/
	public int getLength(){
		return this.tuple.length;
	}

	/*
	Output:

	Comportamento: restituisce la dimensione del membro tuple
*/
	public Item get(int i){
		if (i< this.tuple.length)
	    	return this.tuple[i];
		return null;
	}
	
/*
	Input: indice dell'Item da ottenere rispetto all'array

	Output: Item generico cercato

	Comportamento: restituisce l&#39;Item in posizione i
*/
	public void add(Item c,int i){
		tuple[i]=c;
	}
	

	/*Input: indice in cui aggiungere l&#39;Item, Item da aggiungere nell’array

	tuple

	Output:

	Comportamento: aggiorna il membro tuple col nuovo Item in posizione

	i*/

	public double getDistance(Tuple obj){
		double dist=0.0;
		for (int i = 0; i < tuple.length; i++) {
			dist+= get(i).distance(obj.get(i));
			
		}
		return dist;

	}

	/*Input: Tupla per il calcolo della distanza

	Output:

	Comportamento: determina la distanza tra la Tupla passata per

	argomento e la Tupla corrente (sulla quale il metodo è invocato).

	Impiega il metodo double distance(Object a) delle sotto-classi di Item
*/
/*	public double avgDistance(Data data, int clusteredData[ ]){
		double dist=0.0;
		double distMedia=0.0;
		for (int i=0;i<clusteredData.length;i++){
			dist  =dist+getDistance(data.getItemSet(clusteredData[i]));
		}
		distMedia=dist/clusteredData.length;
		return distMedia;
		
	}

	/*Input: oggetto Data, array di indici di tuple appartenenti ad un cluster

	Output:

	Comportamento: determina la distanza media tra le tuple

	clusteredData e la Tupla corrente (sulla quale il metodo è invocato).
	
	*/
//	@Override
	public String toString(){
		String s=new String();
		for(int i=0;i<this.getLength();i++){
		s+= this.get(i).toString();
		s+="\t";
		}
		return s;
		
	}
	
}
