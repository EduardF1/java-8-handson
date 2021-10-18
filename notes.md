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

### 1. Lambdas
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
### Pillar interfaces:
- Consumer
- Predicate
- Function
- Supplier

### Method-reference
- Reference to a static method
- Reference to an instance method
- Reference to a constructor
Syntax:
```
ClassName :: methodName
```

### Local Variables
- Lambdas are allowed to use local variables, but not allowed for modification (effectively, final)
- Concurrency operations are effective in that way
- Class level variables or instance variables are allowed to modify
- Effectively final:
    - local variables can be used but not modified within lambda functions
    - instance variables can be both used and modified within lambda functions

### Stream
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

### Collection vs Streams
| Collections                  |    Streams                 |
|------------------------------|:--------------------------:|
| Read and Write               |  Read-Only                 |
| Eagerly evaluated            |  Lazily evaluated          |
| Collection about data        |  About computation on data |
| Iterate over collection      |  Internal iteration        |
| Multiple iterations possible |  Only once                 |

### Stream API operations
- map():
    * Transform one type of data to another type of data
    * Not the Map Collection
- flatMap():
    * Transform one type of data to another type of data
    * Used to flatten a stream of a collection
    * Applying 1..* transformation(s) to the elements
    * Create a new stream once the elements are flattened
- sorted():
    * Perform basic sorting, i.e. arrange elements alphabetically
    * Or perform custom object sorting (based on the given attribute)
- filter():
    * Filter the data within the stream based on a predicate (condition/test)
- reduce():
    * Perform an operation on each of the elements of the stream, the operation is user-defined.

### Factory Methods
| Collections                  |    Streams                                                   |
|------------------------------|:------------------------------------------------------------:|
| Stream.iterate               |  Returns infinite sequential order stream                    |
| Stream.generate              |  Returns infinite unordered stream                           |
| Stream.of                    |  Returns sequential ordered stream with the specified values |

### Numeric Stream
- A stream of primitive type references.

| Stream Types                 |    Contained data type |
|------------------------------|:----------------------:|
| IntStream                    |  Primitive int         |
| LongStream                   |  Primitive long        |
| DoubleStream                 |  Primitive double      |

### Boxing vs Unboxing
- Boxing : convert primitives to wrapper types
- Unboxing : convert wrapper types to primitives

### Sequential vs Parallel
| Sequential                                      |    Parallel                                                          |
|-------------------------------------------------|:--------------------------------------------------------------------:|
| Works just like a for-loop using a single core  | Divide the provided task into many and run them in different threads |
| Runs on Single core                             | Runs on multiple cores                                               |
| Supports Lazy evaluation                        | Supports Lazy evaluation                                             |
| Usage based on the the required task            | Usage based on the required task                                     |

```
Sequential
                    |--------------|  |--------------|  |--------------|  |--------------|  |--------------|  |--------------|    
Sequential: core 1  |  Iteration 1 |  |  Iteration 2 |  |  Iteration 3 |  |  Iteration 4 |  |  Iteration 5 |  |  Iteration 6 |    
                    |--------------|  |--------------|  |--------------|  |--------------|  |--------------|  |--------------|    

                  |--------------|  |--------------|      
Parallel: core 1  |  Iteration 2 |  |  Iteration 5 |      
                  |--------------|  |--------------|    
                   
                  |--------------|
          core 2  |  Iteration 1 |
                  |--------------|
                  
                  |--------------|  |--------------|
          core 3  |  Iteration 3 |  |  Iteration 4 |
                  |--------------|  |--------------|
          
                  |--------------|
          core 4  |  Iteration 6 |
                  |--------------|        
                  
          |------------------------------------------------- TIME ----------------------------------------------------------->        
```
- Whenever choosing between sequential and parallel streams, one should always consider thoroughly whether it is or not necessary,
will the usage of a parallel stream improve performance, will the end computation be valid (numeric computations have a high change of error).

### Optional
- Is a container object used to contain not-null objects.
- Used to represent null values with absent values.
- Has a variety of utility methods to facilitate code that handles
values as 'available' or 'not available' instead of checking null values.
- Null checks are not required and no more N.P.E at runtime.
- No more boilerplate code.

#### Optional-Methods
| Method                       |    Description                                                                                        |
|------------------------------|:-----------------------------------------------------------------------------------------------------:|
| empty()                      |  Returns an empty Optional instance                                                                   |
| of(T value)                  |  Returns an Optional with the specified present not null value                                        |
| ofNullable(T value)          |  Returns an Optional Describing the specified value, if not null, otherwise returns an empty Optional |

### Interfaces
- Define a contract that will be implemented by client classes.
- No implementation allowed within the interface.
- Changes to interface not possible.
Types: Static and Default

| `Default`                                                 |    `Static`                                                              |
|---------------------------------------------------------|:----------------------------------------------------------------------:|
| The `default` keyword allows creating methods with body |  Traditional `static` method which allows creation of a method with body |
| Allowed to Override                                     |  Override not allowed                                                  |
| Access using interface object                           |  Access only through the interface name                                |
| Extension possible                                      |  Limited access                                                        |