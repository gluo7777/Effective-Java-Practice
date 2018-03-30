package org.william.effective_java;

import java.util.Objects;
import java.util.function.Supplier;

public class DependencyInjection_FactoryMethodPattern {
	
	static interface Thing{
		String getName();
	}
	
	static interface ThingFactory extends Supplier<Thing>{}

	static class ThingUtility{
		private final Thing thing;

		public ThingUtility(ThingFactory factory) {
			super();
			Objects.requireNonNull(factory);
			this.thing = factory.get();
		}
		
		public void printName() {
			System.out.println(this.thing.getName());
		}
		
	}
	
	public static void main(String[] args) {
		ThingFactory williamThing = new ThingFactory() {
			@Override
			public Thing get() {
				return new Thing() {		
					@Override
					public String getName() {
						return "William";
					}
				};
			}
		};
		ThingFactory lisaThing = new ThingFactory() {
			@Override
			public Thing get() {
				return new Thing() {		
					@Override
					public String getName() {
						return "Lisa";
					}
				};
			}
		};
		ThingUtility thingUtility = new ThingUtility(williamThing);
		thingUtility.printName();
		thingUtility = new ThingUtility(lisaThing);
		thingUtility.printName();
	}

}
