/**
 * 
 */
package thread;

/**
 * @author huangyuan
 * @date 2018年8月2日上午9:57:32
 * @Description  ThreadLocal 的使用方法及场景  避免多线程对共享变量的更改。 同时 线程内部又需要同时使用的场景
 * 每个线程需要有自己单独的实例 
实例需要在多个方法中共享，但不希望被多线程共享 
 */
public class SessionHandler {
	
	 public static ThreadLocal<Session> session = new ThreadLocal<Session>();
	 
	  public static class Session {
	    private String id;
	    public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		private String user;
	    private String status;
	  }
	  
	  
	  
	  public void createSession() {
	    session.set(new Session());
	  }
	  
	  
	  public String getUser() {
	    return session.get().getUser();
	  }
	  public String getStatus() {
	    return session.get().getStatus();
	  }
	  public void setStatus(String status) {
	    session.get().setStatus(status);
	  }
	  public static void main(String[] args) {
	    new Thread(() -> {
	      SessionHandler handler = new SessionHandler();
	      handler.getStatus();
	      handler.getUser();
	      handler.setStatus("close");
	      handler.getStatus();
	    }).start();
	  }
}
