package com.jlo.data2

class NativeLib {

    /**
     * A native method that is implemented by the 'data2' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'data2' library on application startup.
        init {
            System.loadLibrary("data2")
        }
    }
}