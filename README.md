# Projeto de Envio de Email


 Projeto simples com Java e Spring Boot para enviar email utilizando contas do Gmail.
 
 Vídeo: https://youtu.be/so3nq5NapHA
 

## Pré Requisitos

 - Maven 3.6
 - Java 11
 - Conta de email no [Gmail](https://mail.google.com)
 - Código no GitHub [Feltex](https://github.com/feltex/ServicoEmailSimples)


## Criando o jar

    mvn clean package

## Executando o projeto

- Utilizando o arquivo jar

```
    export SPRING_EMAIL_USERNAME=usuario1.feltex@gmail.com
    export SPRING_EMAIL_PASSWORD=********************

    java -jar target/ServicoEmail.jar 
```

- Utilizando o maven

```
    export SPRING_EMAIL_USERNAME=usuario1.feltex@gmail.com
    export SPRING_EMAIL_PASSWORD=********************
    
    mvn spring-boot:run
```


## Possíveis erros

1. Erro de acesso `535-5.7.8 Username and Password not accepted.`  

```
 # Caused by: org.springframework.mail.MailAuthenticationException: Authentication failed; nested exception is javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted. Learn more at
 # 535 5.7.8  https://support.google.com/mail/?p=BadCredentials m35sm5842510wms.1 - gsmtp
```

1. Confirme se usuário e senha estão corretos.
2. Desabilite a verificação em 2 [etapas](https://support.google.com/accounts/answer/1064203?hl=pt-BR&co=GENIE.Platform%3DDesktop)
3. Para enviar email em sua aplicação você precisa habilitar uma configuração de segurança no Gmail
   1. Habilitando aplicações menos Seguras no GMail[detalhes](https://support.google.com/accounts/answer/6010255?hl=pt).

4. Devido atualizações de segurança do Google, não é mais possível utilizar a senha da conta para enviar emails.
   Para continuar com o serviço de envio, devemos criar uma 'senha de App'.
5. Para criar uma senha de App, devemos acessar https://myaccount.google.com/
   1. Clicar na Aba 'Segurança'
   2. Em "Como fazer login no Google", selecione Senhas de app. 
      1. Obs. O login em duas etapas deve estar ativado para que seja possível criar senhas de Apps
   3. Criar a senha de App com nome proprio. 