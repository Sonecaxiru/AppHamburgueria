** APP Hamburgueria **

Um App simples utilizando SQLite que permita gerenciar o
cadastro de usuários e exibir um catálogo de produtos de uma hamburgueria.
(Tem link para whats também)

* Descrição *
  
Ele verifica se o e-mail e senha estão corretos no banco de dados. Caso estejam corretos, o usuário terá acesso ao catálogo de produtos.
Leva o usuário para a tela de cadastro caso ele ainda não tenha uma conta.
Caso o usuário não tenha cadastro, ele será direcionado para esta tela.
Salva os dados no banco de dados local (SQLite). Após o cadastro, o usuário poderá utilizar o login e senha para acessar o catálogo.
Inclui um botão para contato via WhatsApp - uma vez clicado deve entrar no whatsApp para fazer o pedido. 

* Funcionalidade *

- Verifica se o e-mail e senha estão corretos no banco de dados.
- Leva o usuário para a tela de cadastro caso ele ainda não tenha uma conta.
- Salva os dados no banco de dados local (SQLite).
- Exibe um catálogo de produtos da hamburgueria com 4 hamburgues e com 4 Bebidas.
- um botão para contato via WhatsApp.
- Com plano de fundo personalizados.
- Com Icones(relacionados com hamburgues).

* Tecnologias Utilizadas *

- Android Studio (Groovys DSL build.gradle | 2024.1.2).
- Java _ para desenvolvimento.
- ConstraintLayout _ para interface responsiva.
- TextView e EditText _ para entrada e exibição de dados.
- Button _ para criar e entrar na conta e no catálogo.
- ImgView _ para enfeitar e decorar o App.
- BackGroup _ para colocar plano de fundo no App.

* Como Rodar o Projeto *

1. Clone este repositório:

    ```bash
   https://github.com/Sonecaxiru/AppHamburgueria.git

    ```

2. Abra o projeto no Android Studio.
3. Compile e execute o projeto em um emulador ou dispositivo físico.
   ## 📂 Estrutura do Projeto
```bash
   AppHamburgueria
├── .gradle
├── .idea
├── app
│   ├── build
│   ├── src
│   │   ├── androidTest
│   │   ├── main
│   │   │   ├── java/ulbra/saolucas/apphamburgueria
│   │   │   │   ├── CatalogActivity.java
│   │   │   │   ├── DatabaseHelper.java
│   │   │   │   ├── LoginActivity.java
│   │   │   │   ├── MainActivity.java
│   │   │   │   └── RegisterActivity.java
│   │   │   ├── res
│   │   │   │   ├── drawable
│   │   │   │   │   ├── agua.png
│   │   │   │   │   ├── cafe.png
│   │   │   │   │   ├── coca.png
│   │   │   │   │   ├── food_icon.png
│   │   │   │   │   ├── food_truck_icon.png
│   │   │   │   │   ├── h1.png
│   │   │   │   │   ├── h2.png
│   │   │   │   │   ├── h3.png
│   │   │   │   │   ├── h4.png
│   │   │   │   │   ├── ic_launcher_background.xml
│   │   │   │   │   ├── ic_launcher_foreground.xml
│   │   │   │   │   ├── one_icon.png
│   │   │   │   │   ├── plano2.jpg
│   │   │   │   │   ├── plano_h.jpg
│   │   │   │   │   ├── suco.png
│   │   │   │   │   ├── suco2.png
│   │   │   │   │   ├── water_icon.png
│   │   │   │   │   └── whats_icon.png
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── cadastro.xml
│   │   │   │   │   └── catalogo.xml
│   │   │   │   ├── mipmap-anydpi-v26
│   │   │   │   ├── mipmap-hdpi
│   │   │   │   ├── mipmap-mdpi
│   │   │   │   ├── mipmap-xhdpi
│   │   │   │   ├── mipmap-xxhdpi
│   │   │   │   ├── mipmap-xxxhdpi
│   │   │   │   ├── values
│   │   │   │   └── values-night
│   │   │   └── xml
│   └── AndroidManifest.xml
└── build.gradle
```

* Design e Prototipagem *

A interface do app foi criada usando **ConstraintLayout** para manter a responsividade em diferentes tamanhos de tela.
O design é personalizado com icones e imagens, mais nada que atrapalhe o visual e a vista.

* Telas do Aplicativo *

1. **Tela de Login**

   ![image](https://github.com/user-attachments/assets/41a12c38-b4b4-475d-844b-316c25386f54)

2. **Tela de Cadastro**

   ![image](https://github.com/user-attachments/assets/b33f6753-8bdf-495a-b527-0dff2e1dc467)

3. **Catálogo**

   ![image](https://github.com/user-attachments/assets/e1d304af-5ca9-4ec5-913f-e189baee5f93)

## 👨‍💻 Desenvolvedores – **Ângelo Vieira T** - Desenvolvedor - [GitHub](https://github.com/Sonecaxiru)  


 ## 📄 Licença
 

Este projeto está licenciado sob os termos da licença MIT. 
Para mais
detalhes, veja o arquivo [LICENSE](https://github.com/Sonecaxiru/AppHamburgueria/blob/master/LICENSE).
  


