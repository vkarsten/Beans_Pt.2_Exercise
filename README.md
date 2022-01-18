# Beans Pt. 2

In this exercise, we'll be creating multiple beans, using both `@Component` and `@Beans`, as well
as `@Primary` and `@Qualifier` to distinguish the beans from the same type.

We'll be creating an interface that holds a message, and its different implementations outputs the
message in the desired language.

#

## Step 1: Setting Up the Project

The first step is to create a new Spring Boot application. You can do that by heading to
the [Spring Initializr](https://start.spring.io/) page.

The project doesn't require any extra dependency.

#

## Step 2: The `MessageHolder` Interface

Next you should create the `MessageHolder` interface. This is the interface that returns a message
of a given language.

The interface should be as simple as:

```java
public interface MessageHolder {

  String message();
}
```

After that, you should create a couple implementations of this interface. The `message()` method
should simply return `Hello World!` in different languages.

Create five implementations of it, with the following outputs:

- `EnglishMessageHolder` - `Hello World!`
- `GermanMessageHolder` - `Hallo Welt!`
- `SpanishMessageHolder` - `Hola Mundo!`
- `ItalianMessageHolder` - `Ciao Mondo!`
- `FinnishMessageHolder` - `Hei Maailma!`

You should declare each of these as spring beans using the `@Component` annotation.

For the `EnglishMessageHolder`, you should also annotate it with the `@Primary` annotation.

For the others, they should use the `@Qualifier` annotation with its specific language as the
qualifier, i.e. `@Qualifier("de")` for German, `@Qualifier("es")` for Spanish and so on.

#

## Step 3: The `MessageFormatter` Interface

The `MessageFormatter` interface will be responsible for formatting our message in a beautiful way.

It should be as simple as:

```java
public interface MessageFormatter {

  String format(String message);
}
```

The `MessageFormatter` should have a simple implementation, that will print the message in a better
way. You can implement it your own way, or you can use the following implementation:

```java
public class DefaultMessageFormatter implements MessageFormatter {

  private static final String ANSI_PURPLE = "\u001B[35m";

  private static final String ANSI_YELLOW = "\u001B[33m";

  private static final String ANSI_RESET = "\u001B[0m";

  @Override
  public String format(String message) {
    return String.format(
        "%sThe message is: [%s%s%s].%s",
        ANSI_PURPLE, ANSI_YELLOW, message, ANSI_PURPLE, ANSI_RESET);
  }
}
```

For this bean, you should create a `@Configuration` class and declare the `MessageFormatter` using
the `@Bean` annotation.

#

## Step 3: The Tests

Now it's time to write the `@SpringBootTest` class.

The class should contain 5 tests, one for each of the `MessageHolder` implementations.

Since we only have one instance of `MessageFormatter`, it can then be autowired directly into the
test class as a field. For the `MessageHolder`, though, you should inject the right implementation
on the right method, thus this injection should be done as a method parameter.

For the **English** test, no qualifier should be needed, as it's marked as `@Primary`, so
the `@Autowired` annotation should be enough.

For the other tests, though, you should also use the `@Qualifier` on the method parameter as well,
with the specific qualifier you need for the given test.

On each test, you should simply format the message coming from the `MessageHolder` using
the `MessageFormatter`:

```java
String formattedMessage=messageFormatter.format(messageHolder.message());
```

Then you should print the message on the console, and assert that the message contains the text you
expect.

I.e. for the **English** test, the following assertion should be done:

```java
Assertions.assertTrue(formattedMessage.contains("Hello World!"));
```

If everything is done correctly, you should see a similar output as a test result:

![img.png](img.png)

As well as a similar output on the console:

![img_1.png](img_1.png)