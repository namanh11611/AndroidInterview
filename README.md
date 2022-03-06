# Android Interview

### Service ([See more](https://developer.android.com/guide/components/services))
* These are the three different types of services:
  - Foreground: performs some operation that is noticeable to the user.
  For example, playing an audio track.
  - Background: performs an operation that isn't directly noticed by the user.
  For example, compacting app's storage.
  - Bound: when an application component binds to it by calling bindService(), offers a client-server
  interface that allows components to interact with the service, send requests, receive results.

### Data and File Storage ([See more](https://developer.android.com/training/data-storage))
* App-specific storage:
  - From internal storage, getFilesDir() or getCacheDir()
  - From external storage, getExternalFilesDir() or getExternalCacheDir()

