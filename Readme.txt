This is a SpringBoot based application with the spring boot basic authenitcation.
We are using the H2 In memory DB where we are storing all the transactions


1) We can run this through either command prompt by using the command - mvn spring-boot:run through command line

If there is some trouble in running this. Import the project in Intelli Idea. Right click RockPaperScissorsApplication.java
and then run as Java Application.

2) The embbeded web server starts immediately on the port 8080
3) First we need to create the user
    Go to PostMan or Insomania /Soap UI
    http://localhost:8080/users/create
        basis authentication
            username - admin
            password - password

        body
            {
            	"userName": "Ashish"
            }
    Output
    {
        "userId": 1,
        "userName": "Ashish"
    }


4) To validate the user is create or not - On Web Browser hit the url -  http://localhost:8080/users/all
    -> It will show you all the users
            [{"userId":1,"userName":"Ashish"},{"userId":2,"userName":"Arnav"}]
    a) http://localhost:8080/users/id/1
        -> it will show you the user with id 1
    b) http://localhost:8080/users/name/Ashish
        {"userId":1,"userName":"Ashish"}

5) Now, play the game
    URL - http://localhost:8080/game/user/{username}/play/{gameOption}
             http://localhost:8080/game/user/Ashish/play/ROCK
    Output will be like this - {"roundId":4,"userName":"Ashish","userOption":"ROCK","applicationOption":"PAPER","winner":"APPLICATION"}

6) You can play with the random also like both application and user input will be random
      URL - http://localhost:8080/game/user/{username}/play
                 http://localhost:8080/game/user/Ashish/play/ROCK
        Output will be like this - {"roundId":6,"userName":"Ashish","userOption":"ROCK","applicationOption":"PAPER","winner":"APPLICATION"}

7) Stats :
    URL - http://localhost:8080/game/stats/user/{userName}
            http://localhost:8080/game/stats/user/Ashish
    Output :
        {"userName":"Ashish","totalGames":4,"winGames":1,"loseGames":2,"drawGames":1}

8) All Games
    URL - http://localhost:8080/game/all
    [{"roundId":2,"userName":"Ashish","userOption":"ROCK","applicationOption":"SCISSORS","winner":"Ashish"},{"roundId":3,"userName":"Ashish","userOption":"ROCK","applicationOption":"ROCK","winner":"DRAW"},{"roundId":4,"userName":"Ashish","userOption":"ROCK","applicationOption":"PAPER","winner":"APPLICATION"},{"roundId":6,"userName":"Ashish","userOption":"ROCK","applicationOption":"PAPER","winner":"WINNER_APPLICATION"}]

9) Log file is generated at root directory with the name resmed-logger.log

There are couples of things which can be improved in this like ExceptionMapper, Junit Tests, Proper Logging etc