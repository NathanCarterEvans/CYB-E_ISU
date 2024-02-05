# What will be tested
when overriding `equals()` make sure to accept Object as the parameter
``` java
	public class Obj1{
		@Override //Will loose points for no @Override
		public boolean equals(Object o){ // Will miss a point if doesnt accept Object
			if(o == null || // Will loose point if you forget o == null
			  o.getClass() != this.getClass()){ // will loose a point if you dont check if the objects are the same
				return false;
			}
			Obj1 other = (Obj1) o; // will loose a point for not checking to see if its a descendant
			
			return o.value == this.value; // will loose a point if you dont include what should be compared
				
		}
	}
```

# Difrence between `.Equals()` and 	`==`
## When to use `.Equals()`:
When you are trying to figure out if two classes have the same value

## When to use `==`:
When you need to see if two classes are the exact same, or if you are trying to test a single value.

# Summary
``` java
public class Obj1(){
	int value;
	public void Obj1(int value){
		this.value == value;
	}
	
	@Override //you need to override this
	public boolean equals(Object Obj1){ // MAKE SURE TO HAVE `Object` AS THE TYPE
		//ALL TEST CASES
		return this.value == Obj1.value;
	}
}

public class main(){
	public void main(){
		Obj1 R = new Obj1(1);
		Obj1 S = R;
		Obj1 Q = new Obj1(1);
		Obje1 H = new Obj1(2);

		R == S; // This is true because they are the same object
		R.equals(S); // This is true because the objects have the same value 1

		R == Q; // This is false because they are different Obj despite being the same value
		R.equals(Q); // This will return true because both objects have the value 1

		R == H; // This is false because they are different objects
		R.equals(H); // This is false because the values are different. 1 != 2
	}
}
```

# In Depth
## Equals: `.equals()` vs `==`:
 `Obj1 == Obj2` is wrong in 99.99% of cases. when using the ``==`` comparator only compares slots in memory

example:
``` java
p = new Obj1(3); //value = 3; Location in memory = 0xFF01
q = new Obj1(3); //value = 3; Location in memory = 0x01F3

System.Out.Println(p==q)// Prints out false
```

The reason is because 0xFF01 is not the same as 0x01F3. Even though their values are both 3. 
In order to use ``==`` you would have to define what is being compared.

example:
``` java
p = new Obj1(3); //value = 3; Location in memory = 0xFF01
q = new Obj1(3); //value = 3; Location in memory = 0x01F3

System.Out.Println(p.value == q.value)// Prints out true
```

Alternately you can use the `.equals()` method. Every class has this as an inherited method from object.
What this does is instead of comparing points in memory, it compares every value in the Objects;

example:
``` java
p = new Obj1(3); //value = 3; Location in memory = 0xFF01
q = new Obj1(3); //value = 3; Location in memory = 0x01F3

System.Out.Println(p.equals(q))// Prints out true
```

There will be times you want .equals to only compare one variable. in that case you would need to write an `@Override`.

example of object class `@Override`:
``` java
public class Obj1{
	int value;
	public void main(int value){
		this.value = value;
	}
	
	@override
	public Boolean equals(Object obj){ // MAKE SURE TO SET THE TYPE AS 	`Object`
		//ALL TEST CASES
		return obj.value == this.value;
	}
}
```

# Example
``` java
public class IntVector{
	int dimension; // Refers to how many dimensions used... Usualy 3
	int [] cords = new int[dimension];
	
	public IntVector(int dimension, int [] cords){
		this.dimension = dimension;
		this.cord = cords;
	}
	
	@Override
	void boolean equals(Object o){
		if(o == null || o.getClass != this.getclass()){
			return false;
		}
		IntVector other = (IntVector) o;

		if (dimension != other.dimension){ // Has to be the same size
			return false;
		}
		
		for(int i = 0; i < dimension; i++){
			if(cord[i] != o.cord[i]){ // all values have to be the same
				return false;
			}
			return true
		}
	}
}

public class main{
	public void main(){
		IntVector i = new IntVector();
		i.cords[0] = 1;
		i.cords[1] = 2;
		i.cords[2] = 3;
		
		IntVector j = new IntVector();
		j.cords[0] = 1;
		j.cords[1] = 2;
		j.cords[2] = 3;
		System.out.println(i.equals(j)); // true
		System.out.println(i == j); // false
	}
}
```
