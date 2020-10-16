# [Elite Dangerous](https://www.elitedangerous.com/) API


[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/ChristopheCVB/EliteDangerousAPI.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/ChristopheCVB/EliteDangerousAPI/context:java)

This Project is an API that extracts Elite Dangerous data from its log files

## Documentation

TODO

## Releases

TODO

Go to [releases](https://github.com/ChristopheCVB/EliteDangerousAPI/releases)

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

The roadmap can be found [here](https://github.com/ChristopheCVB/EliteDangerousAPI/projects/1)

## [Contributors](https://github.com/ChristopheCVB/EliteDangerousAPI/graphs/contributors)

Special thanks to:

* [ChristopheCVB](https://github.com/ChristopheCVB) Owner
* [Pjiesco](https://github.com/Pjiesco) Events Data parsing
* [XenoPyax](https://github.com/XenoPyax) Initial project completely refactored