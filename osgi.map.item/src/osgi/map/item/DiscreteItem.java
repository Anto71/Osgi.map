package osgi.map.item;

import osgi.map.attribute.Attribute;

public class DiscreteItem extends Item {

	public DiscreteItem(Attribute attribute, Object value) {
		super(attribute, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double distance(Object a) {		
	//	System.out.println("distance");
		Item a1=(Item) a;
	//	System.out.println(this.getValue());
		//+" "+ a1.getValue());
		if (getValue().equals(a1.getValue()))
			return 0.0;
		
		return 1.0;
	}

}
