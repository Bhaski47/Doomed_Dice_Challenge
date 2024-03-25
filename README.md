# Doomed Dice Challenge
Problem Statement: The Doomed Dice Challenge

# SOLUTION
## PART-A
## 1)	How many total combinations are possible? Show the math along with the code!

To calculate the combinations there are two ways such as additive and multiplicative principles.

Additive Principle:
The logic is that calculate the total combinations by considering each outcome on one die paired with each outcome on the other die.if we have a standard six-sided die, we can roll it and get any number from 1 to 6. If we roll it again, we can get another number from 1 to 6. To find the total combinations, we simply add up all possible pairs of outcomes.
For Example:
Since there are 6 outcomes on the first die and 6 outcomes on the second die, you add up all possible pairs: 6+6+6+6+6+6=36

Multiplicative Principle:
The logic is that each die has six sides, so there are 6 possible outcomes for each die. Therefore, the total number of combinations is 6×6=36.

![image](https://github.com/Bhaski47/Doomed_Dice_Challenge/PartA1.java_Output)

## 2)	Calculate and display the distribution of all possible combinations that can be obtained when rolling both Die A and Die B together. Show the math along with the code!

The total possible combinations can be calculated by using multiplicative
principle i.e. dieA x dieB. The code uses two nested loops
to iterate through all possible combinations of faces on Die A and Die B.
The outer loop iterates over the faces of Die A, and the inner loop
iterates over the faces of Die B and prints all the possibilities.

![image](https://github.com/Bhaski47/Doomed_Dice_Challenge/PartA2.java_Output)

## 3)	Calculate the Probability of all Possible Sums occurring among the
number of combinations from (2).

The logic is that to calculate the probabilities of all possible sums that can occur when two six-sided dice are rolled.Firstly, it constructs a distribution representing the sums resulting from all combinations of face values on the two dice.Then, it computes the probability of each sum by counting the occurrences of each sum in the distribution and dividing by the total number of combinations. Finally, it displays the calculated probabilities for each sum from 2 to 12
### Example:
•	Consider rolling two six-sided dice. 
•	The code calculates the likelihood of obtaining each possible sum, ranging from 2 to 12.
•	For instance, when both dice show a face value of 1, the sum is 2. 
•	By iterating through all potential combinations of face values on the two dice and tallying the occurrences of each sum, the code determines the probability of each outcome. 
•	Finally, it presents the probabilities, offering insights into the relative likelihoods of different sums when rolling the dice.

![image](https://github.com/Bhaski47/Doomed_Dice_Challenge/PartA3.java_Output)

## PART-B

The combined outcomes of rolling two dice, represented by arrays dieA and dieB, maintain specific probabilities. This adjustment is achieved by first calculating a scaling factor derived from the total sums of the face values of both dice. Subsequently, dieA's face values are constrained within the range of 1 to 4. Following this, the code computes the original frequency distribution representing all possible sums resulting from rolling dieA and dieB. It then adjusts this distribution using the previously calculated scaling factor.
After the adjustment, the code recalculates the probabilities associated with each sum, both before and after the adjustment process. These probabilities are then printed out for comparison. Finally, the adjusted face values of dieB are returned, and both dieA and dieB's modified values are displayed. By undergoing this process, the code ensures that the probabilities linked with the combined outcomes of rolling both dice remain consistent even after the adjustment.

![image](https://github.com/Bhaski47/Doomed_Dice_Challenge/PartB.java_Output)