package br.com.tresPtecnologia.enviaremail.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
public class EnviaEmailService {

    private final JavaMailSender javaMailSender;

    public EnviaEmailService(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviar(String para, String titulo, String conteudo) {
        log.info("Enviando email para {}", para);

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(para);

        mensagem.setSubject(titulo);
        mensagem.setText(conteudo);

        javaMailSender.send(mensagem);
        log.info("Email enviado com sucesso!");
    }

    /**
     *
     * @param para endereço de email do destinatário
     * @param titulo titulo do email
     * @param conteudo conteúdo(corpo) do email
     * @param arquivo anexo do tipo InputStreamSource
     * @param nomeDoAnexo nome do anexo que será exibido na caixa de entrada do destinatário.
     * @throws MessagingException
     */
    public void enviarEmailComAnexo(String para, String titulo, String conteudo, InputStreamSource arquivo, String nomeDoAnexo) throws MessagingException {
        log.info("Enviando email com anexo para {}", para);
        MimeMessage mensagem = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mensagem, true);

        helper.setTo(para);
        helper.setSubject(titulo);
        helper.setText(conteudo, true);

        helper.addAttachment(nomeDoAnexo, arquivo);

        javaMailSender.send(mensagem);
        log.info("Email com anexo enviado com sucesso.");
    }
}
