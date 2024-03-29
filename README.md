# Java Development Kit (семинары)

![picture for project](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/d00d9980-6133-11ea-96b1-d299da7c5c7f.png)

## Урок 1. Графические интерфейсы

[Перейти в папку Java](https://github.com/Terekhov-A-S/Java_Development_Kit_Seminar1/tree/main/src/main/java)


### Задача.

1. Реализовать клиент-серверное приложение. Начало его можно увидеть в презентации к первому уроку, а можно ориентироваться 
на скриншоты. Результат можно увидеть на скриншотах, которые также можно найти в материалах к уроку.
2. Клиентское приложение должно отправлять сообщения из текстового поля сообщения в серверное приложение по нажатию кнопки 
или по нажатию клавиши Enter на поле ввода сообщения.
3. Продублировать импровизированный лог (историю) чата в файле.
4. При запуске клиента чата заполнять поле истории из файла, если он существует. Обратите внимание, что чаще всего история 
сообщений хранится на сервере и заполнение истории чата лучше делать при соединении с сервером, 
а не при открытии окна клиента.

#### Решение

Для удобства будем использовать один и тот же package. Создаем три класса: [Main](https://github.com/Terekhov-A-S/Java_Development_Kit_Seminar1/blob/main/src/main/java/Main.java), 
[ServerWindow](https://github.com/Terekhov-A-S/Java_Development_Kit_Seminar1/blob/main/src/main/java/ServerWindow.java), 
[ClientGUI](https://github.com/Terekhov-A-S/Java_Development_Kit_Seminar1/blob/main/src/main/java/ClientGUI.java). 
В методе main создаем и вызываем экземпляры классов сервера и двух клиентов.

<details>

  <summary>Нажмите, чтобы открыть код</summary>

```java
import javax.swing.*;

public class Main {

//    public static final String PATH_ICON = "src/main/resources/icon.png";
//    public ImageIcon icon = new ImageIcon(Main.class.getResource(PATH_ICON));

    public static void main(String[] args) {

        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}

```

</details>

После запуска увидим три окна: окно сервера (сервер не запущен, авторизация запрещена) и два окна клиента 
(авторизация не пройдена, история чата не загружена). При попытке остановить сервер из такого состояния 
в логе выводится сообщение "Сервер уже был остановлен".

![start server window and client GUI](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/1_start_server.png)

При попытке подключения к серверу со стороны клиента подключение выполнено не будет. В чате выведется сообщение "Нет подключения к серверу".

![login for stopped server](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/2_no_autorisation.png)

По нажатию кнопки "Запустить сервер" - сервер будет запущен и в лог сервера выведется сообщение об успешном запуске.

![server is run](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/3_zapusk_server.png)

После запуска сервера со стороны клиента появляется возможность произвести подключение, о чем свидетельствует запись в чате. 
Так же в чат подгружается ранее сохраненная история сообщений (весь лог хранится на стороне сервера).

![authorisation](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/4_autorisation.png)

Для проверки набираем сообщение в окне одного из клиентов.

![typing message](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/5_proverka.png)

По нажатию кнопки "Отправить" сообщение успешно подгружается в лог сервера и чаты клиентов.

![send message](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/6_proverka.png)

Мы убедились, что все успешно работает, теперь можно остановить сервер и сохранить логи нажатием на кнопку "Остановить сервер".
После этого сервер будет остановлен, все клиенты будут отключены от него, о чем в чате клиентов будет свидетельствовать сообщение 
"Вы были отключены от сервера". В логе сервера так же выведется сообщение "Успешная остановка сервера"

![stop server](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/7_stop_server.png)

Попытка отправить сообщение на остановленный сервер обернется неудачей, о чем будет сообщено в чате клиента.

![server not found](https://raw.githubusercontent.com/Terekhov-A-S/Java_Development_Kit_Seminar1/main/src/main/resources/8_net_otveta.png)



---


*Подготовил студент Geek Brains* [**`Терехов Александр`**](https://gb.ru/users/1db43d0f-6c3d-46d1-bf5e-974b49af6f0d), Java_Development_Kit_Seminar1
