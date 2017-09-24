# NimSolver

Android Application used to win the normal play version of the mathematical game of Nim. The stack values are inputted into the app, and the optimal calculated move is outputted.

### Algorithm
1. The total binary digital sum (nim-sum) of the stack values is calulated (sum A)
2. The nim-sum of the total nim-sum and each stack value is then calculated (sum B)
3. The stack with a higher stack value than Sum B is then reduced to its Sum B value.

