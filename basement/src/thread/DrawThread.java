package thread;

public class DrawThread extends Thread{
	//ģ���û��˻�
	Account account;
	double drawAmount;
	public DrawThread(String name,Account account,double drawAmount) {
		super(name);
		this.account=account;
		this.drawAmount=drawAmount;
	}


	public void run() {
		account.draw(drawAmount);
	}
	//�����˻��������������߳̽���ȡǮ
	public static void main(String[] args) {

		//�����˻�
		Account acc1=new Account("123456",1000);
		Account acc2=new Account("123456",1000);
		new DrawThread("��",acc1,800).start();
		new DrawThread("��",acc1,800).start();
	}
}

class Account {
	String accountNo;
	private double balance;
	public Account() {}
	public Account(String accountNo,double balance) {
		this.accountNo=accountNo;
		this.balance=balance;
	}
	public synchronized void draw(double drawAmount) {
		//�˻�������ȡǮ��Ŀ
		if(balance>=drawAmount) {
			//�³���Ʊ
			System.out.println(Thread.currentThread().getName()+"ȡǮ�ɹ����³���Ʊ��"+drawAmount);

			try {
				Thread.sleep(1);

			}
			catch(Exception e) {
				e.printStackTrace();
			}

			//�޸����
			balance-=drawAmount;
			System.out.println("\t ���Ϊ"+balance);

		}

		else {
			System.out.println(Thread.currentThread().getName()+"ȡǮʧ�ܣ���Ǯ����");
		}
	}

	//ΪʲôҪ��д2����������

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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	
	}
}