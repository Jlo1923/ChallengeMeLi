#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_jlo_data2_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}