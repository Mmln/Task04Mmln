package com.stepup.MmlnTask_04;

/*
TODO Сопроводительная записка.
TODO
TODO 1. Баннеры и логи Spring и Testcontainers отключены (смотри файлы application.properties и logback-test.xml).
TODO 2. Скрипт для создания БД называется schema.sql и находится в ресурсах main;
TODO 3. Логирование ошибок  выводится в автоматически создаваемый перезаписываемый
TODO    файл EmptyDateChecking.log в корневом директории проекта;
TODO 4. Общее логирование выводится в автоматически создаваемый перезаписываемый
TODO    файл LogTransformation.log в корневом директории проекта;
TODO 5. Данные загружаются из любого файла *.txt из корневой директории проекта (fioA.txt,fioB.txt,fioC.txt);
TODO 6. Настройки БД находятся в файле application.properties в ресурсах main;
TODO 7. В тест для наглядности вставлен вывод System.out.println;
TODO 8. Если в классе LogDebug выставить "private static boolean debug" в значение true, то выведется
TODO    более подробная отладка (аналог DEBUG_TRIGGER);
TODO 9. Тест сделан один, но покрывает 93% кода;
TODO
*/

import com.stepup.MmlnTask_04.handlers.Handler00Main;
import com.stepup.MmlnTask_04.interfaces.Handler00Mainable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = "com.stepup.MmlnTask_04")
public class MmlnTask04Application {

	public static void main(String[] args) throws IOException {
		System.out.println("MmlnTask_04 started...\n");

		ApplicationContext ctx = SpringApplication.run(MmlnTask04Application.class, args);
		Handler00Mainable handler00Main = ctx.getBean(Handler00Main.class);
		handler00Main.process();
		System.out.println("\nMmlnTask_04 finished...");
	}

}

