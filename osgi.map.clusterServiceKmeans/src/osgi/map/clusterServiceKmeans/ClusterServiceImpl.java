package osgi.map.clusterServiceKmeans;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import osgi.map.KmeansMinerApi.KmeansMinerApi;
import osgi.map.clusterService.ClusterService;
import osgi.map.dataService.api.dataService;

@Component(/*immediate=true,*/provide =ClusterService.class)
public class ClusterServiceImpl implements ClusterService {
	private volatile dataService _d;
	private volatile KmeansMinerApi _k;
	
	
	@Reference (service= KmeansMinerApi.class)
	void setKmeansMiner(KmeansMinerApi k){
		this._k=k;
	}
	public void unsetKmeansMiner(KmeansMinerApi k){
		this._k=null;
	}
	@Reference(service=dataService.class)
	public void setData(dataService d){
		this._d=d;
	}
	public void unsetData(dataService d){
		this._d=null;
	}
	@Override
	public String getTypeAlgorithm() {
		return "Kmeans";
	}

	@Override
	public boolean runClusterAlgorithm(String typeAlg) {
		System.out.println("kminer "+_k);
		int numIter=_k.kmeans(_d);
		System.out.println("Numero di Iterazione:"+numIter);
		System.out.println( _k.getClass().getName());
		System.out.println(_k.getC().toString(_d));
		if (numIter>0) return true;
		return false;
	}

}
