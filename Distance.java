package test;

public class Distance {

	
	public double calc(double lat1,double lat2,double lon1,double lon2)
	{

		double radlat1 = Math.PI * lat1/180;
		double radlat2 = Math.PI * lat2/180;
		double theta = lon1-lon2;
		double radtheta = Math.PI * theta/180;
		double dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
		double distn = Math.acos(dist);
		double dist1 = distn * 180/Math.PI;
		double dist2 = dist1 * 60 * 1.1515;
		dist2 = dist2 * 1.609344;
		return dist2;
	}
	
	public int shortest(double clon,double clat){
		double dist[]=null;
		double lat[]={17.448293,17.46221,17.432523};
		double lon[]={78.39149,78.35685,78.40702};
		//String sid[]={"Madhapur","Kondapur","Jubilie Hills"};
		int i,j,flag=0;
		for(i=0;i<3;i++){
			dist[i]=calc(clat,lat[i],clon,lon[i]);
		}
		double min=dist[0];
		for(j=1;j<3;j++){
			if(min>dist[j])
			{
				double temp=min;
				min=dist[j];
				dist[j]=temp;
				flag=j;
			}
		}
		return flag+1;
		
		
	}
}
