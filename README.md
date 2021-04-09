# Jetbrains-Internship-TeamCity

# Задание 

Есть публично доступный сервер <a href="https://teamcity.jetbrains.com/">TeamCity </a>.

Нужно написать hello world тестовый проект с использованием WebDriver + Kotlin (остальные технологии остаются на твое усмотрение). Тест/тесты должны проверять, что сервер доступен и на нем не отвалилась возможность входа под незарегистрированным (guest) пользователем.

Главный критерий выполненного задания - я могу успешно запустить тесты у себя, они проходят.

На окончательное решение будет влиять:

  * логика теста
  * качество и читаемость кода
  * понятность и легкость запуска локально

# Инструкции по сборке
Клонировать репозиторий с кодом 
```bash
git clone https://github.com/Avvessalom/Jetbrains-Internship-TeamCity.git
cd Jetbrains-Internship-TeamCity
```

Далее понадобится `Selenoid` и есть два пути, с использованием `Docker` и без

## С использованием `Docker`а
Установить `Docker` под вашу ос <a href="https://www.docker.com/get-started">здесь</a>

Скачать ` Configuration Manager ` для `Selenoid` <a href="https://github.com/aerokube/cm/releases/tag/1.8.0"> отсюда </a>

или для Linux
```bash
curl -s https://aerokube.com/cm/bash |bash
chmod +x cm
```
Далее для Linux/MacOS
```bash
./cm selenoid start --vnc
```
для Windows
```shell
./cm.exe selenoid start --vnc
```

## Без использования `Docker`
Скачать последний релиз для своей ОС <a href="https://github.com/aerokube/selenoid/releases">отсюда</a>

**Для запуска `Selenoid`**

Для Linux/MaxOS
```shell
./cm selenoid_linux_amd64 start -conf ./browsersL.json -disable-docker
```

Для Windows
```shell
./cm selenoid_wndows_amd64.exe start -conf ./browsers.json -disable-docker
```

# Для запуска 
```shell
gradlew build
```
