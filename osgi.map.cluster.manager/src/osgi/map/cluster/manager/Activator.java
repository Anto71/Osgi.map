package osgi.map.cluster.manager;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

import osgi.map.clusterService.ClusterService;

public class Activator extends DependencyActivatorBase{

	@Override
	public void destroy(BundleContext context, DependencyManager manager)
			throws Exception {
	}

	@Override
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {

		manager.add(createComponent() 
				.setInterface(ClusterManager.class.getName(), null) 
				.setImplementation(ClusterManagerImpl.class)
				// Authenticators whiteboard
				.add(createServiceDependency()
						.setService(ClusterService.class)
						.setCallbacks("add", "remove")));

		System.out.println("ClusterManager Activate     ");

	}
}
