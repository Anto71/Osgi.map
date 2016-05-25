package osgi.map.item;

import osgi.map.attribute.Attribute;

public abstract class Item {
	
	/*Definire la classe astratta Item che modella un generico item (coppia

attributo-valore, Outlook=”Sunny”) di una tupla

Attributi*/


protected Attribute attribute;// attributo coinvolto nell&#39;item

protected Object value;// valore dell&#39;attributo



public Item(Attribute attribute, Object value){
/*	Input: riferimenti per attributo e suo valore

	Output:

	Comportamento: inizializza i valori dei membri attributi*/
	
	this.attribute=attribute;
	this.value=value;
}

public void setAttribute(Attribute attribute){
	this.attribute=attribute;
}
public void setValue(Object value){
	this.value=value;
}
public Attribute getAttribute(){
	/*
	Input:

	Output : attributo coinvolto nell&#39;item

	Comportamento: restituisce il membro Attribute;
	*/
	return this.attribute;
}


public Object getValue(){

	return this.value;
}
/*
Input:

Output : valore dell&#39;attributo coinvolto nell&#39;item

Comportamento: restituisce il membro Value;
*/

public String toString(){
	return value.toString();


}
/*
Input:

Output:

Comportamento: restituisce una stringa composta dai contenuti degli

oggetto membro*/

abstract public double distance(Object a);
/*
Input:

Output:

Comportamento: Determina la distanza tra l’Item corrente (sul quale il

metodo è invocato) e quello passato come argomento.

L’implementazione del metodo è distinta per il caso continuo e per il

caso discreto.

*/



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
	result = prime * result + ((value == null) ? 0 : value.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Item other = (Item) obj;
	if (attribute == null) {
		if (other.attribute != null)
			return false;
	} else if (!attribute.equals(other.attribute))
		return false;
	if (value == null) {
		if (other.value != null)
			return false;
	} else if (!value.equals(other.value))
		return false;
	return true;
}

}