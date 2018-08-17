package thread;
/*
 * �������̣߳�ȡǮ�ʹ�Ǯ�̣߳�����ϵͳ��һ��Ҫ��ȡǮ�ߺʹ�Ǯ�߽������ȡ��Ķ���
 * ����Ҫ��ÿ������۴���Ǯ��ȡǮ������ȡ���ñ�Ǯ�������������������δ�Ǯ��Ҳ����ȡǮ����������ȡǮ
 */
public class TestDraw {
	public static void main(String[] args) {
		//����һ���˻�
		
		/*
		 * ����ᱻ����
		 */
		Account1 acct=new Account1("12345",0);
		
		new DepositThread("��Ǯ��     ",acct,800).start();
		new WithinDrawThread("ȡǮ�߼�      ",acct,800).start();
		new WithinDrawThread("ȡǮ����",acct,600).start();
	}
}
class Account1{
	private String accountNo;
	private double balance;
	private boolean flag=false;
	Account1(){}
	Account1(String accountNo, double balance){
		this.accountNo=accountNo;
		this.balance=balance;
		
	}
	public double getBalance() {
		return this.balance;
	}
	
	//ȡǮ�ķ���
	public synchronized void draw(double drawAmount) throws InterruptedException {
		
		//flagΪ�ٵĻ�������ȡǮ��Ϊ�������ȡǮ
		if(!flag) {
			this.wait();
		}
		else {
				if(balance>drawAmount) {
				balance-=drawAmount;
				System.out.println(Thread.currentThread().getName()+"ȡǮ�ɹ����³���Ʊ��"+drawAmount+"\t���Ϊ��"+balance);
			}
//			else {
//				System.out.println(Thread.currentThread().getName()+"������ȡǮʧ��");
//			}
		}
		//���������̣߳���ȡǮ�߳�
		flag=false;
		this.notifyAll();
	}
	
	//��Ǯ�ķ���
	public synchronized void deposit(double depositAmount) throws InterruptedException {
		//flagΪ���ʱ�򣬱����Ѿ����Ǯ�ˣ�������д�Ǯ
		if(flag) {
			this.wait();
		
		}
		else {
				balance+=depositAmount;
				System.out.println(Thread.currentThread().getName()+"��Ǯ�ɹ���������"+balance);
		}
		flag=true;
		this.notifyAll();//���������̣߳���ȡǮ�߳�
	}
	public int hashCode() {
		return accountNo.hashCode();
	}
	public boolean equals(Object obj) {
		if(obj!=null&&obj.getClass()==Account.class)
		{
			Account target=(Account)obj;
			return target.accountNo.equals(accountNo);
		}
		return false;
	}
}

//ģ��ȡǮ�û�
class WithinDrawThread extends Thread{
	private Account1 account;
	private double drawAmount;
	public WithinDrawThread(String name,Account1 account,double drawAmount) {
		super(name);
		this.account=account;
		this.drawAmount=drawAmount;
	}
	
	//�ظ�10��ȡǮ����
	public void run() {
		for(int i=0;i<100;i++) {
			try {
				account.draw(drawAmount);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}

//ģ���Ǯ�û�
class DepositThread extends Thread{
	private Account1 account;
	private double depositAmount;
	public DepositThread() {}
	public DepositThread(String name,Account1 account,double depositAmount){
		super(name);
		this.account=account;
		this.depositAmount=depositAmount;
	}
	
	//�ظ�10�δ�Ǯ����
	public void run() {
		for(int i=0;i<100;i++) {
			try {
				account.deposit(depositAmount);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


















