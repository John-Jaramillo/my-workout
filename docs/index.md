## Summary

This Android app will allow a user to create an exercise routine by choosing from a list of weight training exercises. The user then can keep track of their progress by entering information into an exercise log. The app will allow the user to track sets, repetitions, and weight for each exercise.

## Functionality

After logging in:

* User can create an exercise routine by picking from a list of exercises.

* User will be able to enter information as they complete each exercise.

* User will be able to pull up stored information so they can track their progress. 

## Current State of App

Currently, the app allows the user to sign in using Google Sign In and the user is able to use the Navigation Drawer to go to each page. The exercises and muscles have been entered into the databases and the pages that are currently functioning are the Muscles page and the Exercises page. These pages query the database and display the information. The pages currently not functioning are Profile, Log Book, and Routine. These are pages where the user would be allowed to inter data into the database.

### Cosmetic Enhancements
* Redesigned Home Page - currently has placeholder image
* Change of color scheme and launcher icon
* 3d display for muscles

### Functional Enhancements
* Get Profile, Routine, and Log Book pages working
* Add ability to display progress from Log Book in graphs
* Add aerobic exercises to allow creation of complete workout routine
* Allow access to Exercise and Muscle pages without having to log in

## Intended users

* People who are new to exercising and starting an exercise routine and want to keep track of their progress.  

    > As someone planning to start an exercise routine, I want to be able to pick from a list of exercises and keep track of my progress using a simple interface because the more "work" I have to put into this the less chance I have to starting and sticking to a new routine.

* People who are weight lifting and want an easy way to track their progress.

    > As someone with a full time job and a family, I want a faster and easier way to track my progress using my phone instead of writing in a notebook so I can devote more time to other aspects of my life.

## Persistent data

* User info (name, height, weight).

* List of exercises.
    
* List of Muscles.

* List of exercises in user's routine, both current and past.

* User progress: exercise, date, sets, repetitions, weight.

## Stretch goals/possible enhancements 

* Progress can be seen using graphs.

* Pictures or videos showing the various exercises.

* User will be able to input exercises not on the list.

* Add aerobic exercises to create workout.

* Recommend exercise routines based on the user's goal (weight loss, strength, endurance, etc.) and fitness level (sedentary, mildly active, etc.).

## Technical requirements and dependencies
* [Requirements](services.md)

## Wireframe 
* [Wireframe](wireframe.md)

## ERD
* [ERD](erd.md)

## Files
* [Files](files.md)

## Copyrights and licenses
* [Copyrights](copyrights.md)

