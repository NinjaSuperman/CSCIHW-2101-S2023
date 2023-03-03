package HW1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");

        // Create an instance of the Pyramid class and call the Output method (see Pyramid.java for more info)
        // Compiler warns against using static method on instance here.

        Pyramid.Output();
        System.out.println("");

        // Create an instance of the Adlibs class and call the story method (see Adlibs.java for more info)
        
        Adlibs adlib_generator = new Adlibs();
        System.out.println(adlib_generator.story("Jordan", 27, "purple"));
        System.out.println("");

        // Create an instance of the Replace class and call the charReplace method (see Replace.java for more info)

        Replace replacement = new Replace();
        System.out.println(replacement.charReplace("Duck", 0, 'S'));

    }
}
