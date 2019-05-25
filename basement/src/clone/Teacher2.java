package clone;


public class Teacher2 implements Cloneable{
	private String name;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (Teacher2) super.clone();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + "]";
	}

	public void setName(String name) {
		this.name = name;
	}
}
