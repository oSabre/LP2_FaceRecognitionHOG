package modelo;

public class GuardaInfo {
	private float dist;
	private String e_ou_n;
	
	public GuardaInfo(String x, float f) {
		dist = f;
		e_ou_n = x;
	}
	
	public float getDist() {
		return dist;
	}
	public void setDist(float dist) {
		this.dist = dist;
	}
	public String getE_ou_n() {
		return e_ou_n;
	}
	public void setE_ou_n(String e_ou_n) {
		this.e_ou_n = e_ou_n;
	}
	
	
}
