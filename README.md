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

include(":di")
project(":di").projectDir = file("SonicProject/di")
```
