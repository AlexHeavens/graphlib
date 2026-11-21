# graphlib

graphlib is a small Java library of abstract data types for graphs: nodes, edges, graphs and the factories and strategy classes that build and modify them. It is an early-stage personal project, last worked on in 2016.

It is not a finished or published library: it has no releases, no graph algorithms and no stable API.

## Contents

- `graphlib-project/src`: the library (`adt`, `graph` and `patterns` packages).
- `graphlib-project/test`: JUnit tests.
- `graphlib-project/.classpath`, `.project`: Eclipse project files, kept so the project still opens in Eclipse.
- `build.gradle`, `gradlew`, `gradle/`: the build and its pinned Gradle wrapper.
- `scripts/`, `pins/`, `.githooks/`: secrets scanning and workflow linting.

## Setup

Prerequisites: JDK 17 (Gradle downloads the pinned Gradle version itself), and Docker for the workflow linter.

```
scripts/install-gitleaks.sh        # the pre-commit hook needs gitleaks
git config core.hooksPath .githooks
./gradlew jar                      # build/libs/graphlib.jar
```

## Tests

```
./gradlew build                    # compiles with warnings as errors, runs the tests; CI runs the same
scripts/lint-workflows.sh          # actionlint
```

All tests run offline.
