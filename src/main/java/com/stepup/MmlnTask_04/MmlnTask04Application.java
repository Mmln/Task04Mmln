package com.stepup.MmlnTask_04;

import com.stepup.MmlnTask_04.interfaces.ConveyerAble;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableJpaRepositories
public class MmlnTask04Application {

	public static void main(String[] args) throws IOException {
		System.out.println("Task04Mmln started...\n");

		ApplicationContext ctx = SpringApplication.run(MmlnTask04Application.class, args);
		ConveyerAble conveyer = ctx.getBean(Conveyer.class);
		conveyer.produce();
		System.out.println("\nTask04Mmln finished...");

		System.exit(0);
	}

}

