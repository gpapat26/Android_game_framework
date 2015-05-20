This sample project accompanies the book 
"The Beginner's Guide to Android Game Development" by James S. Cho.


= GOOGLE PLAY GAME SERVICES SAMPLE = 
http://jamescho7.com/book/chapter10/gpgs

= YOU MUST FOLLOW THE INSTRUCTIONS AT THE ABOVE LINK =

= GENERAL INFORMATION =

The challenge we face when implementing Google Play game services is that we are using one Activity which hosts
many State classes. Each State needs to be able to call certain methods that belong to BaseGameActivity (inherited
by GameMainActivity).

To make this as easy as possible, we create (inside of the GameMainActivity class) a static reference to the instance:
public static GameMainActivity instance;

This allows us to retrieve GameMainActivity.instance from any other class, including our State classes, and call
any public instance methods it may have.


= CHANGES TO USER EXPERIENCE =

1. When starting the app for the first time, a welcome box will pop up and ask the player to 
log into Google Play game services.

2. A sign in /sign out button has been added to the top left of MenuState.

3. The Score button will display a Google Play Games icon when signed in to indicate
that it will utilize Google Play game services.

4. The Score button will now start the Leaderboard Activity instead of
the ScoreState when signed in.

= CHANGES TO CODE =

1. Changes to GameMainActivity

- GameMainActivity now inherits BaseGameActivity (a class inside BaseGameUtils). This allows us to
quickly implement Google Play game services by adding a few methods. See the methods labeled
// Google Play Games Methods for more information. Each method is commented in detail.

- setHighScore(): When the player gets a new high score, we save it into the SharedPreferences. 
A change has been made to also send this value to the Game Services server, provided that
the player is signed in.

2. UIButton

- A new render() method that allows alternate button images has been added. This is added
for buttons that can be toggled into different states (sign in / sign out).

3. MenuState

- A UIButton for a sign in /sign out Google button has been added.
- scoreButton now displays an alternate image when signed in.
- scoreButton will now perform a different action based on the user's sign in status.



Some images used in this project have been created by or based on public domain work by Kenney (Kenney.nl).
Music: "Nintendo Was Cool" by Matt McFarland http://www.mattmcfarland.com/song/nintendo-was-cool/

For more information, please see:
jamescho7.com/book