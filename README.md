Olá,

**Tecnologias**: 
- Spring boot versão 3.3.4;
- Banco de dados: H2.

**Para executar**:
- Inicie a aplicação pela classe main "ProjetoApplication.java", utilizando como base a porta 8080, abra em seu navegador a URL: http://localhost:8080/h2-console, conforme as propriedades da aplicação, o banco não tem senha, apenas a URL de acesso "jdbc:h2:mem:testdb".
- Depois, para testar as requisições de criação de usuário, listagem, remoção e LOGIN, você pode usar o arquivo "APIRest SegurancaInfo.postman_collection.json" e importar a biblioteca diretamente no seu Postman, assim podendo iniciar os testes.

**Criptografia da senha**:
- Para resumir a senha, foi utilizado uma função de hash usando MD5, dentro do pacote Util temos a classe MD5Util.java que realiza a criptografia da senha, utilizando a biblioteca MessageDigest. Na classe controle, o método de save do usuario criado possui uma função que resume a senha antes de salvar no banco de dados. Após isso, em uma chamada GET para listar o usuário ou apenas visualizando no banco, já será possível ver a senha hasheada.
