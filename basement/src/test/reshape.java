package test;
import java.util.Random;
class BX{
	void bx(){
		System.out.println("�ڱ���");
	}
}
class BX_1 extends BX{
	void bx() {
		System.out.println("��Ԩ�ڱ���");
	}
}
class BX_2 extends BX{
	void bx() {
		System.out.println("������ڱ���");
	}
}
class BX_3 extends BX{
	void bx() {
		System.out.println("˰�����ڱ���");
	}
}
class BX_4 extends BX{
	void bx() {
		System.out.println("�޽��ڱ���");
	}
}
public class reshape {
	public static void main(String args[]) {
		for(int i=0;i<4;i++) {
		Random b=new Random();
		int c=b.nextInt(4);
		BX a=null;
			switch(c){
			case 0:
				a= new BX_1(); 
				break;
			case 1:
				a= new BX_2(); 
				break;
			case 2:
				a= new BX_3(); 
				break;
			case 3:
				a= new BX_4(); 
				break;
		}
		a.bx();//�����ĵ���ֻ�ܹ��������
		}
	}
}
