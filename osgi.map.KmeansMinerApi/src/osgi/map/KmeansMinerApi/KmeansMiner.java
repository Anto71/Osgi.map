package osgi.map.KmeansMinerApi;

import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import osgi.map.cluster.Cluster;
import osgi.map.clusterSetApi.ClusterSetApi;

import osgi.map.dataService.api.dataService;

@Component( provide =KmeansMinerApi.class,
properties = { " service.ranking =250 "	
})
public class KmeansMiner implements  KmeansMinerApi{
	
	private volatile ClusterSetApi _C;
	

	
	@Reference(service= ClusterSetApi.class)
	public void setClusterSet(ClusterSetApi cS){
		if (this._C==null)
				this._C=cS;
	}
	public void unsetClusterSet(){
		this._C=null;
	}

	public ClusterSetApi getC(){
		return _C;
	}
	/*
	 *     1.Place K points into the space represented by the objects that are being clustered. These points represent initial group centroids.
	 *     2.Assign each object to the group that has the closest centroid.
	 *     3.When all objects have been assigned, recalculate the positions of the K centroids.
	 *     4.Repeat Steps 2 and 3 until the centroids no longer move. This produces a separation of the objects into groups from which the metric to be minimized can be calculated.
	 */

	@Activate
	public void Activate(	){
	if (this._C!=null)
		System.out.println("Attivato Kmeans");
	else
		System.out.println(" NON Attivato Kmeans");
	}
	public int kmeans(dataService data){
		
		int numberOfIterations=0;
		//STEP 1
	
		_C.initializeCentroids(data);
		boolean changeClustered=false;
		do{
			numberOfIterations++;
			//STEP 2
			changeClustered=false;
			
			for(int i=0;i<data.getNumberOfExamples();i++){

				Cluster nearestCluster= _C.nearestCluster(data.getItemSet(i));
				Cluster oldCluster=_C.currentCluster(i);
				boolean currentChange=nearestCluster.addData(i);
				if(currentChange){
					
					changeClustered=true;
					}
				//rimuovo la tupla dal vecchio cluster
				if(currentChange && oldCluster!=null)
					//il nodo va rimosso dal suo vecchio cluster
					{
					oldCluster.removeTuple(i);
					}
			}
			
			//STEP 3
			_C.updateCentroids(data);
		}
		while(!changeClustered);
		
		return numberOfIterations;
	}

}
