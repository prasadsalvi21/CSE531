package project1;

public class Graph1 {
		  int u;
		  int v;
		  int w;
		  
		  public Graph1 (int u, int v, int w) {
		    this.u=u;
		    this.v=v;
		   this.w=w;
		  }
		  
		  public String toString() {
		    return "(" + u + ",w=" + w + ")";
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
		
		}

