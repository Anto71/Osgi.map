package osgi.map.attribute;

public abstract class Attribute {

	protected String name; // nome simbolico dell&#39;attributo

	protected int index; // identificativo numerico dell&#39;attributo

	public Attribute(){}
	
	public Attribute(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public String getName() {

		return this.name;
	}

	public int getIndex() {
		return this.index;
	}

	public String toString() {
		return this.name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Attribute other = (Attribute) obj;
		if (index != other.index)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}