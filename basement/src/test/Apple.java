package test;

public class Apple<T> {
	private T info;
	public Apple() {}
	//用T类型形参来定义方法
	public void setInfo(T info) {
		this.info=info;
		
	}
	public T getInfo() {
		return this.info;
	}
	

	public static void main(String[] args) {
			//因为传给T形参的是String 实际类型，所以构造器的参数只能是String
		Apple<String> al=new Apple<String>();
		al.setInfo("苹果");
		System.out.println(al.getInfo());
	}
}
