package a1;

public class B extends A{
	public B() {super();}
	public void add() {
		value += 10;
	}
	
	public static void main(String[] args) {
		B thing = new B();
		thing.change();
		System.out.println(thing.getCount() + " " + thing.value);
	}
}
