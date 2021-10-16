# PrimeNumberApp Thread Exercise

![image](https://user-images.githubusercontent.com/78410623/137588122-420532bb-5fa2-4cbf-b792-503bbcd39a69.png)


 The task is to implement an application that can solve prime-related invoices.   The app has its own "workerthread" that calculates prime number calculations. The thread is started when the program starts. A communication route must be built between the UI and WorkerThread.


The application has functionality that can be used to find out if a number is a prime number. The user must be able to enter the desired number and press the button, in which case the application will check whether it is a prime number (the check must be done in WorkerThread, the result must be visible to the user)

The application has functionality that can be used to find out, for example, the first two dozen prime numbers. The user should be able to enter how many prime numbers he wants and press a button to let the application find out
the desired number of prime numbers (the check must be done in WorkerThread, the result must be visible to the user)

The third functionality of the application can be used to determine the division of a number into factors (prime numbers)

The user must be able to enter the desired number on the screen and press the button, in which case the application must find out the division into factors (the check must be done in WorkerThread, the result must be visible to the user)
