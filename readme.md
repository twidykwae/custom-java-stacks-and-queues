# P02_DataTypes


General
========

For each of your team's implementations, explain the following (where appropriate and applicable):

- details on calling conventions, input and output data formats, limitations, bugs, and special features.
- negative aspects of your program (limitations, known bugs)
- positive aspects (extensions, special features)
- describe your choice of modularization (abstractions), data structures, and algorithms
- explain anything you did that is likely to be different from what other students may have done
- justify any design decisions for which the rationale isn't immediately clear

Feel free to modify the structure of this `readme.md` file to fit the current assignment and to fit how you wish to present your findings.


### Note on Math Typesetting

Surround your math with double dollar signs to have Markdown typeset it beautifully.
To add a tilde in math mode (using dollar signs), use the `\sim` command.
If an exponent has more than one character, you must surround it with curly braces.
In the example below, the exponent for $T$ must use curly braces, but they aren't required for $N$.

$$ \sim T^{1.2} N^2 $$

Note: Typesetting like this is optional; feel free to use plain text if you'd like.

See [GitLab Markdown: Math](https://handbook.gitlab.com/docs/markdown-guide/#math) for more info





Author
=============

|                  |              |
| :--------------- |:-------------|
| Name             |              |
| Computer + OS    |              |
| Time to Complete |              |
| Partner          |              |
| Additional Help  |              |






Implementations
===================


`Steque` Implementation
--------------------------


- Explain briefly how you implemented the `Steque.java` class.  
- How did you check that your implementation was correct?
- Include code listings, screenshots, diagrams, etc. if helpful.


`MinimumStack` Implementation
------------------------------

- Explain briefly how you implemented the `MinimumStack.java` class.
- How did you check that your implementation was correct?
- Include code listings, screenshots, diagrams, etc. if helpful.


`OnePointerQueue` Implementation
-----------------------------------

- Explain briefly how you implemented the `OnePointerQueue.java` class.
- How did you check that your implementation was correct?
- Include code listings, screenshots, diagrams, etc. if helpful.



Memory Analysis
-----------------

How much memory (in bytes) do your data types use to store $N$ items in the worst case?
Use the 64-bit memory cost model from section 1.4 of the textbook and use tilde notation to simplify your answer.
Briefly justify your answers and show your work.

Do not include the memory for the items themselves (as this memory is allocated by the client and depends on the item type) or for any iterators, but do include the memory for the references to the items (in the underlying array or linked list).

Note: The `Stack` class (provided by the book's `algs4.jar`) implements the stack using a singly-linked list.
So, your memory analysis of `MinimumStack` should take this into account.

| class             | memory (bytes) |
|-------------------|----------------|
| `Steque`          | $\sim N$       |
| `MinimumStack`    | $\sim N$       |
| `OnePointerQueue` | $\sim N$       |



Known bugs / limitations
-------------------------

- What bugs or limitations were troublesome?
- What bugs or limitations still remain?
- Are these bugs or limitations a problem in your implementation, algorithm, or something else?
- How do you know that you did not miss a bug?
- What additional tests did you run to ensure that your implementations are correct?



Reflection
===========

- Describe whatever help (if any) that you received.
- Don't include readings, lectures, but do include any help from people (including course staff, lab TAs, classmates, and friends) and attribute them by name.
- How did you discuss the problem with others? (ex: white-board algorithms, looking over code for bugs, looking at print out results, etc.)
- Since this is an individual assignment, if you worked with a partner, assert below that the work you are turning in is your own work, and that you only did "whiteboard" work as a group.
    - Give one sentence explaining what each of you contributed.
- If you used the code from a lab challenge, explain what is shared between you and your lab partner.
- Describe any serious problems you encountered.
- How much time did you spend writing new code, debugging code, thinking about the algorithms, discussing with someone else, running tests, writing comments and documentation, etc.?
- List any other comments here.
- Feel free to provide any feedback on how much you learned from doing the assignment, and whether you enjoyed doing it.


