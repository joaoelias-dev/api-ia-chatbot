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