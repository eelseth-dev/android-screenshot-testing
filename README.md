# Snapshot Testing

## Shot

### Configuration

Check the following link for details
[Shot repo](https://github.com/pedrovgs/Shot)

### Gradle tasks

To record baseline screenshots

```
./gradlew executeScreenshotTests -Precord 
```

To validate screenshot

```
./gradlew executeScreenshotTests 
```

## Compose Screenshot

### Configuration

Check the following link for details
[Compose screenshot repo](https://developer.android.com/studio/preview/compose-screenshot-testing)

### Gradle tasks

To record baseline screenshots

```
./gradlew updateDebugScreenshotTest
```

To validate screenshots

```
./gradlew validateDebugScreenshotTest 
```
