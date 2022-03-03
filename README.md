# [Elite Dangerous](https://www.elitedangerous.com/) API

[![Build, Coverage and Publish Release](https://github.com/ChristopheCVB/EliteDangerousAPI/workflows/Build,%20Coverage%20and%20Publish%20Release/badge.svg)](#Elite-Dangerous-API)
[![Build and Publish Snapshot](https://github.com/ChristopheCVB/EliteDangerousAPI/workflows/Build%20and%20Publish%20Snapshot/badge.svg)](#Elite-Dangerous-API)
[![Code Coverage](https://codecov.io/gh/ChristopheCVB/EliteDangerousAPI/branch/master/graph/badge.svg)](https://codecov.io/gh/ChristopheCVB/EliteDangerousAPI)
[![Language gradle: Java](https://img.shields.io/lgtm/grade/java/g/ChristopheCVB/EliteDangerousAPI.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/ChristopheCVB/EliteDangerousAPI/context:java)

This Project is an API that extracts Elite Dangerous data from its log files

## Documentation

Execute `gradle javaDoc`

## Releases

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
                .addEventListener(StatusEvent.class, event -> {
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