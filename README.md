📊 Sprint TOTVS
===============

📋 Sobre o Projeto
------------------
O Sprint TOTVS é uma aplicação integrada que combina Java (Spring Boot) para o backend, Python para processamento de dados e IA para análise inteligente. O sistema foi desenvolvido para gerenciar e analisar dados de eventos (reuniões), oferecendo uma interface web para interação com modelos de IA.

🚀 Tecnologias Utilizadas
-------------------------
- Backend: Java 21, Spring Boot
- Frontend: HTML/CSS/JS (Thymeleaf ou similar)
- IA/Processamento: Python, C, C++ (modelos auxiliares)
- Banco de Dados: Conectado à nuvem (configuração externa)
- Build: Maven/Gradle

📁 Estrutura do Projeto
-----------------------
sprint_totvs/
├── java/               # Código principal em Java (Spring Boot)
│   └── com.sprint/
│       └── src/main/java/com.sprint2/
│           ├── IA/          # Integração com IA (Prompt.java)
│           └── dataBase/    # Conexão e consultas ao banco
├── python/             # Scripts de processamento de dados
├── dataBase/           # Configurações e migrações do DB
├── final_limpo.csv     # Dataset tratado para análise
└── README.md

⚙️ Pré-requisitos
-----------------
- JDK 21 (obrigatório para compatibilidade)
- Python 3.8+
- Maven ou Gradle
- Banco de dados configurado (acesso à nuvem)

🛠️ Como Executar
-----------------
1. Clone o repositório:
   git clone https://github.com/vitor12123/sprint_totvs.git
   cd sprint_totvs

2. Configure o JDK 21:
   java -version  # Deve mostrar "21.x.x"

3. Execute a aplicação Java:
   Entre na pasta principal do código:
   cd java/com.sprint/src/main/java/com.sprint2

   Edite o arquivo IA/Prompt.java:
   - No construtor, altere o evento "reuniaoCompleta" para o ID desejado (valores de 1 a 1147)
   - Exemplo: new Prompt(42) para processar o evento com ID 42

   Compile e execute o Spring Boot:
   # Se for Maven
   ./mvnw spring-boot:run

   # Se for Gradle
   ./gradlew bootRun

4. Acesse a interface web:
   http://localhost:8080/chat

🗄️ Banco de Dados
-----------------
O projeto utiliza banco de dados em nuvem (configuração externa). Os arquivos de conexão estão na pasta dataBase/.
- Suporte a consultas: Classe Filtro.java (localizada em com.sprint2/src/dataBase/) para queries personalizadas.

📊 Dataset
----------
O arquivo final_limpo.csv contém os dados tratados de eventos/reuniões (IDs de 1 a 1147). É utilizado tanto pelo Java quanto pelo Python para análises.

🐍 Scripts Python
-----------------
Na pasta python/, você encontra scripts para:
- Limpeza e tratamento dos dados
- Subir os dados csv para um banco de dados.

📝 Licença
----------
Este projeto está sob a licença MIT - veja o arquivo LICENSE para detalhes.

