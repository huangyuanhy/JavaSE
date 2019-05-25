package consistencyHash;

import java.util.stream.IntStream;


public class HashClusterTest {
	//总的数据量
	private static int dataCount=500000;
	private static String PRE="NORMAL";
	//static Cluster cluster=new NormalHashCluster();//普通取模算法
	static Cluster cluster=new ConsistencyHashCluster();//一致性hash算法
	public static void init() {
		cluster.addNode(new Node("huangyuan01","192.168.1.1"));
		cluster.addNode(new Node("huangyuan02","192.168.1.2"));
		cluster.addNode(new Node("huangyuan00","192.168.1.0"));

		System.out.println("初始化完成。。。。。。。。");
	}

	public static void main(String[] args) {
		System.out.println(((1<<5)-1)&1);
		System.out.println(((1<<5)-1)&2);
		System.out.println(((1<<5)-1)&((1<<5)));
		//加载数据
		init();
		
		IntStream.range(0, dataCount).forEach(index->{
			cluster.getNode(index+PRE).put(index+PRE, "test Data");
		});

		//假如增加一个节点，会对命中率产生很大影响，命中率约为0.25
		cluster.addNode(new Node("huangyuan03","192.168.1.0"));
		System.out.println("数据分布情况如下。。。。");
		cluster.nodes.forEach(node->{
			System.out.println("domain: "+node.getDomain()+", 数据量"+node.getData().size());
		});

		//测试缓存命中率
		long count = IntStream.range(0,dataCount).filter(index->cluster.getNode(index+PRE)
				.get(index+PRE)!=null).count();
		System.out.println("缓存命中率"+count*1f/dataCount);
	}

}
