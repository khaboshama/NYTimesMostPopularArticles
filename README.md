## NYTimesMostPopularArticles
A simple app to hit the NY Times Most Popular Articles API and show a list of articles, that shows details when items on the list are tapped (a typical master/detail app). This project implements MVVM architecture using Retrofit, Room, Coroutines, LiveData and DataBinding.
This application is Android application which displays the most popular articles. I used MVVM design pattern to divide the application into three parts, model, view and view model.
## Screenshots resources:
<br>
<p align="center">
   <img width="250" src="https://user-images.githubusercontent.com/5102649/107129644-79728780-68cf-11eb-99e9-5817d70d5916.png">
   <img width="250" src="https://user-images.githubusercontent.com/5102649/107129647-7c6d7800-68cf-11eb-8d51-55b0a701ad16.png">
</p>


## Guide to app architecture
<br>
<p align="center">
  <img src="https://user-images.githubusercontent.com/5102649/107129642-78415a80-68cf-11eb-83de-fee045b4d7bc.PNG">
</p>
<br>

## The app has following packages:
1. **base**: It contains all the base classes of the application.
2. **constant**: It contains the constants class of the application.
3. **model**: It contains the database, network, repository, response and shared preference classes of the application.
4. **ui**: It contains the packages of each screen and each package contains View, viewModel and adapter of the screen.
5. **utils**: It contains the utils classes of the application.



## Library reference resources:
1. Coroutines: https://codelabs.developers.google.com/codelabs/kotlin-coroutines/
2. Retrofit: https://square.github.io/retrofit/
3. Room: https://developer.android.com/topic/libraries/architecture/room.html
4. DataBinding: https://developer.android.com/topic/libraries/data-binding
5. Espresso: https://developer.android.com/training/testing/espresso

## License
```
   Copyright (C) 2019 khaled Aboshama

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
