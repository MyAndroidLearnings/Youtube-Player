# Android Youtube Player

### Introduction:

This project is created with the intention to understand the integration
of Youtube player as a Component, as an individual activity and as a 
standalone project


----------------------------------------------------------------------------------------------------

### Installation:

Step 1: Add the class path dependency to build.gradle

Inside dependencies:

``` 
implementation files('libs/YouTubeAndroidPlayerApi.jar')
```


----------------------------------------------------------------------------------------------------

### Configuration:

Initialize the Youtube Key and Youtube Video code in the MainActivity

```
val videoCode = "wKJ9KzGQq0w"
val apiKey = "AIzaSyDv-gjtmZh1h9WKwQbp-aySccEFlDkxFuk"
```


----------------------------------------------------------------------------------------------------

### Handler Part:

#### Initialization
```
fun initializeYoutube() {
    yt_pv.initialize(apiKey, this)
}
``` 

#### Youtube Delegate Methods

There are few methods given to observe and handle the events of the 
Youtube player

```
    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
        showShortToast("Youtube Api Initialization Success")
        if (!wasRestored) {
            player?.cueVideo(videoCode);
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        showShortToast("Youtube Api Initialization Failure")
    }
```

#### XML Part

You can include the Youtube player in your layout by using following code

```
    <com.google.android.youtube.player.YouTubePlayerView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:id="@+id/yt_pv"/>
```

----------------------------------------------------------------------------------------------------

### Usage / Example -

You can use this component in three ways

#### As a component

1) Invoke the initialization function in the Activity : 

```
initializeYoutube()
```

2) Include below xml component in layout file and adjust its position 
(if needed)

```
<com.google.android.youtube.player.YouTubePlayerView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:id="@+id/yt_pv"/>
```

3) Handle the delegate events

```
 override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
        showShortToast("Youtube Api Initialization Success")
        if (!wasRestored) {
            player?.cueVideo(videoCode);
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        showShortToast("Youtube Api Initialization Failure")
    }
```


#### As an Individual Activity

You can readily use YoutubeActivity.kt and activity_youtube.xml in your 
project for the Integration


#### As a standalone Project

You can take a clone of this project and can use it readily.