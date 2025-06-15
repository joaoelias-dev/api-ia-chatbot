Explicação das Pastas
Pasta	    Responsabilidade
config/	    Beans, configurações de CORS, segurança, Swagger/OpenAPI, JPA, etc.
exception/	Exceptions genéricas e o @ControllerAdvice para tratamento centralizado
shared/	    Objetos reutilizáveis (ex: enum global, validações customizadas, mappers base)
modules/	Agrupamento por domínio — facilita manutenção e modularização
controller/	Endpoints da API (@RestController)
dto/	    Objetos de entrada e saída da API (RequestDTO, ResponseDTO, etc.)
model/	    Entidades JPA (@Entity)
repository/	Interfaces extends JpaRepository ou customizadas
service/	Regras de negócio (serviços)
mapper/	    Conversores DTO ↔ Entity (pode usar MapStruct)
exception/	Exceções específicas daquele módulo

# api-ia-chatbot

1. Instale o Ollama (caso ainda não tenha):
curl -fsSL https://ollama.com/install.sh | sh

2. Inicie o serviço Ollama:
ollama serve

3. Baixe o modelo desejado (por exemplo, llama3):
ollama pull llama3

4. Use o modelo:
ollama run llama3

Se você está usando o Ollama como backend para sua API, basta garantir que o serviço está rodando (ollama serve) e que o modelo (llama3) já foi baixado.

Dica:
Você pode listar os modelos disponíveis com:
ollama list