package a1;

public class A {
	private int count = 1;
	public int value = 2;
	public A() {}
	public void add() {
		count += 1;
	}
	public void change() {
		add();
	}
	public int getCount() {
		return count;
	}
}
