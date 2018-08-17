package enumTest;

public enum EnumTest {
	
	
	PLUS{
		public double eval(double x,double y) {//实际为匿名内部类的实例
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
	//------------------定义一个抽象方法，则这个类为抽象枚举类，枚举值对象必须实现这个方法------------------------
		public abstract double eval(double x,double y);
		
		public static void main(String args[]) {
			double eval = EnumTest.PLUS.eval(1, 3);
			System.out.print(eval);
		}
}
