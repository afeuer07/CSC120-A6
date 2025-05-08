Use this file to record your reflection on this assignment.

What are your initial impressions of how `Unit Testing` affects your programming?
What worked, what didn't, what advice would you give someone taking this course in the future?


Unit testing does seem really useful for debugging as you go and avoiding errors that are impossible to find. This was pretty straightforward with the exception of the last test, testTrainPrintManifest. I had to look up a way to get the printed output in order to compare it to my expected output and I think that works fine, but it still fails despite the expected and actual looking exactly the same in the fail message as far as I can tell. I ran out of time to figure that issue out so I may end up resubmitting this later. 

testEngineConstructor
This creates an engine and asserts that the expected fuel type and current fuel level match what is returned by getFuelType() and getCurrentFuel(), respectively.

testEngineGo
This asserts that go() returns true when run, and that it correctly reduces the fuel by 20% bby asserting that e.getCurrentFuel() is equal to 80. (The engine has a maxFuel of 100).

testCarAddPassenger
This adds a passenger to a car qwith a capacity of 1 and asserts that the seatsRemaining method returns 0, indicating that the passenger was indeed added.

testCarRemovePassenger
This asserts that removePassenger() returns false when there is no passenger in the car and also that it returns true if the passenger was added before being removed.

testPassengerBoardCarWithSpace
This asserts that boardCar returns true if there was space on the car and a passenger was added.

testPassengerBoardCarFull
This adds a passenger to a full car and asserts that addPassenger() returns false.

testTrainConstructor
This checks that the correct number of cars of a certain capacity are on the train by asserting that 2 equals the return of getMaxCapacity for a train with 2 cars of 1 seat each.

testTrainPassengerCount
This checks that the train can count its remaining seats correctly by adding and then removing a passenger and checking each time if t.seatsRemaining equals the expected value.

testTrainGetCar
This makes sure the cars are not null and then asserts that there are two different cars on the train. This ensures getCar is accessing each car.

testTrainPrintManifest
This captures the printed output from printManifest and sets up a train with two cars and two passengers. It then asserts that the printManifest output matches the expected output based on the passengers in the train. It doesn't work and I don't know why.


