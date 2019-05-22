package consistencyHash;
/**
 * @author huangyuan
 * 分布式缓存  普通的取模算法
 */
public class NormalHashCluster extends Cluster {
	private volatile int size;
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void addNode(Node node) {
		if (node!=null) {
			nodes.add(node);
			size++;			
		}
	}

	@Override
	public void removeNode(Node node) {
		nodes.removeIf(o->o.getIp().equals(node.getIp())
				|| o.getDomain().equals(node.getDomain()));
		size--;
	}

	@Override
	public Node getNode(String key) {
		int hash=key.hashCode();
		if (hash<0) {
			hash=-hash;
		}
		long index=hash%nodes.size();
		return nodes.get((int)index); 
	}

}
