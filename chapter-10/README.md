# Chapter 10: Enforce Testing into Workflow

## Step 1: Create GitHub Actions Workflow

- `.github/workflows` and `ci.yml`

```yml
name: Automate Workflow
on:
    push:
        branches: [ main ]

jobs:
    unit-test:
        name: Run Unit Test
        runs-on: ubuntu-latest
        steps:
            -   name: Checkout Code
                uses: actions/checkout@v3
            -   name: Setup Java17
                uses: actions/setup-java@v3
                with:
                    java-version: '17'
                    distribution: 'zulu'
            -   name: Run Unit Tests
                run: ./gradlew test
```

## Step 2: Push to GitHub

## Step 3: Git Hooks: Pre-Commit

- Create `git-hooks/pre-commit`

```bash
./gradlew test
```

## Step 4: Install Pre-Commit

```bash
./gradlew installGitHooks
```

## Step 5: Commit and Make it fail

## Step 6: Introduce Spotless and Walkthrough

```groovy
plugins {
	id 'com.diffplug.spotless' version '6.22.0'
}

spotless {
    java {
        removeUnusedImports()
        indentWithTabs()
    }
}
```

## Step 7: Add Spotless to Pre-Commit

- `git-hooks/pre-commit`
```bash
./gradlew spotlessCheck
```

## Step 8: Add Linter(Spotless) into Workflow

- `.github/workflows/ci.yml`
```yml
name: Automate Workflow
on:
    push:
        branches: [ main ]

jobs:
    linter:
        name: Run Linter
        runs-on: ubuntu-latest
        steps:
            -   name: Checkout Code
                uses: actions/checkout@v3
            -   name: Setup Java17
                uses: actions/setup-java@v3
                with:
                    java-version: '17'
                    distribution: 'zulu'
            -   name: Run Linter
                run: ./gradlew spotlessCheck
    unit-test:
        name: Run Unit Test
        runs-on: ubuntu-latest
        needs:
            - linter
        steps:
            -   name: Checkout Code
                uses: actions/checkout@v3
            -   name: Setup Java17
                uses: actions/setup-java@v3
                with:
                    java-version: '17'
                    distribution: 'zulu'
            -   name: Run Unit Tests
                run: ./gradlew test
    build:
        name: Build Java
        runs-on: ubuntu-latest
        needs:
            - linter
            - unit-test
        steps:
            -   name: Checkout Code
                uses: actions/checkout@v3
            -   name: Setup Java17
                uses: actions/setup-java@v3
                with:
                    java-version: '17'
                    distribution: 'zulu'
            -   name: Build Java
                run: ./gradlew build
```
