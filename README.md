# Ferramenta de análise estática de código

A ferramenta, analisa um ficheiro ou um conjunto de ficheiros(diretoria), identificando e reportando a informação e localização de alguns code smells presentes nos mesmos. A ferramenta gera uma página HTML (diretoria output/index.html), com um índice dos ficheiros, e respetivos code smells.

## Começar a usar

As instruções seguintes apresentam várias alternativas de instalação, que ajudam a começar a utilizar esta ferramenta nos teus projetos de forma simples.

### Pré requisitos

Ferramentas/requisitos necessárias(os):

```
Java 8+
makefile (apenas para executar mais facilmente)
```

### Instalação/execução usando o makefile

Deslocar-se para a diretoria onde se encontra o makefile.

```
cd src/
```
Existem duas alternativas de correr a ferramenta usando o makefile:

Compilar e correr o código.

```
make run_java
```

Correr a ferramenta pelo JAR.

```
make run_jar
```

### Instalação/execução usando o compilador java

Deslocar-se para a diretoria src.

```
cd src/
```

Compilar e executar o código.

```
javac *.java
java GProject
```

### Instalação/execução pelo JAR

Deslocar-se para a diretoria src.

```
cd src/
```

Executar a ferramenta através do JAR.

```			
java -jar projeto-gps.jar
```


### Nota do projecto:
18 valores
