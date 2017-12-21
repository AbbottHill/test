package com.cd.test.test.sprnContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * 2017-12-21 11:52:05
 * The example above shows the basic concept of dependency injection,
 * the MessagePrinter is decoupled from the MessageService implementation,
 * with Spring Framework wiring everything together.
 */

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService getMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}