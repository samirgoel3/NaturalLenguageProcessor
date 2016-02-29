# NaturalLenguageProcessor

NaturalLenguageProcessor is an Android library that wraps text-processing.com API and gives you the posibility to stem, to tag and to analyze sentimentally the text you want. 
(aqui foto)
## Sample project

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

## Gradle Dependency

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



