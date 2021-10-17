## Project made to recapitulate language features available from the Java 1.8 API
- Mainly functional as implementation strategy.
## Motivation
- Improving application performance without any specific work or tuning
- Lambda expressions, the Stream API, and new methods on existing classes are some key productivity improvements.
- The New Optional type gives developers significant flexibility when dealing with null values, reducing the likelihood of N.P.E occurrence.
- The Time API changes.
## Changes
- Fewer lines of code
    - Readable and concise
- Lambda expressions
```
List<String> names = (name) -> sop(name)
```
- Functional Interfaces
- Streams API
## Why lambda ?
Syntax:
```
   ( )              ->             ( )
    ^               |               |
    |- input(s)     |- token        |- body
```

#### 1. Lambdas
- Same as a function
- Called as an Anonymous block:
  - parameters
  - body
  - return type
- Not tied with classes
- Can be assigned to a variable
See `Syntax`.
- Functional interfaces
Syntax
```
@FunctionalInterface
public interface iName {
    void test(int a, int b);
}
```

### 2. Functional Interface
- A functional interface is an interface that contains only one abstract method.
- They expose only one functionality.
- Lambdas can be used to represent the instance of a functional interface.
- Examples: Runnable, ActionListener, Comparable.
- Can contain default and static methods.
<br><strong>Shape</strong>:
```
@FunctionalInterface                <---------- mandatory
public interface TestInterface {
    // abstract methods
    void add();
    
    // default method
    default String sayHi(){
        return "Hi";
    }
    
    static boolean isTrue() {
        return true;
    }
}
```
#### Pillar interfaces:
- Consumer
- Predicate
- Function
- Supplier

#### Method-reference
- Reference to a static method
- Reference to an instance method
- Reference to a constructor
Syntax:
```
ClassName :: methodName
```

#### Local Variables
- Lambdas are allowed to use local variables, but not allowed for modification (effectively, final)
- Concurrency operations are effective in that way
- Class level variables or instance variables are allowed to modify
- Effectively final:
    - local variables can be used but not modified within lambda functions
    - instance variables can be both used and modified within lambda functions

#### Stream
- Sequence of Data Elements
- A Java Stream can be defined as a sequence of elements from a source that supports aggregate operations on them
- Can be performed <strong>Sequentially or Parallel</strong>
- Does not support indexed access
- The initial data source is unchanged
- Lazy access supported
- Designed for lambdas
- Each intermediate operation is lazily executed and returns a stream as a result
Syntax:
```
List numbers = Arrays.asList(2,3,4,5);
List square = numbers.stream().map(x->x*x).collect(Collectors.toList());
```

#### Collection vs Streams
| Collections                  |    Streams                 |
|------------------------------|:--------------------------:|
| Read and Write               |  Read-Only                 |
| Eagerly evaluated            |  Lazily evaluated          |
| Collection about data        |  About computation on data |
| Iterate over collection      |  Internal iteration        |
| Multiple iterations possible |  Only once                 |