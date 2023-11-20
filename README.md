# Places Family App

This app was developed as a part of the [WWCode App Deploy Hackathon in Partnership with Google Play](https://hopin.com/events/wwcode-app-deploy/registration). The hackathon required participants to build an Android application using a Google API. It took place from 17-20 November 2023.

<img src="./appathon img.png" alt="WWCode Android app-a-thon promotional image" width="600"/>

## 🛠️ Technologies

## 🤔 Reflection

This is the first app I've tried building with Android Studio beyond some simple static layout practice exercises, and it's been such a good learning experience!

### 💡 Thoughts after Day 1 of hackathon

Whew! I've been plugging away at this little app idea for the first day of the hackathon, and I just wanted to share some thoughts at this point in the process.

- Sometimes I feel like a true beginner. And other times I feel like I've been working in development for a while.
- Debugging and troubleshooting, in general, are much easier and less daunting and panic-inducing than they used to be. Solving mysteries is what this is all about.
- It can take a long time to get things set up/scaffolded/configured, especially when using a new medium.
- It's exciting to see similarities between web and Android development. Some of the concepts are similar, and it helps knowing a bit about web development to grasp concepts in Android development.
- Vocabulary is a challenge sometimes. When learning a new domain (Android development in this case), all of the vocabulary is new. So ideas that are the same or similar in web development are called different things. Getting it all straight is a process.
- Being persistent pays off, in one way or another, eventually.
- Learning is a continuous process.

### ✅ Day 1 Tasks

Most of Day 1 was spent doing one of two things: brainstorming/planning or scaffolding the project.

I did some initial brainstorming, and narrowed down a couple of app ideas. Then after looking at the Google API documentation, I chose one of the ideas to run with. My app idea is to use the Google Place API to create an app for families exploring a new location.

I want to create an app that uses the current location to simply display top rated attractions (entertainment & recreation, sports) in area so families can quickly see what is nearby and choose what to visit next.

However, this is the first Android app I'm attempting to build, so there's a lot to learn! So I opted to simplify the app idea as much as possible and see if I can get everything connected.

#### Must-Have Features

- Access Google Place details
  -- Filter attractions based on type (tourist-attraction, park, museum, etc)
- Render image, place name, rating, cost for nearby attractions
- Scrollable list of nearby places

#### Nice-to-Have Features / Future Directions

- Access current location of device
- Ability to manually enter address
- Get route from current location to destination (click on attraction)
- Filter places by “family-friendly status” – supplement with data from Yelp or other api
- Save location to personal list
- Save notes or pictures or other information about attractions
- Authentication and authorization for user accounts

My initial wireframes were done on paper, and I used Figma to make a simple, slightly higher fidelity mock up of the app.

<img src="./wireframe.jpeg" alt="places family app wirefram" width="200"/>
<img src="./mock up.png" alt="places family app mock up" width="200"/>

### 💡 Thoughts after Day 2 of hackathon

Oof. After a few hours of work today, I'm still stuck with the project setup and scaffolding. I've been debugging an error with the BuildConfig object for the last like 2 hours, and I have no idea how to resolve the issue.

I can't really move forward with the build without accessing the api key, so I'm considering hardcoding it into the app instead of trying to access it secretly from the local.properties file. I don't know. It's kind of discouraging that it's taking SOOOO long to get things set up. It's all new, though, so I guess it makes sense that it will take a while to learn about what's needed, troubleshoot issues that come up, and get everything connected. At this rate, though, I won't get past the scaffolding phase of the build before the end of the hackathon.

After some thought, I decided to hardcode my API key into my app. I know this isn't ideal, but I didn't know how else to move forward. I hadn't touched the UI up until this point, so I wanted to at least get a tiny bit into that part before the end of the hackathon.

### ✅ Day 2 Tasks

I tried to debug whatever isn't working with accessing my API key. I did a ton of Googling and using ChatGPT and chatting with other hackathon participants, but it was to no avail. Something isn't quite right. So, I hardcoded the API key into the app, as previously mentioned.

I moved onto working with the UI. As with all of the scaffolding and set up, much of the UI work was new for me as well. I have only dabbled in basic layouts with Jetpack Compose before this project, so each element took quite a while to put together. On top of that, my computer HATES using Android Studio. It's SOOOOO SLOOOW! That was a major barrier for me during this build, for sure.

When I managed to render the data in my app, though, it was MAGICAL!!!🪄🔮🧝🏻‍♀️

I tweaked the styling a bit, well, I tried to. But, again, it was super slow-going. I managed to add the location names, a star icon, and the ratings for the locations.

### 💡 Thoughts after Day 3 of hackathon

I wanted to try to add some more features (render more data, maybe get the image rendering, add a bottom app bar where the location could be displayed at some point), but...none of it was working. I just couldn't get things to work with the amount of time that I had and how slow Android Studio was on my computer.

I decided to wrap up the build and spend the remaining time putting my presentation together. You can see my [video presentation here](https://drive.google.com/file/d/1zD3pRwP_bqpAZnS7QmUrAiG7PUVFj4iv/view?usp=drive_link)!

<img src="./wander wise.gif" alt="gif of styling progress" width="200"/>
