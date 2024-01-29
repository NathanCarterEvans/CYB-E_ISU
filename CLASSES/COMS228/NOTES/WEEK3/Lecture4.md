*Date:01/29/2024*
*-No Attendance-*
# Homework

- *NO ZYBOOKS (Do Zybooks Anyways)*
- *HW1 Delayed*

# **Summary**
- We discussed inheritance and how object trees work.
- We also briefly touched on Abstract classes

# **Lecture:**

### Review
> Inheritance has an IS A relationship
> EX: Grasshopper is an insect

``` java
public class Insect { //this makes a car object to be called
	public static void Insect() {
			//Stuff
    }
}

/*----------------------------------------*/

public class Grasshopper Extends Insect{
	public static void grasshopper(){
		//Stuff
	}
}

/*----------------------------------------*/
public class Main { 
	static void main(){
		Grasshopper Ghopper = new Grasshopper();
		//Ghopper is a grass hopper and an insect
  }
}
```
## How Memory works

|Memory|Class|Data|Code Ran|
|---|---|---|---|
|0x0001|Bee|Memory Start| `Public class Pollinator {int pollen;}`|
|0x0010|Pollinator|Memory End| |
|0x0100|Bee|Memory Start| `Public class Bee Implements Pollinator {}`|
|0x1000|Bee|Memory End| |
|0x0200|Bee|Obj|`Bee b = new Bee();`|
|0x0002|Pollinator|Obj|`b.pollen = 10;`|

notice how it writes to the pollinator class instead of the bee class. Memory is weird. Memory locations are [#stupid]().

## Casting
``` java
public class Insect { //this makes a car object to be called
	public static void Insect() {
			//Stuff
    }
}

/*----------------------------------------*/

public class Grasshopper Extends Insect{
	public static void grasshopper(){
		//Stuff
	}
}

/*----------------------------------------*/
public class Main { 
	static void main(){
		//Setup
		Grasshopper Ghopper = new Grasshopper();
		Grasshopper cricket_ = new Grasshopper();
		
		Insect cricket = (Insect) cricket;
		// You can type cast as long the object being casted is an ancestor of the main object
		
		Insect weirdHopper = new Grasshopper();
		//You are able to create a new object as long as it is it implements a child
		
		Grasshopper badHopper = new Insect();
		//This does not work as Grasshopper is a child of Insect. Parents cant be assigned to children.
  }
}
```


