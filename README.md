## About
This app was built in 3 hours for a coding challenge a company sent me for internship recruitment. It was done when I just started to learn code. 

The app uses the search-dialog library for setting up the search dialog and displaying the search result. Retrofit is the HTTP client used to send the GET request to the Node.Js server to fetch the desired search result. Furthermore, retrofit/GsonConverterFactory is able to turn the search result into GSON, saving each deserialized Java object as a "Game" object. Finally, the list of "Game" object is stored in "newGameSearch" and used by the search-dialog library to display the search result.

However, because I only realized  very late on that the Android Emulator requires further Network Configuration to make GET work, the emulator is unable to connect to the Localhost.

The app will run as desired once the network setting is configured properly. 

## Libraries I used:
https://github.com/mirrajabi/search-dialog 
https://github.com/square/retrofit

## Technical Difficulties
1. Network connection to the Android Emulator. 
2. Overriding the built-in search-dialog search funtions or adding the desired pagination effect due to time constraint.

## Screen-grab
Unfortunately no search result can be shown as of now due to the networking issues (as you can see on the top of the screen). However, it works perfectly if "game" objects are created locally.  

![SearchApp-Gif](SearchAppGif.gif)
