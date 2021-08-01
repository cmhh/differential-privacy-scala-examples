This is a Scala port of the examples found in [examples/java](https://github.com/google/differential-privacy/tree/main/examples/java) of Google's [Differential Privacy](https://github.com/google/differential-privacy) repository.  The code has considerably less boiler-plate than the Java version, though not _all_ of this is due to the use of Scala.  **Note this is a work in progress, and only 2 of 4 available examples have been added so far**.

There are four examples all up, all of which are runnable in their own right.  However, there is a single entry-point, `Main`, which can be run, from which users can select 1 of the 4 examples:

```bash
sbt "runMain org.cmhh.Main"
```