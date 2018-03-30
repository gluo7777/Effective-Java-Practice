package org.william.effective_java;

/**
 * Hello world!
 *
 */
public class CreatingAndDestroyingObjects {
	public static void main(String[] args) {

	}
}

/**
 * Use different static factory methods instead of overriding constructors
 */
class Foo {
	int x, y;

	static final Foo FOOSINGLETON = new Foo(0, 0);

	private Foo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	static Foo xOnly(int x) {
		return new Foo(x, 0);
	}

	static Foo yOnly(int y) {
		return new Foo(0, y);
	}

	/**
	 * instance-controlled class
	 * 
	 * @param y
	 * @return
	 */
	static Foo sameInst(int y) {
		return FOOSINGLETON;
	}

	/**
	 * A third advantage of static factory methods is that, unlike constructors,
	 * they can return an object of any subtype of their return type. This gives you
	 * great flexibility in choosing the class of the returned object.
	 */
	// static Foo createSomeFooChild
}

/**
 * interface has final fields
 * @author gluo7
 *
 */
interface Boo{
	int x = 5;
	static int y = 10;
	static void doThis() {
		System.out.println("You can do this in Java 8");
	}
}