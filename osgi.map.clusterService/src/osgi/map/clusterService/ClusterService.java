package osgi.map.clusterService;

public interface ClusterService {
	public String getTypeAlgorithm(); 
	public boolean runClusterAlgorithm(String typeAlg);
}
