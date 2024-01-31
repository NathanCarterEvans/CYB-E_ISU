*Date:01/31/2024*
*-No Attendance-*
# Homework

- No Zybooks, but should be through chapter 5 by now

# **Summary**
- Learning @overrides
- toString() - usually need an @override
- getClass() - NEVER needs an @override
- Dynamic binding: any **static** ancestor variable accepts any descendant variable.
- If there are multiple versions of a method, only the most recent implementation will be run.

# **Lecture:**

> Parent functions can be rewritten in a child class to work differently using `@override`.
> This is useful for instance if animal has a movement method with running by default but you have a bird that flies, you can override the bird move method and make it fly.

EX:

```java
public class animal{
	public void move(){
		run();
	}
}
public class bird extends animal{
	
	@override
	public void move(){
		fly();
	}
}
```

# Memory BS
Abstracts have two slots in memory: The reference, and The class
