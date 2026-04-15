Tarefa: Manipulação de Dados de Funcionários com Streams e Lambdas
Contexto:
Você faz parte da equipe de desenvolvimento de uma empresa e recebeu uma
lista de funcionários. Cada funcionário possui os seguintes atributos: nome,
departamento, salário e anos de serviço.
Objetivo:
Implementar um programa em Java que utilize a API de Streams e Expressões
Lambda para realizar diversas operações de manipulação e processamento
dessa lista de funcionários.

Passos da Tarefa:
1. Criação da Classe Funcionario:
o Defina uma classe Funcionario com os atributos:
▪ nome (String)
▪ departamento (String)
▪ salario (double)
▪ anosDeServico (int)
o Implemente os métodos getters e sobrescreva o método toString
para facilitar a visualização dos dados.

2. População da Lista:
o Crie uma lista (por exemplo, um ArrayList) contendo pelo menos 8
objetos Funcionario, distribuídos em pelo menos 3 departamentos
diferentes.
o Atribua valores variados aos atributos, garantindo cenários
distintos para aplicar os filtros e transformações.

3. Operações com Streams e Lambdas:
Utilize a API de Streams para implementar as seguintes operações:
o Filtragem:
▪ Selecione os funcionários que possuem salário superior a
um valor definido (por exemplo, R$ 3000).

o Mapeamento (Map):
▪ Aplique um aumento de 5% no salário para os funcionários
que possuem mais de 10 anos de serviço. Crie novos
objetos ou atualize os existentes conforme sua abordagem.

o Ordenação (Sorted):
▪ Ordene os funcionários pelo nome em ordem alfabética.
o Redução (Reduce):
▪ Calcule o total gasto com salários, somando os salários de
todos os funcionários.
o Agrupamento (GroupingBy):
▪ Agrupe os funcionários por departamento e, para cada
grupo, calcule a média dos salários.

4. Exibição dos Resultados:
o Utilize o método forEach para imprimir a lista resultante das
operações, como os funcionários filtrados e ordenados.
o Exiba separadamente o total calculado e as médias salariais por
departamento.
5. Desafios Adicionais:
o Implemente uma operação para identificar o funcionário com o
maior tempo de serviço utilizando streams.
o Utilize uma expressão lambda para formatar a saída de cada
funcionário de forma personalizada, por exemplo:
"Funcionário: [nome], Departamento: [departamento], Salário: R$
[salario]".