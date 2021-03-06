// IU username: cmtidmar

// Step 1.  start by writing a class to represent tweets: TweetClass.java.
// Step 2. Make sure that you use instance variables to store the basic information for a tweet:
//      the actual content of the tweet, and
//      the author of the tweet.
// Step 3. Implement methods, including at least:
//      a constructor, and
//      a method that prints out the content of the tweet.
//      Write a method named contains(s) that
//      tests whether the tweet contains a certain string s and
//      returns true in that case, false otherwise.
// Step 4. Write some simple test "client code" for your TweetClass class
//      (within the TweetClass class, in the main() method) .
// Step 5. As test tweet data, you could use for example: "It is now possible to learn about a person's
//      mobility preferences from data generated by their smartphone" written by "someperson".
// Step 6. Write a class named TheTweeter, which needs to include a data structure that may
//      contain an arbitrary number of TweetClass objects.
//      Your class needs to use one of the standard Java List implementations, as from the above references.
// Step 7. Your class named TheTweeter needs to start empty
//      (it should not contain any tweets at first), and should
//      allow adding, removing, and getting tweets. For this purpose, include at least these methods:
//          a. add(t) --- adds the TweetClass object t to TheTweeter object.
//          b.  remove(author) --- removes from TheTweeter object all TweetClass
//                  objects whose author is author.
//          c. get(author) --- returns one TweetClass object whose author is author,
//                  if there is such TweetClass object in the TheTweeter object. Returns null otherwise.
// Step 8. Write some simple test "client code" for your TheTweeter class. Make up your own
//      tweets and authors (at least 6 different tweets), instantiate them in your TheTweeter
//      client code, and call the various methods provided by the TheTweeter class. Your test "client code"
//      should also print out all results from such calls.

import java.util.Scanner;
import java.time.LocalDate;

public class TweetClass {
    private String content;
    private String author;


    TweetClass(){
        this.content = content;
        this.author = author;
    }

    public static Scanner send(){
        Scanner content = new Scanner(System.in);
        System.out.println("What's happening?");
        String tweet = content.next();
        System.out.print("User: ");
        String author = content.next();

        LocalDate date = LocalDate.now();
        System.out.println();
        System.out.println(" ' " + tweet + " ' ");
        System.out.print( " ~" +author + " " + date);



        return content;
    }

//    private boolean contains(String s){
//
//        if (content.equals(s)) {
//            true;
//
//        }
//        else {
//            false;
//        }
//    }

    public class TheTweeter {


    }

    public static void main(String[] args) {
        TweetClass newTweet = new TweetClass();
        newTweet.send();


    }

}
