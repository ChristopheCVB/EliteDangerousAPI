# [Elite Dangerous](https://www.elitedangerous.com/) API


[![Language gradle: Java](https://img.shields.io/lgtm/grade/java/g/ChristopheCVB/EliteDangerousAPI.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/ChristopheCVB/EliteDangerousAPI/context:java)

This Project is an API that extracts Elite Dangerous data from its log files

## Documentation

TODO

## Releases

TODO

Go to [releases](https://github.com/ChristopheCVB/EliteDangerous/releases)

## Get Started

```java
public class EliteDangerousExtractor {
    public static void main(String... args) {
        EliteDangerousAPI eliteDangerousAPI = new EliteDangerousAPI.Builder()
                .addEventListener(SupercruiseEntryEvent.class, event -> {
                    // Do something
                })
                .addEventListener(SupercruiseExitEvent.class, event -> {
                    // Do something
                })
                .setStatusListener(status -> {
                    // Do something
                })
                .build();
        eliteDangerousAPI.start();
        //...
        eliteDangerousAPI.stop();
    }
}
```

## Build

Use the common `gradlew clean` task to clean your build directories.

Use the common `gradlew build` task to build your project.

## ROADMAP

The roadmap can be found [here](https://github.com/ChristopheCVB/EliteDangerous/projects/1)