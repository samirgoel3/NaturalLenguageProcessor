# NaturalLenguageProcessor
[![](https://jitpack.io/v/alejandrohall/NaturalLenguageProcessor.svg)](https://jitpack.io/#alejandrohall/NaturalLenguageProcessor)

NaturalLenguageProcessor is an Android library that wraps text-processing.com API and gives you the possibility to stem, to tag and to analyze sentimentally the text you want. 

## Gradle Dependency

Add it in your root build.gradle at the end of repositories:
```java
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
Add the dependency
```java
	dependencies {
	        compile 'com.github.alejandrohall:NaturalLenguageProcessor:1.0'
	}
```



## Usage
```java
NaturalLenguageProcessor naturalLanguageProcessor = new NaturalLenguageProcessor();

naturalLanguageProcessor.sentiment("Some text", Language.ENGLISH)
                .async(new Callback<SentimentResponse>() {  //You can make the request synchronous or asynchronous 
                    @Override
                    public void onResponse(SentimentResponse response) {
                        //handle successful response
                    }

                    @Override
                    public void onFailure(int errorCode, String errorMsg) {
                        //handle failure
                    }

                    @Override
                    public void onError(Throwable e) {
                        //handle error
                    }
                });
                
                
StemResponse stemResponse = naturalLanguageProcessor.stem("Some text", Language.ENGLISH, StemmingAlgorithm.PORTER)
                .sync();
                
TagResponse tagResponse =  naturalLanguageProcessor.tag("Some text", Language.ENGLISH, Output.SEXPR)
                .sync();
```

### Note
For more information about restriction or combination of Language, Output or StemmingAlgorithm, visit text-processing.com


## License
	Copyright 2016 Alejandro P. Hall

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
	