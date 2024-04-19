# Use a imagem do OpenJDK 11 como base
FROM openjdk:11

# Copie os arquivos do seu projeto para o diretório de trabalho do contêiner
COPY . /usr/src/app

# Defina o diretório de trabalho
WORKDIR /usr/src/app

# Compile o código Java
RUN javac -d . cadastroclientes/*.java

# Especifique o comando a ser executado quando o contêiner for iniciado
CMD ["java", "cadastroclientes.Main"]
