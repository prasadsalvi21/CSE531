package project1;

public class Graph1 implements Comparable {
		  int u;
		  int v;
		  int w;
		  
		  public Graph1(int u, int v, int w) {
		    this.u=u;
		    this.v=v;
		   this.w=w;
		  }
		  @Override
		  public String toString() {
		    return "(u="+u+",v="+v+",w="+w+")";
		  }

	

		public int getU() {
			return u;
		}

		public void setU(int u) {
			this.u = u;
		}

		public int getV() {
			return v;
		}

		public void setV(int v) {
			this.v = v;
		}

		public int getW() {
			return w;
		}

		public void setW(int w) {
			this.w = w;
		}
		@Override
		public int compareTo(Object o) {
			int compareage=((Graph1)o).getW();
	        /* For Ascending order*/
	        return this.w-compareage;
		}
		

		
		
		}

