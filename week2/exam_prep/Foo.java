
public class Foo {
	public int x, y;

	public Foo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void switcheroo(Foo a, Foo b) {
		/**
		 * classical one: switch doesn't switch foobar with baz, pass by value a, b
		 * copies the addresses of foobar and baz variable, but all the function below
		 * is doing is just swap a,b values, which are addresses copied from foobar and
		 * baz, it only affect a,b references, not affecting foobar, baz values. imaging
		 * a points to foobar variable and b points to baz variable, after the function,
		 * a points to baz, b points to foobar, foobar and baz points to the same
		 * location as before.
		 */
		Foo temp = a;
		a = b;
		b = temp;
	}

	public static void fliperoo(Foo a, Foo b) {
		Foo temp = new Foo(a.x, a.y);
		a.x = b.x;
		a.y = b.y;
		b.x = temp.x;
		b.y = temp.y;
	}

	public static void swaperoo(Foo a, Foo b) {
		Foo temp = a;
		a.x = b.x;
		a.y = b.y;
		b.x = temp.x;
		b.y = temp.y;
	}

	public static void main(String[] args) {
		Foo foobar = new Foo(10, 20);
		Foo baz = new Foo(30, 40);
		/** guess what will print out before running the program */

		switcheroo(foobar, baz);
		System.out
				.println("Foobar x: " + foobar.x + " Foobar y: " + foobar.y + " Baz x: " + baz.x + " Baz y: " + baz.y);
		fliperoo(foobar, baz);
		System.out
				.println("Foobar x: " + foobar.x + " Foobar y: " + foobar.y + " Baz x: " + baz.x + " Baz y: " + baz.y);
		/** remember foobar and baz hasve been flipped */
		swaperoo(foobar, baz);
		System.out
				.println("Foobar x: " + foobar.x + " Foobar y: " + foobar.y + " Baz x: " + baz.x + " Baz y: " + baz.y);

	}
}