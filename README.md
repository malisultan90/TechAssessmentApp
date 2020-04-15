# TechAssessmentApp

A test assessment app having initial screen having a list of news items from nytimes and by clicking any of the item it’ll navigate to its detail screen. App has a basic UI/UX and focuses much on the functionality and architecture. 

### Libraries used
Dagger 2<br/>
Retrofit<br/>
OkHttp<br/>
DataBinding<br/>
Glide<br/>
Multidex<br/>

### App Architecture
MVVM<br/>
Repository Pattern


### How to setup project
-Checkout of the project<br/>
-Import it in the android studio<br/>
-Sync the project so that all the required dependencies get downloaded<br/>
-Either click the green play button at the top or run the following gradle commands<br/>


### Gradle commands

For dev<br/>
./gradlew clean assembleDevDebug<br/>
To directly install<br/>
./gradlew clean installDevDebug OR<br/>
adb install app/build/outputs/apk/dev/debug/app-dev-debug.apk 

For prod<br/>
./gradlew clean assembleProdDebug<br/>
To directly install<br/>
./gradlew clean installProdDebug OR<br/>
adb install app/build/outputs/apk/dev/debug/app-prod-debug.apk 



