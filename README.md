# LookAtMe

<p align="center">
  <img width="250" height="250" src="https://user-images.githubusercontent.com/41565823/53729574-dceb1380-3e75-11e9-891b-87e1f12126b0.gif">
</p>

<p align="center">
  Android library for a VideoView that plays video only when 👀 are open and 👦 is detected.
</p>

## GIF
<p align="left">
  <img width="300" height="550" src="https://user-images.githubusercontent.com/41565823/53345341-f8ee3280-3914-11e9-8be4-0f4e89ae69db.gif">
</p>

## Screenshots
![screenshot_2019-01-10-07-02-17-959_com pd trackeye](https://user-images.githubusercontent.com/41565823/50949699-8978cc80-14a7-11e9-9899-b99fec80be41.jpg)
![screenshot_2019-01-10-07-02-22-894_com pd trackeye](https://user-images.githubusercontent.com/41565823/50949700-8978cc80-14a7-11e9-96e8-92eb7cfdb78f.jpg)

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):


```gradle
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	        implementation 'com.github.Pradyuman7:LookAtMe:Version1.0'
}
```

## Usage

LookAtMe is very easy to use and can be directly used in your application. You just need to first declare the `LookAtMe` variable in your activity, and add the following in layout of your activity (XML file).

```java
        private LookAtMe lookAtMe;
        lookAtMe = findViewById(R.id.lookme);
```

```XML
<com.pd.lookatme.LookAtMe
        android:id="@+id/lookme"
        android:layout_width="match_parent"
        android:layout_height="250dp" />
```

After this, just initiallise `LookAtMe` variable with the activity context, add the video URI, start the video and just call `setLookMe()`, the whole code would look something like this:

```java
        lookAtMe.init(this);
        lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback));

        lookAtMe.start();
        lookAtMe.setLookMe();
```        

You can also personalise the experience according to your need, using `init()`. In this method you can add if you want the eye-tracking mode to be `FAST` or `ACCURATE`, and also which camera to use, front or back. The method bodies look like this:
```java
public void init(Context activityContext, String mode, String cameraFace){
        // add mode to be fast or accurate and cameraFace to be front or back
    }
```
```java
public void init(Context activityContext, String mode){
        // add mode to be accurate or fast   
    }
```    

## Pull Request

Have some new ideas or found a bug? Do not hesitate to open an `issue` and make a `pull request`.

## License

**LookAtME** is under [![License: Apache](https://img.shields.io/badge/License-Apache2.0-black.svg)](https://opensource.org/licenses/MIT). See the [LICENSE](.github/LICENSE.md) file for more info.

## Credits
The video being played in the android app is owned solely by Pixar animations and the author lays no claim over the video.

