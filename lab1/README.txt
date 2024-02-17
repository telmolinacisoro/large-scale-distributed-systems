Authors:
Uzair Ramzan Parveen, 251599
Marc Riera Arza, 254149
Telmo Maximilian Linacisoro Leyendecker, XXXXXX

In this lab, we created a program that, given a collection of files containing 
tweets, copies all tweets in a given language into a new file, and uploads it 
to S3.
For this purpose, we used the provided skeleton which contained some partially
coded classes and some interfaces that these classes were implementing. 
When parsing, we only allow tweets that contain all the mandatory fields (atleast).
In the filter class, we made sure that both the input and the output are a single
file from which we read and write only one line (tweet) at a time. 
In the uploader, we fetch the credentials from the mentioned file (after having
them configured) and use them to access to S3 with a default profile. The provided
call to the uploader included an extra parameter for the profile which we 
eliminated. In this way, we always work with the default profile. Every execution 
also prints on the screen the number of tweets that we have filtered from the 
input files and the time our program took to do so. This brings us to benchmarking.
Below are the numbers for executions from each of the group members. Obviously, the
number of tweets is the same in all of the cases, the difference lies in the time
taken to do the task. The time is provided in seconds.

Number of tweets
es: 509435
en: 446603
ca: 4583

Uzair
es: 350 
en: 277
ca: 114

Marc
es: 192
en: 159
ca: 71

Telmo
es: X
en: X
ca: X

As we can see, Marc's computer takes less time to make the computations
as compared to Uzair's. 
We are only including the numbers because we cannot put images in the text file.
For further confirmation, please check our corresponding buckets to get the output
files.

During the computation we did not encounter any serious problems as such. Although,
we did have difficulties because this is a new environment for us after all and
we had to find our way through some minor problems like the command to run the 
program or getting the credentials, for instance.


