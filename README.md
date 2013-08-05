StreamModel
===========

Example:

  1 import java.util.Arrays;
  2
  3 public class Example {
  4     public static void main(final String... _) {
  5         for (final String s : new Stream<String>( // The template parameter need more design,
                                                      // does it need 2 parameter for input & return type?
  6                 new Stream<String>(_, new Processor<String>(){
  7                         String handle(final String s) {
  8                             return s + "ix"; // change element
  9                         }
 10                     }),
 11                     new Filter<String>(){
 12                         Boolean handle(final String s) {
 13                             return "louix".equals(s); // filte element
 14                         }
 15                     })) {
 16             System.out.println(s);
 17         }
 18         for (final String s :
 19                 new Stream<String>(_, new Processor<String>(){
 20                         String handle(final String s) {
 21                             return s + "_louix";
 22                         }
 23                     })
 24                 ) {
 25             System.out.println(s);
 26         }
 27     }
 28 }
