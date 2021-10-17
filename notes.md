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