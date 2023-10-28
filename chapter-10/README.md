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