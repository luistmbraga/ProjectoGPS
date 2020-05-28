Para correr a ferramenta desenvolvida existem duas formas:
	
	# USANDO MAKEFILE (tem que ter o intrepertador de makefile instalado)

	Nota: o ficheiro makefile encontra-se na diretoria src/makefile

	(deslocar-se para a diretoria onde se encontra o makefile)
		cd src/

	Existem duas alternativas para correr a ferramenta através do makefile:
		
		Alternativa 1:
		
		(compilar e executar o código)
			- make run_java

		Alternativa 2: (MAIS RECOMENDADO)

		(executar o jar da ferramenta)
			- make run_jar

	

	# NÃO USAR MAKEFILE

	Caso não tenha makefile instalado pode tentar as seguintes alternativas:

		Alternativa 1:
			adicionar a pasta src a um projeto de uma IDE e fazer run da class GProject.java

		Alternativa 2:
			
			(deslocar-se para a diretoria src)
				cd src

			(executar o código)
				javac *.java
				java GProject
		Alternativa 3:

			(deslocar-se para a diretoria src)
				cd src

			(executar o jar)
				java -jar projeto-gps.jar

		Nota: ATENÇÃO não é possível correr o jar ao carregar no icon do jar, tem de ser através de linha de comandos

