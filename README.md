# LookAtMe

[![](https://jitpack.io/v/Pradyuman7/LookAtMe.svg)](https://jitpack.io/#Pradyuman7/LookAtMe)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=15)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-LookAtMe-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/7551)
[![LookAtMe](https://img.shields.io/badge/Pradyuman7-LookAtMe-red.svg?style=flat)](https://github.com/Pradyuman7/LookAtMe)
[![AwesomeAndroid](https://img.shields.io/badge/Awesome_Android-LookAtMe-purple.svg?style=flat)](https://android.libhunt.com/lookatme-alternatives)
[![Android Weekly](https://img.shields.io/badge/Android_Weekly-LookAtMe-lightblue.svg?style=flat)](https://androidweekly.cn/android-dev-weekly-issue-224/#LookAtMe)
[![Android Dev Digest](https://img.shields.io/badge/Android_Dev_Digest_222-LookAtMe-orange.svg?style=flat)](https://www.androiddevdigest.com/digest-222/)
[![Android Sweets](https://img.shields.io/badge/Android_Sweets-LookAtMe-black.svg?style=flat)](https://androidsweets.ongoodbits.com/2019/04/13/read-about-some-good-practices-when-converting-your-code-to-kotlin-and-check-this-weeks-amazing-library-pack)
[ ![Download](https://api.bintray.com/packages/pradyuman7/LookAtMe/LookAtMe/images/download.svg?version=Version1.0) ](https://bintray.com/pradyuman7/LookAtMe/LookAtMe/Version1.0/link)

<p align="center">
  <img width="250" height="250" src="https://user-images.githubusercontent.com/41565823/53729574-dceb1380-3e75-11e9-891b-87e1f12126b0.gif">
</p>

<p align="center">
  VideoView that plays video only when :eyes: are open and :boy: is detected with various features
</p>

## GIF
<p align="left">
  <img width="300" height="550" src="https://user-images.githubusercontent.com/41565823/53345341-f8ee3280-3914-11e9-8be4-0f4e89ae69db.gif">
</p>

## AndroidPub (Medium) Post

[You can read the AndroidPub post about this library, the perks it provides and other details here](https://android.jlelse.eu/a-videoview-that-detects-your-face-and-tracks-your-eyes-afc3a04fd735).

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

For latest release, please check the JitPack version and match it with the dependency.
```gradle
dependencies {
	        implementation 'com.github.Pradyuman7:LookAtMe:Version2.0'
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

### Version2.0 additions

Now in Version2.0 the developer can also access that if the user laughed / smiled during the video. For this, just use this `init()` method instead of the above.

```java
	lookAtMe.initWithSmilingStatus(this); // for smiling status of the user
```

To access if the user smiled during the video after this, currently you have to acess the log of the app programatically.
Currently, LookAtMe counts when user smiles and for how many frames. If the user smiles for 100 frames in total, LookAtMe logs a line stating that "the user smiled for 100 Frames!". After that count resets to 0.

You can access the log of your android app like this:

```java
	try {
  		Process process = Runtime.getRuntime().exec("logcat");
  		BufferedReader bufferedReader = new BufferedReader(
  		new InputStreamReader(process.getInputStream()));

  		StringBuilder log=new StringBuilder();
  		String line = "";
  		while ((line = bufferedReader.readLine()) != null) {
	    		log.append(line);
  		}
  		TextView tv = (TextView)findViewById(R.id.textView1);
  		tv.setText(log.toString());
  	} 
	catch (IOException e) {}
```

To know more about this, please refer [this link](https://stackoverflow.com/questions/12692103/read-logcat-programmatically-within-application).



## Pull Request

Have some new ideas or found a bug? Do not hesitate to open an `issue` and make a `pull request`.

## License

**LookAtME** is under [![License: Apache](https://img.shields.io/badge/License-Apache2.0-black.svg)](https://opensource.org/licenses/MIT). See the [LICENSE](.github/LICENSE.md) file for more info.

## Credits
The video being played in the android app is owned solely by Pixar animations and the author lays no claim over the video.

