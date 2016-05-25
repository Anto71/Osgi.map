package osgi.map.KmeansMinerApi;



import osgi.map.clusterSetApi.ClusterSetApi;
import osgi.map.dataService.api.dataService;

public interface KmeansMinerApi{
	public int kmeans(dataService data);
	public ClusterSetApi getC();
}
