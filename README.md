2. Fazer, em java, uma aplicação que liste os processos ativos, permita ao usuário entrar com o nome ou o PID do processo e o mate.

A aplicação deverá funcionar, minimamente em Windows e Linux (Alunos com Mac podem fazer para os 3 SO).

É notório que cada SO tem comandos diferentes para as ações supracitadas, portanto:

Criar em Eclipse, um novo Java Project com uma classe chamada KillController.java no package controller e uma classe Main.java no package view.

A classe KillController.java deve ter 4 métodos.

- O primeiro, chamado os, que identifica e retorna o nome do Sistema Operacional (Fazê-lo privado)
- O segundo, chamado listaProcessos, que verifica o SO e, de acordo com SO, selecione o comando para listar os processos ativos.

  O método deve receber todas as linhas de saída do processo de listagem e exibi-las em console

- O terceiro, chamado mataPid, que recebe um PID como parâmetro de entrada, verifica o SO e, de acordo com SO, selecione o comando para matar o processo e o finalize
- O quarto, chamado mataNome, que recebe um nome de processo como parâmetro de entrada, verifica o SO e, de acordo com SO, selecione o comando para matar o processo e o finalize
