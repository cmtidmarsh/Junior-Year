
// C343 / Summer 2020
// lab - 05
// July 2, 2020 14:08
// Clare Tidmarsh, cmtidmar

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TweetCollection {
    private ArrayList<Tweet> tweetCollection;


    public TweetCollection() {
        tweetCollection = new ArrayList<Tweet>();
    }

    public void add(String message){
        String[] splitTweet = message.split(" ", 2);
        String author = splitTweet[0];
        String content = splitTweet[1];
        Tweet SplitTweet = new Tweet(author, content);
        tweetCollection.add(SplitTweet);

        // ['jacko2point0', '@Optus', 'is', 'Belmore' ....]

    }


    public ArrayList<Tweet> getTweets(String author){
        ArrayList<Tweet> sameAuthor = new ArrayList<Tweet>();   // creates a new array list to
        for (int i = 0; i <= tweetCollection.size()-1; i++){
            Tweet t = tweetCollection.get(i);
            if (t.getUser().equals(author)){
                sameAuthor.add(tweetCollection.get(i));
            }
        }
        return sameAuthor;
        }

    public boolean tweetedAbout(String author, String content){
        boolean F = false;
            ArrayList<Tweet> authorOfTweets = getTweets(author);
            for(int j = 0; j < authorOfTweets.size(); j++){ // iterates through all of the tweets of that author
                Tweet t = authorOfTweets.get(j);               //saves each tweet into a String while iteration
                if (t.getContent().contains(content)){ // Compare the content in the tweet to the content you're looking for
                    F = true;                           // if the content you're looking for is in the tweet, return true

            }

            }
            return F;
        }



    public static void main(String[] args) {
        try {
//Step 1: create a scanner
            System.out.println("we're going to create a scanner");
//From a URL
            URL url = new URL("http://homes.soic.indiana.edu/classes/summer2020/csci/c343-mitja/test2020/tweet-data-July01.txt");
            System.out.println("obtained a URL");
            Scanner in = new Scanner(url.openStream());
            System.out.println("scanner created");
//From System.in (user's inputs)
//Scanner in = new Scanner(System.in);
//From a local file (e.g., tweet-data-July01.txt on your local machine)
//Scanner in = new Scanner(new FileReader("tweet-data-July01.txt"));
//Step 2: read data
            TweetCollection tweetCollection = new TweetCollection();
            int i = 0;
            while (in.hasNext()) {
                //nextLine() reads a line;
                //Scanner class has other methods to allow the user to read values of various types, eg.., nextInt()
                String str = in.nextLine();
                tweetCollection.add(str); // added
                System.out.print("at line ");
                System.out.print(i);
                System.out.print(" there is [");
                System.out.print(str);
                System.out.println("]");
                i = i + 1;
            }
            System.out.println("A");
            //----------------------------------------------------------------------------------------------------------------------
            System.out.println();
            System.out.println("Testing getTweets: ");
            System.out.println(tweetCollection.getTweets("NoSQLDigest").get(0).getUser()); // If the user tweeted
            System.out.println(tweetCollection.getTweets("NoSQLDigest")); // location of tweets
            System.out.println(tweetCollection.getTweets("Deb3289").get(0).getUser());
            System.out.println(tweetCollection.getTweets("Deb3289"));
            System.out.println(tweetCollection.getTweets("discoverukdeals").get(0).getUser());
            System.out.println(tweetCollection.getTweets("discoverukdeals"));

            System.out.println();
            System.out.println("Testing tweetedAbout: ");
            System.out.println(tweetCollection.tweetedAbout("ndhapple", "An example of how data without context is misleading"));
            System.out.println(tweetCollection.tweetedAbout("oncology_bg", "if after all"));
            System.out.println(tweetCollection.tweetedAbout("ShallowAddict", "cats"));

            //----------------------------------------------------------------------------------------------------------------------
//Step 3: close the scanner
            in.close();
        } catch (Throwable e) {
            System.out.println("exception is "+ e);
            e.printStackTrace();




        }
    }
}