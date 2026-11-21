# graphlib

- Run: a library with no entry point. `./gradlew jar` builds `build/libs/graphlib.jar`.
- Test: `./gradlew build` (compiler warnings are errors). Lint workflows: `scripts/lint-workflows.sh`.
- Docs: `README.md` for setup. Source lives in `graphlib-project/src`, tests in `graphlib-project/test`.
- Before each commit, check the staged diff for secrets. The pre-commit hook needs `git config core.hooksPath .githooks`.
