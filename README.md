# LookAtMe

<p align="center">
  <img width="250" height="250" src="https://user-images.githubusercontent.com/41565823/53729574-dceb1380-3e75-11e9-891b-87e1f12126b0.gif">
</p>

<p align="center">
  Android library for a VideoView that plays video only when 👀 are open and 👦 is detected.
</p>

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

