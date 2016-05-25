package osgi.map.cluster.manager;

import java.util.HashMap;
import java.util.Map;

import osgi.map.clusterService.ClusterService;

public class ClusterManagerImpl implements ClusterManager {
	Map<String, ClusterService> algorithm = new HashMap<String, ClusterService>();

	public void add(ClusterService typeCluster) {
		if (!algorithm.containsKey(typeCluster.getTypeAlgorithm())) {
			System.out.println("Registering in whiteboard: " + typeCluster.getTypeAlgorithm() + "\t" + typeCluster);
			algorithm.put(typeCluster.getTypeAlgorithm(), typeCluster);
		}
	}

	public void remove(ClusterService typeCluster) {
		if (algorithm.containsKey(typeCluster.getTypeAlgorithm())) {
			
		System.out.println("Deleting from whiteboard: " + typeCluster.getTypeAlgorithm());
		algorithm.remove(typeCluster);}
	}

	@Override
	public boolean addRunAlgorthm(String typeAlg) {
		ClusterService service = algorithm.get(typeAlg);
		if (service != null)
			return service.runClusterAlgorithm(typeAlg);

		return false;
	}

}
