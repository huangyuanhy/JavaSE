package ioc;
//注入多个复杂类型属性

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class PropertyTest {
	
	public void test() {
		System.out.println("arr"+Arrays.toString(arr));
		System.out.println("map"+map);
		System.out.println("list"+list);
		System.out.println("prop"+prop);

	}
	
	public String[] getArr() {
		return arr;
	}
	public void setArr(String[] arr) {
		this.arr = arr;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	private String[] arr;
	private List<String> list;
	private Map<String, String> map;
	private Properties prop;
}
