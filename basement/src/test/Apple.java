package test;

public class Apple<T> {
	private T info;
	public Apple() {}
	//��T�����β������巽��
	public void setInfo(T info) {
		this.info=info;
		
	}
	public T getInfo() {
		return this.info;
	}
	

	public static void main(String[] args) {
			//��Ϊ����T�βε���String ʵ�����ͣ����Թ������Ĳ���ֻ����String
		Apple<String> al=new Apple<String>();
		al.setInfo("ƻ��");
		System.out.println(al.getInfo());
	}
}
