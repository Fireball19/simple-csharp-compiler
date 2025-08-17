# simple-csharp-compiler

[![Java CI with Gradle](https://github.com/Fireball19/simple-csharp-compiler/actions/workflows/gradle.yml/badge.svg)](https://github.com/Fireball19/simple-csharp-compiler/actions/workflows/gradle.yml)

## How to run

#### 1. Run SableCC

```
java -jar libs/sablecc.jar -d src simple_csharp_grammar.scc
```

Move lexer.dat and parser.dat from src/main/java/sablecc to build/classes/java/main/sablecc.

#### 2. Run the StupsCompiler with Gradle

```
./gradlew run --args='-mode <filename.cs>'
```

#### 3. Run the Jasmin assembler

```
java -jar libs/jasmin/jasmin.jar <filename.j>
```

#### 4. Run the generated Java file

```
java <filename>
```
