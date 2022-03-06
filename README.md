# MonteCarloPi

## What is a Monte-Carlo Simulation?
We can estimate π using the so-called Monte-Carlo Simulations. What’s the idea behind a Monte-Carlo Simulation?
Monte-Carlo Simulations are experiments or computational algorithms that rely on sampling of random numbers. 
An experiment or a simulation of random numbers is repeated a large number of times to estimate something that may 
be determined deterministically as well (such as π, as it is a deterministic number, i.e. it does not depend on 
randomness or chance).
Monte-Carlo Simulations are used whenever calculating something in a deterministic fashion is too computationally 
expensive or not feasible anymore. Or when you’re just too lazy to compute something exactly.
So let’s use some randomness to estimate our favorite number π.
## The Unit Square and the Unit Circle
The area of a circle is computed with the radius r:

![](/readme-resources/equation.png)

Considering the unit circle with the radius r = 1, we can ignore the radius. Next, we focus only
on a quadrant of this unit circle and the unit square. That is the formula for π:

![](/readme-resources/equation(1).png)

This chart displays a quadrant in a unit square. The green points are inside the quadrant and the red ones are outside.

![](/readme-resources/unitcircle_pi.webp)

All points are inside the quadrant if the following equation is fulfilled:

![](/readme-resources/equation(2).png)

The relative frequency *h* is determined by the ratio of the points falling in the quarter circle *q* 
to the total number of points *n*.

![](/readme-resources/equation(3).png)

Therefore, we can estimate π:

![](/readme-resources/equation(2).png)

Thanks to the law of large numbers, we will eventually come very close to π.
## Usage
You can clone the repository and build the program by yourself, or you can download the release. Anyway it's very simple 
to use:
```
java -jar MonteCarloPi.jar 1eX
```
The parameter *1eX* represents the number of points simulated onto the plane. *X* is your exponent of choice and 
in order to get a significant result **must** be greater than or equal to 3.