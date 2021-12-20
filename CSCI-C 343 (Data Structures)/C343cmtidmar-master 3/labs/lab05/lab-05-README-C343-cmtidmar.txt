C343 / Summer 2020
lab mini assignment - 05
July 2, 2020 15:22
Clare Tidmarsh, cmtidmar

To design my TweetCollection class, I first created an add method, which takes in the String that you want to the 
tweetCollection. Then it splits it into an array of two parts, Element[0] = author Element[1] = content of tweet. Then
that is sent into the Tweet object to be created as a tweet. Lastly, The tweet is stored into the tweetCollection.

Then I created a getTweets(String author) method which returns an array of the tweets of the same author.
First, I created a new, empty arrayList so I can store the tweets of the desired author. Then I created a 
for-loop that iterates through all of the data in tweetCollection. However, I found this to be quite difficult to
do without a helper function. So I made one in the Tweet.java file called getUser(), which returns the user/author.
Then I went back to the TweetCollection.java and implemented it in there. Whilst iterating through all of the tweets,
I wrote an if statement. If the username from getUser() is the same as the author in the tweetCollection, then
add that author/tweet to the empty arrayList I previously created. Lastly, return the new arrayList.

Finally, I created a tweetedAbout(String author, String content) to return a boolean if a certain user tweeted about
a certain word or phrase. Again, I tried to do it without creating a helper function, but I struggled too much. So in
Tweet.java I also created a getContent() method which gets the content of the tweet. Then I placed it in an if statement
in my for-loop. So it can compare the content in the data to the input content whilst the loop was iterating through
the authors and their tweets.

In addition, I created the TweetCollection object then added the given "str" to the tweetCollection so the contents
of the given url is the data that is in the tweetCollection object. At the very bottom, I tested the two methods
several times to see if I get the desired results. I also tested the location of where the tweets were that each user tweeted
so I know how many times they tweeted and where in the data their tweets are located at.


Testing getTweets: 
NoSQLDigest // if the user tweeted
[Tweet@1a6c5a9e, Tweet@37bba400] // location of the user's tweets
Deb3289
[Tweet@179d3b25]
discoverukdeals
[Tweet@254989ff]
true
true
false

Testing tweetedAbout: 
true // user did tweet about this
true // user did tweet about this
false //The last one tested did not tweet about cats, so it is false
