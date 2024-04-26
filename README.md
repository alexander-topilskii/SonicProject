- To console:
  
 git submodule add https://github.com/alexander-topilskii/SonicProject.git

 git commit -m "Добавлен сабмодуль: sonic project"

 git submodule update

- to settings:
```
include(":sonic_ui")
project(":sonic_ui").projectDir = file("SonicProject/sonic_ui")

include(":sonic_presentetion")
project(":sonic_presentetion").projectDir = file("SonicProject/sonic_presentetion")

include(":sonic_domain")
project(":sonic_domain").projectDir = file("SonicProject/sonic_domain")

include(":sonic_repository")
project(":sonic_repository").projectDir = file("SonicProject/sonic_repository")

include(":sonic_template")
project(":sonic_template").projectDir = file("SonicProject/sonic_template")

include(":sonic_di")
project(":sonic_di").projectDir = file("SonicProject/sonic_di")
```
also:
```
// ------------------- Sonic -------------------//
implementation(project(":sonic_ui"))            //
implementation(project(":sonic_presentetion"))  //
implementation(project(":sonic_domain"))        //
implementation(project(":sonic_repository"))    //
implementation(project(":sonic_di"))            //
implementation(project(":sonic_template"))      //
// ------------------- Sonic -------------------//
```