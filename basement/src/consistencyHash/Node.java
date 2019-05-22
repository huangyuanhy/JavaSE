/**
 * 
 */
package consistencyHash;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangyuan
 * 节点信息，模拟一台服务器
 */
public class Node {
	public Node(String domain,String Ip) {
		this.Ip=Ip;
		this.domain=domain;
	}
	private String Ip;
	private String domain;
	private  ConcurrentHashMap<String, Object> data=new ConcurrentHashMap<>();
	public  ConcurrentHashMap<String, Object> getData() {
		return data;
	}
	public void setData(ConcurrentHashMap<String, Object> data) {
		this.data = data;
	}
	public String getIp() {
		return Ip;
	}
	public void setIp(String ip) {
		Ip = ip;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public  <T> T get(String key) {
		return (T)data.get(key);
	}
	public <T> void put(String key, T value) {
		data.put(key, value);
	}
	public  void remove(String key) {
		data.remove(key);
	}
}
