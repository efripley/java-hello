package helloworld;

import static kiss.API.*;

public class HelloWorld {
    void testRun() {
        outExpect("Hello World!");
        run();
        outClose();
    }
    
    void run(){
        println("Hello World!");
    }

    void testInts(){
    	assert Integer.MAX_VALUE == Math.pow(2, 31) - 1;
    	assert Integer.MIN_VALUE == -Math.pow(2, 31);
    	assert Integer.MIN_VALUE - 1 == Integer.MAX_VALUE;
    	assert Integer.MAX_VALUE + 1 == Integer.MIN_VALUE;

    	int x = 3;
    	int y = 0xff_ff;
    	int z = 0b10_01;

    	assert x == 3;
    	assert y == 65_535;
    	assert z == 9;

    	assert Integer.toString(x, 10).equals("3");

    	assert 17 / 5 == 3;
    	assert ((double) 17) / ((double) 5) == 3.4;
    	assert (double)(17 / 5) == 3.0;

    	assert 17 % 5 == 2;
    	assert -7 % 5 == -2;
    }
}
