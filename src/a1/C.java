package a1;

public class C {
	private int v = 0;
	
	public void work(int a, C d, int[] e) {
		a = a + 1;
		v = v + 1;
		d.v += 3;
		e[0] = e[0] + 1;
	}
	
	public static void main(String[] args) {
		int f = 2;
		int[] h = {2};
		C i = new C();
		C j = i;
		i.v = 3;
		i.work(f, j, h);
		System.out.println(f + " " + h[0] + " " + i.v + " " + j.v);
	}
}
