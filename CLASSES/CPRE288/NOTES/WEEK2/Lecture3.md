*01/23/224*

# Home Work
- [ ] Prelab due Wednesday
- [ ] Homework 1 assigned today

# Summary
>We  learned how the cpu talks to the ports on the GPIO bored and then send that data to a LCD. It does this by uploading data to the GPIO which talks to a  register. This is 100% memory management like Assembly or pointers. 
>Key points include being able to write hex values whether they be signed or unsigned to a register via a GPIO port. 
>We will be using C from what it seems. 

# Notes
* Lab needs to be demoed before next lab... DO IN LAB
* Read Instructions before homework
* Yes CHATGPT?
> MCU has a CPU. We write code to a CPU. 
> We need a way to interface with OBJECT in this case LCD screen
> Has some sort of bus or wiring from MCU to LCD screen
> Step one for pre lab is drawing a picture [MCU] <-> [LCD]

* char is not implicit and changes based on the complier
* Learn your data types - Primitives are your friend

<br>

*This is an infinity loop*
```c
void main(){
	while (1); // do forever
}
```
*Hello world program*
```c
#include <studio.h>

void main(){
	printf("hello, world\n");
}
```


