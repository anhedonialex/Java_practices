import java.util.Scanner;

public class StringTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        String input = scanner.nextLine();

        System.out.println("Reversed string: " + new StringBuilder(input).reverse().toString());
        System.out.println("String in Lower Case: " + input.toLowerCase());
        System.out.println("String in Upper Case: " + input.toUpperCase());
        System.out.println("Replace vovel: " + input.replaceAll("[aeiou]", "*"));
    }
}
