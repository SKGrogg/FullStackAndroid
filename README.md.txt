# stackFinal Integration instructions

## android-app

This is the Gradle android app for the top movies of the past 67 years. It was written with Java 8 and Kotlin 1.5.

The app launches to a search page, where the user can input any year between 1955 and the present, and be returned a list of movies in order of highest user rating on The Movie DataBase (where the API pulls its data from). 

In the search results, a user can click on a given movie to be brought to the details page. On this details page, a user can click four buttons. The first, titled "Add to Favorites", adds that movie to a list of favorites that can be found elsewhere on the app (more on that below). The other three can be found on the top bar. In order, the arrow back brings the user to the search page. The shopping cart brings the user to Amazon Prime Video to rent the movie. The information icon launches a google search of the movie.

On the favorites page, the user will find a list of all the movies they've favorited so far. On this page, the user will see a red trash can next to each movie title. This allows the user to delete the movie from their list.

Finally, you will see that the user can go to a contact page and send an email to the developer. All three fields must be populated in order for the user to send the message. 

UPCOMING FUNCTIONALITY: 
Though I was able to add amplify to the project, I could not successfully launch to a  Cognito log-in screen and the app finds itself stuck on a given user. If you would like to create a new favorites list for a different user, please go to the Constants class in the app files and update the userEmail function. If you input a name that has been used before, the favorites associated with that name will appear. Otherwise, the user will have an empty favorites list to start. 


### local
To run this project locally on an emulator, press the play-button from
Android studio.
### remote
n/a


## mongoDb and Quarkus App
This is the persistence layer for favorite movies. It saves the movies title, year of release, overview, path to a poster image, path to a trailer video (not utilized), and a user. When a movie is added, the user who clicked on the movie is included. This allows the android app to easily pull favorites by searching for those associated with the current user.

The docker image/container currently associated with this app is skgrogg/movieapp-quarkus-jvn.

### local
Run in a docker container:
docker run -ti --rm -p 27017:27017 mongo:4.0

### remote
Deploy to a docker container on Lightsail.

First, build the image with the following command:

docker build -f /src/main/docker/Dockerfile.jvm -t <your-docker-username>/<your-image-name>

Then, push to a new Docker Hub container with this command:

Docker push <your-docker-username>/<your-image-name>

Once the container is created, go to AWS Lightsail and create a container. That container should have two images: One for your docker container you just created on Port 8080, and one for mongodb:4:4 at port 27017.

Once this deployment is confirmed, be sure to update the Lightsail URL in the Constants class of the Android app to accurately reflect your endpoint.

## awsContant
This is a simple function to send an email to the developer. It was built with Java 8 and Maven 12.2.1. It sends an email with a subject and body to the developer address, and includes a replyTo address for the developer to respond to.

###remote
To deploy to AWS, execute these commands from the terminal:

sam build
sam deploy --guided



