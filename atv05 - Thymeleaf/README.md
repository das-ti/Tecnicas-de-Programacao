# 📦 Atividade Prática 5 — Thymeleaf com Spring Boot

Projeto desenvolvido como parte da Atividade Prática 5, utilizando **Spring Boot** e **Thymeleaf** para criação de um sistema simples de cadastro de produtos com interface web dinâmica.

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.x
- Thymeleaf
- Spring Web MVC
- Maven
- HTML5 / CSS3

---

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/exemplo/produtos/
│   │   ├── controller/
│   │   │   └── ProdutoController.java
│   │   ├── model/
│   │   │   └── Produto.java
│   │   └── ProdutosApplication.java
│   └── resources/
│       ├── templates/
│       │   ├── lista.html
│       │   └── form.html
│       └── static/
│           └── css/
│               └── style.css
pom.xml
README.md
```

---

## ✅ Funcionalidades Implementadas

### 🟢 Nível 1 — Básico

#### 1. Quarto atributo no produto — `estoque` (int)

O modelo `Produto.java` foi atualizado com o campo `estoque`:

```java
public class Produto {
    private String nome;
    private double preco;
    private String categoria;
    private int estoque; // ← novo campo

    // getters e setters
}
```

O formulário (`form.html`) e a tabela (`lista.html`) foram atualizados para exibir e receber esse campo.

**Trecho do formulário:**
```html
<label for="estoque">Estoque:</label>
<input type="number" id="estoque" name="estoque" th:field="*{estoque}" min="0" />
```

**Trecho da tabela:**
```html
<th>Estoque</th>
...
<td th:text="${produto.estoque}"></td>
```

---

#### 2. Estilo CSS básico

O arquivo `src/main/resources/static/css/style.css` foi criado com estilos aplicados às páginas:

```css
body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f8;
    color: #333;
    padding: 20px;
}

h1 {
    color: #2c3e50;
    border-bottom: 2px solid #3498db;
    padding-bottom: 8px;
}

table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

th, td {
    border: 1px solid #ddd;
    padding: 10px 14px;
    text-align: left;
}

th {
    background-color: #3498db;
    color: white;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

input, select, button {
    padding: 8px 12px;
    margin: 6px 0;
    border-radius: 4px;
    border: 1px solid #ccc;
}

button {
    background-color: #3498db;
    color: white;
    border: none;
    cursor: pointer;
}

button:hover {
    background-color: #2980b9;
}
```

O CSS é vinculado nos HTMLs com:
```html
<link rel="stylesheet" th:href="@{/css/style.css}" />
```

---

#### 3. Total de produtos cadastrados

Ao final da tabela em `lista.html`, o total de produtos é exibido dinamicamente:

```html
<p>Total de produtos cadastrados: <strong th:text="${produtos.size()}"></strong></p>
```

O controller passa a lista completa ao modelo:
```java
model.addAttribute("produtos", listaDeProdutos);
```

---

### 🟡 Nível 2 — Intermediário

#### 1. Campo de select para categoria

No formulário (`form.html`), foi adicionado um dropdown com categorias fixas:

```html
<label for="categoria">Categoria:</label>
<select id="categoria" name="categoria" th:field="*{categoria}">
    <option value="">Selecione...</option>
    <option value="Eletrônico">Eletrônico</option>
    <option value="Vestuário">Vestuário</option>
    <option value="Alimento">Alimento</option>
    <option value="Outros">Outros</option>
</select>
```

---

#### 2. Validação de preço negativo

A validação é feita no controller antes de adicionar o produto à lista:

```java
@PostMapping("/salvar")
public String salvar(@ModelAttribute Produto produto, Model model) {
    if (produto.getPreco() < 0) {
        model.addAttribute("erro", "O preço não pode ser negativo.");
        return "form";
    }
    listaDeProdutos.add(produto);
    return "redirect:/produtos";
}
```

A mensagem de erro é exibida condicionalmente no formulário com Thymeleaf:

```html
<p th:if="${erro}" th:text="${erro}" style="color: red; font-weight: bold;"></p>
```

---

#### 3. Botão "Remover" na tabela

Foi adicionada uma coluna **Ações** na tabela de `lista.html` com um botão de remoção:

```html
<th>Ações</th>
...
<td>
    <form th:action="@{/produtos/remover/{index}(index=${produtoStat.index})}" method="post">
        <button type="submit" style="background-color: #e74c3c;">Remover</button>
    </form>
</td>
```

> **Nota:** O atributo `th:each="produto, produtoStat : ${produtos}"` captura o índice `produtoStat.index` para identificar qual produto remover.

O controller processa a remoção pelo índice:

```java
@PostMapping("/remover/{index}")
public String remover(@PathVariable int index) {
    if (index >= 0 && index < listaDeProdutos.size()) {
        listaDeProdutos.remove(index);
    }
    return "redirect:/produtos";
}
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior instalado
- Maven instalado (ou use o wrapper `./mvnw`)

### Passo a passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. **Compile e execute com Maven:**
   ```bash
   mvn spring-boot:run
   ```

3. **Acesse no navegador:**
   ```
   http://localhost:8080/produtos
   ```

---

## 🖥️ Rotas da Aplicação

| Método | Rota                      | Descrição                        |
|--------|---------------------------|----------------------------------|
| GET    | `/produtos`               | Lista todos os produtos          |
| GET    | `/produtos/novo`          | Exibe o formulário de cadastro   |
| POST   | `/produtos/salvar`        | Salva um novo produto            |
| POST   | `/produtos/remover/{id}`  | Remove um produto pelo índice    |

---

## 📌 Observações

- Os dados são armazenados **em memória** (lista estática no controller), ou seja, são perdidos ao reiniciar a aplicação. Para persistência, seria necessário integrar um banco de dados com Spring Data JPA.
- As validações implementadas são **básicas e manuais**. Em projetos maiores, recomenda-se usar `@Valid` com Bean Validation (Hibernate Validator).

---

## 👨‍💻 Autor

Desenvolvido como exercício acadêmico da disciplina de **Desenvolvimento Web com Java**.
