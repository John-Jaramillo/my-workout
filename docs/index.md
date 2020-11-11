## Summary

This Android app will allow a user to create an exercise routine by choosing from a list of weight training exercises. The user then can keep track of their progress by entering information into an exercise log. The app will allow the user to track sets, repetitions, and weight for each exercise. 

## Intended users

* People who are new to exercising and starting an exercise routine and want to keep track of their progress.  

    > As someone planning to start an exercise routine, I want to be able to pick from a list of exercises and keep track of my progress using a simple interface because the more "work" I have to put into this the less chance I have to starting and sticking to a new routine.

* People who are weight lifting and want an easy way to track their progress.

    > As someone with a full time job and a family, I want a faster and easier way to track my progress using my phone instead of writing in a notebook so I can devote more time to other aspects of my life.

## Functionality

Without having to log in:

* User will be able to browse the exercises.

After logging in:

* User can create an exercise routine by picking from a list of exercises.

* User will be able to enter information as they complete each exercise.

* User will be able to pull up stored information so they can track their progress.

## Persistent data

* User info (name, height, weight).

* List of exercises.
    
* List of Muscles.

* List of exercises in user's routine, both current and past.

* User progress: exercise, date, sets, repetitions, weight.
    
## Device/external services

* The list of resistance exercises from Google APIs for Android and/or wger Workout Manager.
    * <https://developers.google.com/android/reference/com/google/android/gms/fitness/data/WorkoutExercises>
    * <https://wger.de/en/software/api>

    * Access to these services would be during development to download the exercise information and store it in a SQL database. This would only require access to the service once. The wger database seems to have more information on each exercise but when I tried to browse the API I got what looked like test data so I'm not sure if I wasn't doing it right or if the API isn't usable.

* Access to google sign-in.
    * <https://developers.google.com/identity/sign-in/web/sign-in>
    * Creating/editing a workout and entering/viewing tracking data will only be available if the user is logged in.
    * The app will still run without the user logging in but with limited functionality.

* Access to the calendar for workout scheduling.
    * <https://developer.android.com/reference/java/util/Calendar>
    * This app will access the calendar to determine which workout is scheduled for that day. The user will be able to pick a workout in case the calendar is unavailable or if they just want to do another routine that day.
    * The app will still run but the user will need to manually pick the routine as the app won't know what day to use.

## Stretch goals/possible enhancements 

* Progress can be seen using graphs.

* Pictures or videos showing the various exercises.

* User will be able to input exercises not on the list.

* Add aerobic exercises to create workout.

* Recommend exercise routines based on the user's goal (weight loss, strength, endurance, etc.) and fitness level (sedentary, mildly active, etc.).

## Wireframe 
* [Wireframe](wireframe.md)

## ERD
* [ERD](erd.md)

## Entity Classes

* [Exercise](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/entity/Exercise.java)
* [ExerciseMuscle](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/entity/ExerciseMuscle.java)
* [Muscle](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/entity/Muscle.java)
* [Progress](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/entity/Progress.java)
* [Routine](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/entity/Routine.java)
* [User](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/entity/User.java)
* [Weight](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/entity/Weight.java)

## DAO interfaces

* [ExerciseDao](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/dao/ExerciseDao.java)
* [ExerciseMuscleDao](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/dao/ExerciseMuscleDao.java)
* [MuscleDao](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/dao/MuscleDao.java)
* [ProgressDao](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/dao/ProgressDao.java)
* [RoutineDao](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/dao/RoutineDao.java)
* [UserDao](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/dao/UserDao.java)
* [WeightDao](https://github.com/John-Jaramillo/my-workout/blob/master/app/src/main/java/edu/cnm/deepdive/myworkout/model/dao/WeightDao.java)


