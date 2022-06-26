package br.com.tresPtecnologia.enviaremail;

import br.com.tresPtecnologia.enviaremail.service.EnviaEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import javax.mail.MessagingException;

@SpringBootApplication
@Slf4j
public class ServicoEmail implements CommandLineRunner {

    private final EnviaEmailService enviaEmailService;

    public ServicoEmail(EnviaEmailService enviaEmailService) {
        this.enviaEmailService = enviaEmailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServicoEmail.class, args);
    }

    @Override
    public void run(String... args) throws MessagingException {
        enviaEmailService.enviar("douglas.versato@gmail.com", "Serviço de E-mail",
                "Email de teste!");


        enviaEmailService.enviarEmailComAnexo("douglas.versato@gmail.com", "Serviço de E-mail com anexo",
                "Email de teste!", new ClassPathResource("arquivos/basket.jpeg"), "Anexo1.jpeg");
    }
}
