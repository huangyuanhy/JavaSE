package test;
class Weapon{
	String power="80";
	String speed="12";
	
}
class  Tank extends Weapon{
	private String direction;
		void Attact(String direction,String power,String speed) {
			this.direction= direction;
			this.power=power;
			this.speed=speed;
		System.out.println("朝"+direction+"方向进攻，速度为"+speed+"攻击力为"+power);
	}
}
public class sucession {
	public static void main(String args[]) {
		Tank A=new Tank();
		A.Attact("左","100","25");
	}
}
