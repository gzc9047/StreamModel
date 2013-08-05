import java.util.Arrays;

public class Example {
    public static void main(final String... _) {
        for (final String s : new Stream<String>( // The template parameter need more design
                                                  // does it need 2 parameter for input & return type?
                new Stream<String>(_, new Processor<String>(){
                        String handle(final String s) {
                            return s + "ix";
                        }
                    }),
                    new Filter<String>(){
                        Boolean handle(final String s) { // filte element
                            return "louix".equals(s);
                        }
                    })) {
            System.out.println(s);
        }
        for (final String s :
                new Stream<String>(_, new Processor<String>(){
                        String handle(final String s) {
                            return s + "_louix";
                        }
                    })
                ) {
            System.out.println(s);
        }
    }
}
