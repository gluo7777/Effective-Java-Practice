package org.william.effective_java;

public class AbstractBuilderWithoutCasting {

	public static void main(String[] args) {
		IdObj myId = new IdObj.IdObjBuilder().name("William").id(316549).build();
		System.out.println(myId.name + " " + myId.id);
	}

}

class IdObj extends Obj {

	long id;

	static class IdObjBuilder extends Obj.Builder<IdObjBuilder> {

		long id;

		IdObjBuilder id(long id) {
			this.id = id;
			return this;
		}

		@Override
		IdObjBuilder self() {
			return this;
		}

		@Override
		IdObj build() {
			return new IdObj(this);
		}

	}

	IdObj(IdObjBuilder builder) {
		super(builder);
		this.id = builder.id;
	}

}

abstract class Obj {
	String name;

	abstract static class Builder<T extends Builder<T>> {
		String name;

		T name(String name) {
			this.name = name;
			return self();
		}

		/**
		 * Simulated self-type override in child classes to ‘return this’
		 * 
		 * @return
		 */
		abstract T self();

		/**
		 * Covariant return typing override in child classes to return a new instance of
		 * the child class
		 * 
		 * @return
		 */
		abstract Obj build();
	}

	Obj(Builder<?> builder) {
		this.name = builder.name;
	}
}
