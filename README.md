## To console:

```
 git submodule add https://github.com/alexander-topilskii/SonicProject.git
 git commit -m "Добавлен сабмодуль: sonic project"
 git submodule update
```

## to settings:

```

// ------------------- Sonic ------------------- //
include(":data_storage_template")
project(":data_storage_template").projectDir = file("SonicProject/data_storage_template")

include(":sonic_helpers")
project(":sonic_helpers").projectDir = file("SonicProject/sonic_helpers")

include(":decompose_template")
project(":decompose_template").projectDir = file("SonicProject/decompose_template")

include(":decompose_stack_template")
project(":decompose_stack_template").projectDir = file("SonicProject/decompose_stack_template")

include(":sonic_ui")
project(":sonic_ui").projectDir = file("SonicProject/sonic_ui")

include(":sonic_state")
project(":sonic_state").projectDir = file("SonicProject/sonic_state")
// ------------------- Sonic ------------------- //
```

## All modules 

```
// ------------------- Sonic -------------------//
implementation(projects.sonicState)
implementation(projects.sonicHelpers)
implementation(projects.sonicUi)
// ------------------- Sonic -------------------//
```

## project gradle

```kotlin 
  alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.jetbrains.compose) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.google.services) apply true
```

## module gralde app

Theme builder:
https://material-foundation.github.io/material-theme-builder/

Принципы:

- Знания ускоряют разработку
- шаблоны ускоряют разработку
- проработка ускоряет разработку
- заменяемость быстрее поддерживаемости
