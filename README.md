# Programa de Registro de Pessoas

Este programa permite registrar informações de pessoas, como nome, telefone e documentos como CPF, Carteira de Identidade (CI), Carteira Nacional de Habilitação (CNH) e Título de Eleitor (TE).

## Como utilizar o programa

1. Execute o programa Java `Main.java`.
2. Será exibida a tela inicial com as seguintes opções:
   - Digite 1: Registrar Pessoa
   - Digite 2: Apagar Pessoa
   - Digite 0: Para finalizar o programa
3. Escolha uma das opções digitando o número correspondente e pressione Enter.
4. Caso selecione a opção 1, será iniciado o processo de registro de uma nova pessoa.
5. Siga as instruções exibidas no console para preencher as informações da pessoa.
6. Após fornecer as informações necessárias, o cadastro será realizado com sucesso.
7. Você retornará à tela inicial e poderá escolher uma nova opção.
8. Se selecionar a opção 2, será solicitado o nome da pessoa que deseja apagar.
9. Digite o nome da pessoa e pressione Enter.
10. Se a pessoa for encontrada e removida com sucesso, você receberá uma confirmação.
11. Caso contrário, será exibida uma mensagem de falha.
12. O programa voltará à tela inicial para selecionar uma nova opção.
13. Se escolher a opção 0, o programa será finalizado.

## Requisitos

- Java Development Kit (JDK) instalado.

## Executar o programa

1. Abra um terminal ou prompt de comando.
2. Navegue até o diretório onde o arquivo `Main.java` está localizado.
3. Compile o arquivo Java executando o seguinte comando:

javac Main.java

4. Após a compilação bem-sucedida, execute o programa com o comando:

java Main

5. Siga as instruções exibidas no console para interagir com o programa.

## Observações

- O programa foi desenvolvido em Java.
- Certifique-se de ter o JDK instalado para compilar e executar o programa.
- Certifique-se de que todos os arquivos estão no mesmo pacote `t1`.
- Certifique-se de que a classe `Main` está definida no arquivo `Main.java`.
- O programa registra informações de pessoas, incluindo nome, telefone e documentos como CPF, Carteira de Identidade (CI), Carteira Nacional de Habilitação (CNH) e Título de Eleitor (TE).
- As opções disponíveis são: registrar uma nova pessoa, apagar uma pessoa existente e finalizar o programa.
- Siga as instruções fornecidas no console para registrar uma pessoa ou apagar uma pessoa.
- Certifique-se de fornecer as informações corretas e seguir os formatos solicitados.
- O programa faz uso de classes auxiliares, como `CPF`, `CI`, `CNH` e `TE`, para lidar com os diferentes documentos.
- O programa utiliza um vetor para armazenar as pessoas registradas. O tamanho inicial do vetor é de 10, mas é possível adicionar mais pessoas e o vetor se ajustará dinamicamente.
- O programa organiza as pessoas registradas em ordem alfabética pelo nome.
- O programa utiliza o algoritmo de busca binária para localizar pessoas pelo nome.
