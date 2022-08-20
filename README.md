#Scoreboard

A Live Football World Cup Scoreboard library

## Developer Notes

- I chose to write this in Java as I understand that most of the code at Sport Radar is Java.  This way it will be accessible to the widest audience possible. I haven't used Java in several years. On the JVM, I mostly code in Scala these days, although I have used Kotlin recently also. As such my programming style has moved away from Java idioms, such as using annotations, mutable objects, boilerplate etc. I prefer to code in a more concise style, better suited to languages like Kotlin and Scala. I've tried to maintain my concise style here. Hopefully the code still passes as idomatic Java.


- The code was TDD'ed (test first). I have tried to capture this in the checking sequence and commit messages. When doing TDD, I try to focus on one test at a time, first red then green, followed by an optional refactor. When writing the tests/code I try and do the simplest thing that can possibly work to get each test to pass. As design ideas/improvements come to mind, I add them to a TODO list so that I don't get distracted from my current task. You will see this in my Test class. As I resolve TODO's, they are removed from the list. The granualarity of my TDD steps as demonstrated here are smaller than is usually for me. I did it this way because it better demonstrates the process I am following in my head. 


- I have chosen to avoid the use of libraries that try to extend the Java language. My first instinct was to use a tuple for the match score. The version of Java I am using (Java 11), doesn't have tuples (does any?). Rather than use a third party library I chose to create a Score class instead. Similarly with Hashcode and Equals.  Instead of using an annotation library like Lombok, I simply got my IDE to generate these methods for me. I will use libraries when present in an existing codebase for consistency, but I find the use of such libraries can become a barrier to reability and comprehension for anyone unfamiliar with them (like me).

 
## Assumptions

This library assumes that all input is valid. The reason for this is to avoid the proliferation of defensive code in the domain. In the real world I would implement input validation at the edges of the system prior to calling the domain. As an example, only matches between known valid international teams (the static instances listed in the`Team` class) are deemed valid input. This is enforced in this exercise by using a private Team constructor/factory method. In a real world system such a list would probably come from a Team reference table in a database: `Team(Id, Name, ...)`. In a real world system the Team constructor would be public so that a list of new teams can be created dynamically at startup. It would be the responsibility of the UI layer to load a list of teams into memory (hashcode and equals overrides would be needed also, as the `Team` instances would no longer be static). It would be the UI's responsibility to present this list of teams to the user and ensure that only valid teams from the list are used as input to the domain. No mispelt names, No teams matched against themselves, no null references, etc. Eric Evans book on Domain Driven Design talks about this.

Two Matches between the same two teams, but with home and away transposed, are deemed as seperate distinct Matches. Whilst it is impossible for Matches between the same teams to be in two locations at once, I have made this assumption for simplicity sake. In the real world this would be something I would discuss with my BA. Again it may be a responsibility best delegated to an input validation layer.. For example the input validator could search the domain for a transposed `Match` and if found ask the user if they are sure they want to proceed?

## API
 
`Scoreboard()` 
 - Creates a new empty scoreboard with no matches


`Scoreboard(List<Matches> matches)`

- A constructor that creates a scoreboard with a predefined List of matches that are in play, useful for testing.

`Scoreboard::startGMatch(Match aMatch)` 
- starts a new match by adding it to the list of matches. The match constructor takes a home team and an away team as input parameters. If the match already exists in the list then a `MatchInProgressException` is thrown. Returns the started match from the list.

`Scoreboard::findMatch(Match aGame)`  
- Finds a match in progress from the list. Returns the match from the list, if found. If the match is not found a `MatchMissingException` is thrown.

`Match::updateScore(int: homeGoals, int: awwayGoals)` 
- Updates the score for a match in process. Returns self.

`Scoreboard::finishMatch(Match aMatch)`  
- Finds a match in progress from the list. Removes the match from the list if found. If the match is not found a `MatchMissingException` is thrown.

`Scoreboard::matchSummaries()` 
- Returns a list of matches in progress, ordered by the total goals scored in each match in reverse order (highest goals scored first, see tests and spec sheet for an example)


## Running the tests
```` shell
./gradlew build

./gradlew test




