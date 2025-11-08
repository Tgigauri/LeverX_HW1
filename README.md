In order to compile the program you need to run following command on your windows machine:
javac -cp ".;libs/jansi-2.4.0.jar" Main.java model/Tea.java


To run the program run the following command
java -cp ".;libs/jansi-2.4.0.jar" Main


And in order to buikd ab executable JAR file run following command:
jar cfe Main.jar Main -C . .

Then you will be able to run the JAR file
java -cp "Main.jar;libs/jansi-2.4.0.jar" Main  
