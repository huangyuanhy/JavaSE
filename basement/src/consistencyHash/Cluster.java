package consistencyHash;

import java.util.LinkedList;
import java.util.List;

public abstract class Cluster {
	protected List<Node> nodes=new LinkedList<>();
	
	public abstract void addNode(Node node) ;
	public abstract void removeNode(Node node);
	public abstract Node getNode(String key);
}
