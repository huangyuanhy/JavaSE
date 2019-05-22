/**
 * 
 */
package consistencyHash;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * @author huangyuan
 * 分布式缓存 一致性hash算法测试
 */
public class ConsistencyHashCluster extends Cluster{
	//虚拟节点
	private static final int VIR_NODE_COUNT=2<<15;
	private SortedMap<Integer, Node> virtualNodes=new TreeMap<>();
	private static final String SPLIT="#";
	@Override
	public void addNode(Node node) {
		nodes.add(node);
		IntStream.range(0, VIR_NODE_COUNT).forEach(index->{
			Integer hash= (node.getIp()+SPLIT+index).hashCode();
			virtualNodes.put(hash, node);
		});
		
	}

	@Override
	public void removeNode(Node node) {
		nodes.removeIf(o->o.getIp().equals(node.getIp()));
		IntStream.range(0, VIR_NODE_COUNT).forEach(index->{
			Integer hash= (node.getIp()+SPLIT+index).hashCode();
			virtualNodes.remove(hash);
		});
	}

	@Override
	public Node getNode(String key) {
		int hash = key.hashCode();
		SortedMap<Integer, Node> subMap= hash>=virtualNodes.lastKey()?
				virtualNodes.tailMap(0):virtualNodes.tailMap(hash);
		if (subMap.isEmpty()) {
			return null;
		}
		return subMap.get(subMap.firstKey());
	}

}
