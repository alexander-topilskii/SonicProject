# Оставить классы, которые наследуют от некоторого класса (например, Activity)
-keep public class * extends android.app.Activity
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }

# Оставить классы, использующиеся в XML (например, для View или Serializable объектов)
-keepclassmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

# Оставить методы, вызываемые через рефлексию
-keepclassmembers class * {
    public <methods>;
}
-dontwarn com.squareup.okhttp.CipherSuite
-dontwarn com.squareup.okhttp.ConnectionSpec
-dontwarn com.squareup.okhttp.TlsVersion

-dontwarn android.view.RenderNode
-dontwarn android.view.DisplayListCanvas

-keepclassmembers class androidx.compose.ui.platform.ViewLayerContainer {
    protected void dispatchGetDisplayList(); }

-keepclassmembers class androidx.compose.ui.platform.AndroidComposeView {
    android.view.View findViewByAccessibilityIdTraversal(int); }

# Users can create Modifier.Node instances that implement multiple Modifier.Node interfaces,
# so we cannot tell whether two modifier.node instances are of the same type without using
# reflection to determine the class type. See b/265188224 for more context.
-keep,allowshrinking class * extends androidx.compose.ui.node.ModifierNodeElement


# With R8 full mode generic signatures are stripped for classes that are not
# kept. Suspend functions are wrapped in continuations where the type argument
# is used.
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

# To enable ProGuard in your project, edit project.properties
# to define the proguard.config property as described in that file.
#
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the ProGuard
# include property in project.properties.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Android rules
# https://www.guardsquare.com/en/products/proguard/manual/examples

# Keeping all fundamental classes that may be referenced by the AndroidManifest.xml file of the application.
# If your manifest file contains other classes and methods, you may have to specify those as well.
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

# To save stack trace as readable
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

# To leave only (Log,Timber) error,wtf logs. Find and shrink (v,d,i) methods in specified class and subclasses.
-assumenosideeffects class android.util.Log {
    public static *** v(...);
    public static *** d(...);
    public static *** i(...);
}

# Keeping any custom View extensions and other classes with typical constructors,
# since they might be referenced from XML layout files.
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# Keeping the static fields of referenced inner classes of auto-generated R classes,
# in case your code is accessing those fields by introspection.
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# Keeping annotated Javascript interface methods,
# so they can be exported and accessed by their original names.
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}


# Uncomment if using Serializable
-keepclassmembers class * implements java.io.Serializable {
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Retrofit
# https://github.com/square/retrofit/blob/master/retrofit/src/main/resources/META-INF/proguard/retrofit2.pro
# Retrofit does reflection on generic parameters. InnerClasses is required to use Signature and
# EnclosingMethod is required to use InnerClasses.
-keepattributes Signature, InnerClasses, EnclosingMethod

# Retrofit does reflection on method and parameter annotations.
-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

# Retain service method parameters when optimizing.
-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Ignore annotation used for build tooling.
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement

# Ignore JSR 305 annotations for embedding nullability information.
-dontwarn javax.annotation.**

# Guarded by a NoClassDefFoundError try/catch and only used when on the classpath.
-dontwarn kotlin.Unit

# Top-level functions that can only be used by Kotlin.
-dontwarn retrofit2.KotlinExtensions
-dontwarn retrofit2.KotlinExtensions$*

# With R8 full mode, it sees no subtypes of Retrofit interfaces since they are created with a Proxy
# and replaces all potential values with null. Explicitly keeping the interfaces prevents this.
-if interface * { @retrofit2.http.* <methods>; }
-keep,allowobfuscation interface <1>

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { <fields>; }


# Необходим для Crashlytics
-keep class com.google.firebase.crashlytics.** { *; }
-dontwarn com.google.firebase.crashlytics.**

# // Glide
# https://github.com/bumptech/glide/blob/master/library/proguard-rules.txt
#-keep public class * implements com.bumptech.glide.module.GlideModule
#-keep class * extends com.bumptech.glide.module.AppGlideModule {
# <init>(...);
#}
#-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
#  **[] $VALUES;
#  public *;
#}

-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt

# Product Science
-keep class com.productscience.transformer.module.** { *; }
-keep class com.productscience.** { *; }

# Added with AGP version 8.1.3
-dontwarn org.apiguardian.api.API$Status
-dontwarn org.apiguardian.api.API

# Possibly prevents crash in compose "IncompatibleClassChangeError: Found interface
# androidx.compose.ui.graphics.drawscope.DrawScope, but class was expected..."
-keep class androidx.compose.ui.graphics.drawscope.DrawScope { *; }

-keep class androidx.compose.** { *; }
-keep class androidx.lifecycle.** { *; }
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

-keepclassmembers class androidx.lifecycle.ViewModel {
    public <init>(...);
}

-keepclassmembers class * implements androidx.lifecycle.ViewModel {
    public <init>(...);
}

-dontwarn androidx.compose.**
-dontwarn androidx.lifecycle.**
-dontwarn kotlinx.coroutines.**
-dontwarn kotlin.**

-keepclassmembers class * {
    *** anon*();
}

-keep class androidx.compose.ui.platform.ViewRootForTest$Companion { *; }
-keep class androidx.compose.ui.platform.AbstractComposeView { *; }
-keep class androidx.compose.ui.platform.Wrapper_androidKt { *; }

-keepclassmembers class androidx.compose.ui.platform.ViewRootForTest$Companion {
    public static <fields>;
    public static <methods>;
}

-dontwarn java.lang.invoke.StringConcatFactory