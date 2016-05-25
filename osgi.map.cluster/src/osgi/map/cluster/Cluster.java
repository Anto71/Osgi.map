package osgi.map.cluster;

import osgi.map.arraySet.ArraySet;
import osgi.map.dataService.api.dataService;
import osgi.map.tuple.Tuple;

public class Cluster {
	private Tuple centroid;

	private ArraySet clusteredData; 
	
	/*Cluster(){
		
	}*/


	public Cluster(Tuple centroid){
		this.centroid=centroid;
		clusteredData=new ArraySet();
		
	}
		
	public Tuple getCentroid(){
		return centroid;
	}
	
	public void computeCentroid(dataService data){
		for(int i=0;i<centroid.getLength();i++){
		//	centroid.get(i).update(data,clusteredData);
	//		System.out.println(" "+i +" "+centroid.get(i));
			data.update(clusteredData, centroid.get(i));
	//		System.out.println(" "+i +" "+centroid.get(i));
		}
		
	}
	//return true if the tuple is changing cluster
public	boolean addData(int id){
		return clusteredData.add(id);
		
	}
	
	//verifica se una transazione è clusterizzata nell'array corrente
	public boolean contain(int id){
		return clusteredData.get(id);
	}
	

	//remove the tuplethat has changed the cluster
	public void removeTuple(int id){
		clusteredData.delete(id);
		
	}
	
	public String toString(){
		String str="Centroid=(";
		for(int i=0;i<centroid.getLength();i++)
			str+=centroid.get(i);
		str+=")";
		return str;
		
	}
	

	
	public String toString(dataService data){
		String str="Centroid=(";
		for(int i=0;i<centroid.getLength();i++)
			str+=centroid.get(i)+ " ";
		str+=")\nExamples:\n";
		int array[]=clusteredData.toArray();
		for(int i=0;i<array.length;i++){
			str+="[";
			for(int j=0;j<data.getNumberOfExplanatoryAttributes();j++)
				str+=data.getAttributeValue(array[i], j)+" ";
			str+="] dist="+getCentroid().getDistance(data.getItemSet(array[i]))+"\n";
			
		}
	//	str+="\nAvgDistance="+getCentroid().avgDistance(data, array);
		return str;
		
	}

}
