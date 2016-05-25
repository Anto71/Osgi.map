package osgi.map.clusterSetImpl;



import java.io.IOException;
import java.util.Map;

import org.osgi.service.component.ComponentContext;
import aQute.bnd.annotation.component.*;
import osgi.map.cluster.Cluster;
import osgi.map.clusterSetApi.ClusterSetApi;
import osgi.map.dataService.api.dataService;
import osgi.map.tuple.Tuple;

@Component(	
			//name="ClusterSetImpl",
			provide = ClusterSetApi.class
		//	,immediate = true
			
		,properties = { " service.ranking:Integer = 300 ", "service.pid=osgi.map.clusterSetImpl.ClusterSetImpl"
			//,		"numCluster:Integer=3"
				}
				
			//	,configurationPolicy=ConfigurationPolicy.require
			
)


public class ClusterSetImpl implements ClusterSetApi {
	
	private Cluster C[];
	private int i=0;
    private static final String  NUM_CLUSTER="numCluster";
    
    
@Activate
@Modified
public void ClusterSetImplActivate(Map<String,Object> config, ComponentContext cContext) throws IOException{

		Integer k;
		if( config.containsKey(NUM_CLUSTER))
			 k= getConfigInt(config,NUM_CLUSTER);
		else
			k=3;
		
		C=new Cluster[k];
		i=0;
		System.out.println("Activate ClusterSetImpl "+ k);
		}

	
	
	
	


	@Override
	public void add(Cluster c) {
		C[i]=c;
		i++;
	
		
	}

	@Override
	public Cluster get(int i) {
		return C[i];
	}

	@Override
	public void initializeCentroids(dataService data) {
	    if (i>0)i=0;
		int centroidIndexes[]=data.sampling(C.length);
		for(int i=0;i<centroidIndexes.length;i++)
		{
				Tuple centroidI=data.getItemSet(centroidIndexes[i]);
			add(new Cluster(centroidI));
		}
		
	}

	@Override
	public void updateCentroids(dataService data) {
		for(int i=0;i<C.length;i++)
			C[i].computeCentroid(data);

		
	}

	@Override
	public Cluster nearestCluster(Tuple tuple) {
		Cluster c=C[0];
		double dmin=c.getCentroid().getDistance(tuple);
		for(int i=1;i<C.length;i++){
			double d=C[i].getCentroid().getDistance(tuple);
			if(d<=dmin){
				c=C[i];
				dmin=d;
				    
			}
			
		}
		
		return c;
		

	}

	@Override
	public Cluster currentCluster(int id) {
		Cluster c=null;
		for(int i=0;i<C.length;i++)
			if (C[i].contain(id))
				return C[i];
		return c;

	}

	@Override
	public String toString(dataService data) {
		String str="";
		for(int i=0;i<C.length;i++){
			if (C[i]!=null){
				str+=i+":"+C[i].toString(data)+"\n";
		
			}
		}
		return str;
		
	}




	@Override
	public String toString() {String str="";
	for(int i=0;i<C.length;i++){
		if (C[i]!=null){
			str+=i+":"+C[i]+"\n";
	
		}
	}
	return str;}


	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	
	static Integer getConfigInt(Map<String,Object> cfg, String key){
		Object o=cfg.get(key);
		if(o==null)
			return 0;
		else if (o instanceof Number)
			return ((Number)o).intValue();
		else if (o instanceof String)
			return Integer.parseInt((String)o);
		else
	
			throw new IllegalArgumentException(String.format("", key));
	}


	
	
}
