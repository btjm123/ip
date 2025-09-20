# Benn User Guide

Benn is a chatbot built with Java designed to help you to manage your tasks

## Features
- List all the tasks
- Add a task to the list
- Mark & unmark a task
- Persist tasks to file on disk
- Restore tasks from a file on disk
- Delete a task by index
- Search for a task using a keyword


## Other stuff to know
- The first word of the input is the command
- Available commands
    - todo
    - deadline
    - event
    - find
    - list
    - delete
    - mark
    - unmark
    - help
- Benn was built with Java 17

## Usage

1. Clone the repository

```
git clone https://github.com/btjm123/ip.git
```

2. Build Benn

```
./gradlew shadowJar
```

3. Run Benn

```
java -jar ./build/libs/benn.jar
```