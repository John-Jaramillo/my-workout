## Technical Requirements

* Android API 29.0.3
* This app was tested using an emulator of a Pixel 3a API 28
* Libraries
    * Google Sign In
    * Gson
    * Retrofit
    * ReactiveX
    * Facebook Stetho

## Device/external services

* The API originally intended to be used for importing exercise and muscle information into the database were deemed insufficient or unusable. A JSON file was created using information gathered from the wger API, google searches, and two books.
    * <https://wger.de/en/software/api>
    * 1985, *Secrets of Advanced BodyBuilders*, Health for Life, Los Angeles, CA
    * Mejia and Berardi, 2005, *Scrawny to Brawny*, Rodale Inc., United States

* Access to google sign-in.
    * <https://developers.google.com/identity/sign-in/web/sign-in>
    * The user currently is required to sign in for the app to work.

* Access to the calendar for workout scheduling.
    * <https://developer.android.com/reference/java/util/Calendar>
    * This app will access the calendar to determine which workout is scheduled for that day. The user will be able to pick a workout in case the calendar is unavailable or if they just want to do another routine that day.
    * The app will still run but the user will need to manually pick the routine as the app won't know what day to use.
