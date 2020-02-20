import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;

public class CodeTest {

  private static String[] cmdArgs;

  public static void main(String[] args) {
    cmdArgs = args;

    println("reverseArray", CodeTest::reverseArray, new String[]{"1", "2", "3", null});
    println("uppercaseArray", CodeTest::uppercaseArray, new String[]{"aaA", "Bbb", "CCC", "ddd", null});
    println("findWordCount", params -> findWordCount(params[0], params[1]), new String[]{"Helloxx. %hello\t xxx-Hello", "Hello"});

    Function<Integer, Integer> composedFunc = composeU(x -> x * 2, y -> y * y);
    System.out.println(String.format("Composed f1(f2(4)) = (4 * 4) * 2 = %d", composedFunc.apply(4)));

    writeContentsToConsole();
    handleInvalidArgument();
    puzzle();
  }

  public static String[] reverseArray(String[] input) {
    requireNonNull(input, "Input array can't be null");

    int n = input.length;
    String[] result = new String[n];
    for (int i = 0; i < n; i++) {
      result[i] = input[n - 1 - i];
    }
    return result;
  }

  public static String[] uppercaseArray(String[] input) {
    requireNonNull(input, "Input array can't be null");

    return Arrays.stream(input)
        .map(el -> el == null ? null : el.toUpperCase())
        .toArray(String[]::new);
  }

  public static int findWordCount(String text, String wordToFind) {
    if (text == null || wordToFind == null || wordToFind.trim().isEmpty()) {
      return 0;
    }

    String[] words = text.split("(\\W|\\s)+");
    String searchWord = wordToFind.trim();
    return (int) Arrays.stream(words).filter(w -> w.equalsIgnoreCase(searchWord)).count();
  }

  public static Function<Integer, Integer> composeU(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
    return f1.compose(f2);
  }

  public static void writeContentsToConsole() {
    String filename = "sample.sql";
    InputStream resourceStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
    if (resourceStream != null) {
      System.out.println("File content:");
      new BufferedReader(new InputStreamReader(resourceStream)).lines().forEach(System.out::println);
    } else {
      throw new AssertionError("File not found: " + filename);
    }
  }

  public static void handleInvalidArgument() {
    Arrays.stream(cmdArgs).filter(arg -> !arg.chars().allMatch(Character::isDigit))
        .findAny().ifPresent(a -> {
          throw new AssertionError("Only numbers are allowed. Invalid argument: " + a);
        });
  }

  public static void puzzle() {
    String prev = null;
    for (String arg : cmdArgs) {
      if (arg.equals(prev)) {
        System.out.print("Snap");
      } else {
        System.out.print(arg);
      }
      prev = arg;
    }
    System.out.println();
  }

  private static <I> void println(String methodName, Function<I, Object> method, I input) {
    System.out.println(String.format("%s(%s) = %s: ", methodName, toString(input), toString(method.apply(input))));
  }

  private static String toString(Object obj) {
    if (obj != null && obj.getClass().isArray()) {
      return asList((Object[]) obj).toString();
    } else {
      return String.valueOf(obj);
    }
  }

}