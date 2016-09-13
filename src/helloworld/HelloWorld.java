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

   int a = 1;
   ++a;

   try(Close out = outExpect("2")){
    println(a);
  }

  try(Close out = outExpect("3")){
    println(++a);
  }

  try(Close out = outExpect("3")){
    println(a);
  }

  try(Close out = outExpect("3")){
    println(a++);
  }

    assert (~0b0000_0000_0000_0000_0000_0000_1111_0000) == 0b1111_1111_1111_1111_1111_1111_0000_1111; //bitwise not (flips)

    assert (0b1111_0000 & 0b1010_1010) == 0b1010_0000; //bitwise and (if either value is false[0] then result will be false[0])

    assert (0b1111_0000 | 0b1010_1010) == 0b1111_1010; //bitwise or (if either value is true[1] then result will be true[1])

    assert (0b1010_1111 >> 4) == 0b0000_1010; //bitshift right shifts the sign bit in

    assert (0b1010_1111 << 4) == 0b1010_1111_0000; //bitshift left

    println(a);

    int b = random(0, 1000000);

    println(b);

    int c = random(-1000000, 1000000);

    println(c);

    assert ((~c) + 1) == -c;

    println(Integer.toString(-2, 2));

    assert (b >> 1) == b / 2;
    assert (b << 1) == b * 2;

    assert -2 == 0b1111_1111_1111_1111_1111_1111_1111_1110;
  }

  void testConvert(){
    byte x = -1;
    assert x == (byte)0b1111_1111;

    int y = x;

    assert y == -1;
  }

  void testLoop(){

    try(Close out = outExpect(0, EOL, 1, EOL, 2, EOL, 3, EOL)){
      int n = 4;
      int i = 0;

      while(i < n){
        println(i);
        ++i;
      }
    }

    try(Close out = outExpect(0, EOL, 1, EOL, 2, EOL, 3, EOL)){
      int n = 4;
      for(int i = 0; i < n; ++i){
        println(i);
      }
    }

    try(Close out = outExpect(0, EOL, 1, EOL, 3, EOL)){
      int n = 4;
      int i = 0;

      while(i < n){
        if(i == 2){
          ++i;
          continue;
        }
        println(i);
        ++i;
      }
    }


    try(Close out = outExpect(0, EOL, 1, EOL, 3, EOL)){
      int n = 4;
      for(int i = 0; i < n; ++i){
        if(i == 2)
          continue;
        println(i);
      }
    }

    try(Close out = outExpect(0, EOL, 1, EOL)){
      int n = 4;
      int i = 0;

      while(i < n){
        if(i == 2)
          break;
        println(i);
        ++i;
      }
    }

    try(Close out = outExpect(0, EOL, 1, EOL)){
      int n = 4;
      for(int i = 0; i < n; ++i){
        if(i == 2)
          break;
        println(i);
      }
    }

    String [] words = new String[] {"this", "that", "the other"};
    assert words[0].equals("this");
    assert words[1].equals("that");
    assert words[2].equals("the other");
    assert words.length == 3;

    String [] nouns = new String[2];
    assert nouns[0] == null;
    assert nouns[1] == null;
    assert nouns.length == 2;

    try(Close out = outExpect("this", EOL, "that", EOL, "the other", EOL)){
      for(int a = 0; a < words.length; a++){
        println(words[a]);
      }
    }
    try(Close out = outExpect("this", EOL, "that", EOL, "the other", EOL)){
      for(String word : words){
        println(word);
      }
    }
  }
}
