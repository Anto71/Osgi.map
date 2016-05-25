package osgi.map.clusterService.Kmedoids;

import aQute.bnd.annotation.component.Component;

import osgi.map.clusterService.ClusterService;

@Component(provide = ClusterService.class)
public class ClusterServiceImpl implements ClusterService {

	@Override
	public String getTypeAlgorithm() {

		return "Kmedoids";
	}

	@Override
	public boolean runClusterAlgorithm(String typeAlg) {
		System.out.println("Algoritmo  " + typeAlg);
		return true;
	}

}
