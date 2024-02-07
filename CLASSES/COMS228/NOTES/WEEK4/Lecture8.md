*Date:02/07/2024*
*-Attendance Was Taken-*
# Homework
- 3 Zybooks, due Today
- Homework 1, due in 12-13 days
- Zybooks due Friday
- Zybooks due Monday

# **Topics**
- Equals
- Copy
# **Summary**
## Equals 
- Perfume with out of order ingredients.
How to solve this? Methods include: Sorting, and Searching.

Example how to solve with searching
``` java
public class Perfume{
	String[] Ingredients = new String[5];
	int howMany;
	public void class Perfume(String[] Ingredients, int amnt){
		this.Ingredients = Ingredients;
		this.howMany = amnt;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null || o.getClass != this.getclass()){
			return false;
		}
		Perfume other = (Perfume)o;
		
		if(this.howMnay != other.howMany){
			return false;
		}
		
		boolean flag = false;
		for(int i =0; i<howMany; i++){// for all ingredients
			flag = false; // reset flag to false
			for(int j = 0;J<howMany; j++){// for all ingredients of other
				if(this.Ingredients[i] == other.Ingredients[j]){
					flag = true;// if Ingredients[i] is not in the other Ingredients list, this will be false.
				}
			}
			if(!flag){ // if was not found, return false;
				return false;
			}
		}
	}
}

```

# **In class**

##   **Copying**

### **Deep Copying:**
Method 1: Use a copy constructor
Method 2: Write a makeCopy() method
Method 3: Overwrite the clone() method

``` java
public class Point implements Cloneable{// Only implement If using the @Override
	/*
	 * Default constructor
	 */
	Point(){}
	
	/*
	 * Parameterized constructor
	 */
	Point(int x, int y){}
	
	/*
	 * Method 1
	 * Copy Constructor
	 * Creates a new object with the same values
	 */
	Point(Point other){
		x = other.x;
		y = other.y
	}
	
	/*
	 * Method 2
	 * create a function that makes a copy
	 */ 
	public Point makeCopy(){
		Point newPoint = new Point();
		newPoint.x = x;
		newPoint.y = y;
		return newPoint;
	}
	
	/*
	 * Method 3
	 * Override Clone Function
	 * Before doing this we must
	 *  1. make the containing class implement Clonebale
	 *  2. We want to @Override clone() method
	 *  3. We want to catch an exception inside the override
	 */
	@Override
	public Point clone(){
		Point result;
		try{
			result = (Point) super.cone(); // must cast to Current Object
		} catch (CloneNotSupportedException e{
			// Do nothing
		}
		return result;
	}
}

// Example of use
// Copy Constructor
Point p = new point(1,2);
point q = new point(p);

// makeCopy()
Point p = new Point(1,2);
Point q = p.makeCopy();
				 
// Overriding clone()
point p = new Point(1,2);
point q = p.clone(); // Literly just 1:1 copies memory to a new slot
// 0xFF01223 -> 0xAD011
```
