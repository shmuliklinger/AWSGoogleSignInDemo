### AWS Mobile Sign In With Google

This project demonstrates how to use AWS cognito to implement sign in / sign out using Google.

### Create an Android project
1. Create an Android project.
1. Create a signing key [instructions](https://developer.android.com/studio/publish/app-signing#generate-key)
1. Save the key's SHA-1 ([instructions](https://stackoverflow.com/a/34223470/2427907)) for further use

### Set up google sign in
1. Go to [Google Cloud Console](https://console.cloud.google.com) 
1. Create a new project
1. Enable Google+ API
1. Create 0Auth Credentials
    1. Web Application Client Id
        1. Leave the restrictions section empty
        1. Save the Client id to further use
    1. Android Client Id
        1. Enter the SHA-1 of the android signing key you saved previously
        1. Enter you android package name
        1. Save the Client id to further use
        
### Set up AWS Mobile Hub project
1. Go to AWS Console -> Mobile Hub
1. Create a new project
    1. Enter a name
    1. Choose Android platform
    1. Download the Cloud Config file and store it in the following location: `<my-app>/app/src/main/res/raw/awsconfiguration.json`
    
### Add Google Sign in to your AWS Mobile Hub project
1. Go to your project in Mobile Hub
1. Add User Sign In Backend
    1. Choose Google Sign In
    1. In the settings add the following:
        1. Web Application Client Id (from above)
        1. Android Client Id (from above)
    1. Require user sign in -> No
1. Update the Could config file
    1. Go back to the Mobile Hub project
    1. Press on **Integrate**
    1. Download the cloud config again and update your Android project with the new file
    
    
### Add Google Sign In to the Android project
* Add the following permissions to the manifest: 
    ```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    ```
* Add the following dependencies to Gradle:
    ```
    // Mobile Client for initializing the SDK
    implementation('com.amazonaws:aws-android-sdk-mobile-client:2.7.+@aar') { transitive = true }

    // Cognito UserPools for SignIn
    implementation 'com.android.support:support-v4:27.+'
    implementation('com.amazonaws:aws-android-sdk-auth-userpools:2.7.+@aar') { transitive = true }

    // Sign in UI Library
    implementation 'com.android.support:appcompat-v7:27.+'
    implementation('com.amazonaws:aws-android-sdk-auth-ui:2.7.+@aar') { transitive = true }
    implementation('com.amazonaws:aws-android-sdk-auth-google:2.7.+@aar') { transitive = true }
    ```
    
* Implement Sign In / Sign Out. [Instructions](https://docs.aws.amazon.com/aws-mobile/latest/developerguide/mobile-hub-add-aws-mobile-user-sign-in.html)

### Add Cloud logic (AWS Api GateWay)
#### Setup Mobile Hub project to add Cloud logic
1. Go to your project in Mobile Hub
1. Add Cloud Logic (this step will add AWS API Gateway, a Lambda function for handling the requests and a cloudFormation Stack)
    1. Press on Create new API
    1. Enter name
    1. Choose **private**
    1. Press on Create API (this will take a moment)
    
#### Update your Android project
1. Update the AWS cloud config file
    1. Go back to the Mobile Hub project
    1. Press on **Integrate**
    1. Download the cloud config again and update your Android project with the new file
1. Integrate the API code
    1. Download the Android Model (from the same window as the could config file)
    1. Extract the files and add them to your project
    1. Add android code to handle the API call [instructions](https://docs.aws.amazon.com/aws-mobile/latest/developerguide/mobile-hub-add-aws-mobile-cloud-logic.html)
    
     