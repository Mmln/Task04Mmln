### Описание

#### _Внимание!!! Проект нормально загружается из GitHub в IntelliJ IDEA(Community Edition)_

Перед запуском основной задачи MmlnTask04Application необходимо запустить Docker c БД PostgresSql, порт 5432.
Название контейнера, имя пользователя и пароль находятся в файле   
\main\java\com\stepup\MmlnTask_04\resouces\application.properties  
Для запуска теста MmlnTask04ApplicationTests необходимо, чтобы был создан image postgres:15-alpine

Задача была сделана и принята в предыдущем круге обучения где-то после 28/04/2024.
Сейчас была немного подрефакторена и доработана. 

1. Вся обработка помещена в один конвейер с итерфейсом ConveyerDataProcessingAble (слабосвязанность до упора!!!);
2. Аннотацией @Order задан порядок работы;
1. Баннеры и логи Spring и Testcontainers отключены (смотри файлы application.properties и logback-test.xml).
2. Скрипт для создания БД называется schema.sql и находится в ресурсах main;
3. Логирование ошибок  выводится в автоматически создаваемый перезаписываемый
   файл EmptyDateChecking.log в корневом директории проекта;
4. Общее логирование выводится в автоматически создаваемый перезаписываемый
   файл LogTransformation.log в корневом директории проекта;
5. Данные загружаются из любого файла *.txt из корневой директории проекта (fioA.txt,fioB.txt,fioC.txt);
6. Настройки БД находятся в файле application.properties в ресурсах main;
7. В тест для наглядности вставлен вывод System.out.println;
8. Если в классе LogDebug выставить "private static boolean debug" в значение true, то выведется
   более подробная отладка (аналог DEBUG_TRIGGER);
9. Интерграционный тест сделан один, но покрывает около 90% кода;

#### _Протокол выполнения MmlnTask04Application_  

Task04Mmln started...  

DataFromFile checking started...  
Handler01FileReader called  
Checker01Fio called  
Checker02AppType called  
Checker03Date called  
Handler02DbWirter called  
DataFromFile checking finished...  

Task04Mmln finished...  


#### _Протокол выполнения MmlnTask04ApplicationTests_  

WARNING: A Java agent has been loaded dynamically (C:\Users\Common\.m2\repository\net\bytebuddy\byte-buddy-agent\1.14.10\byte-buddy-agent-1.14.10.jar)  
WARNING: If a serviceability tool is in use, please run with -XX:+EnableDynamicAgentLoading to hide this warning  
WARNING: If a serviceability tool is not in use, please run with -Djdk.instrument.traceUsage for more information  
WARNING: Dynamic loading of agents will be disallowed by default in a future release  
OpenJDK 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended  

@BeforeEach After deleteAll  
@Test-testDb() Filling DB - started...  

DataFromFile checking started...  
Handler01FileReader called  
Checker01Fio called  
Checker02AppType called  
Checker03Date called  
Handler02DbWirter called  
DataFromFile checking finished...  

@Test-testDb() Filling DB - finished...  
@Test-testDb() Get data from files...  
@Test-testDb() Read data from DB...  
@Test-testDb() Check data form files with data from DB...  
@Test-testDb() Test passed  

@BeforeEach After deleteAll  
@Test-testOK Test passed  

@BeforeEach After deleteAll  
@Test-testHandlers() Assertions.assertNotNull fileReader  
@Test-testHandlers() Assertions.assertNotNull checkFio  
@Test-testHandlers() Assertions.assertNotNull checkerAppType  
@Test-testHandlers() Assertions.assertNotNull checkerDate  
@Test-testHandlers() Assertions.assertNotNull dataWriter  
@Test-testHandlers() Test passed  



