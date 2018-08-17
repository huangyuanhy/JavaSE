package ioc.annotation;

import javax.annotation.Resource;

public class Service {
	
	private BookDAo bookdao;
	
	
	private OrderDao orderdao;
	@Resource(name="bookdao")
	public void setBookdao(BookDAo bookdao) {
		this.bookdao = bookdao;
	}
	@Resource(name="orderdao")  
	public void setOrderdao(OrderDao orderdao) {
		this.orderdao = orderdao;
	}

	public void service() {
		System.out.println("service---------");
		bookdao.book();
		orderdao.buy();
	}
}
