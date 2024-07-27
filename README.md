- To console:

```
 git submodule add https://github.com/alexander-topilskii/SonicProject.git
 git commit -m "Добавлен сабмодуль: sonic project"
 git submodule update
```

- to settings:

```
// ------------------- Sonic ------------------- //
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

also:

```
// ------------------- Sonic -------------------//
implementation(projects.sonicState)
implementation(projects.sonicHelpers)
implementation(projects.sonicUi)
// ------------------- Sonic -------------------//
```

Theme builder:
https://material-foundation.github.io/material-theme-builder/

Принципы:

- Знания ускоряют разработку
- шаблоны ускоряют разработку
- проработка ускоряет разработку
- заменяемость быстрее поддерживаемости
