package enumTest;

public enum EnumTest {
	
	
	PLUS{
		public double eval(double x,double y) {//ʵ��Ϊ�����ڲ����ʵ��
			return x+y;
		}
	},
	MINUS{

		@Override
		public double eval(double x, double y) {
			// TODO Auto-generated method stub
			return x-y;
		}
		
	};
	//------------------����һ�����󷽷����������Ϊ����ö���࣬ö��ֵ�������ʵ���������------------------------
		public abstract double eval(double x,double y);
		
		public static void main(String args[]) {
			double eval = EnumTest.PLUS.eval(1, 3);
			System.out.print(eval);
		}
}
