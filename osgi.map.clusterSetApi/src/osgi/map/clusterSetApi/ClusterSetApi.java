package osgi.map.clusterSetApi;



import osgi.map.cluster.Cluster;
import osgi.map.dataService.api.dataService;
import osgi.map.tuple.Tuple;
public interface ClusterSetApi {

//	ClusterSet(int k);
//	void newClusterSet(int k);
	public void start();
	public void add(Cluster c);
	
	public Cluster get(int i);
	public void initializeCentroids(dataService data);
	public void updateCentroids(dataService data);
	public Cluster nearestCluster(Tuple tuple);
	// verifica il custer a cui appartiene la tuple ; null in caso non appartenga a nessun cluster
	
	public Cluster currentCluster(int id);
	public String toString();
	public String toString(dataService data );
	

}
