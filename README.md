# back-exam-full-stack
**Desarrollo backend - Fullstack Developer candidates tech exam**

### GIT CLONE
````
  git clone https://github.com/JTIBA-14/back-exam-full-stack.git
````


Se agrega ***docker*** para proveer la base de datos en ***postgressql***  el cual esta ubicado en 
```
  main/resources/docker-postsgres/docker-compose.yml
```
#### Ejecutar docker
  **1.** se accede a la carpeta donde se encuentra ubicado el archivo y se ejecutoa el sigunete comando:
  ```
    docker-compose up -d
  ```
  **2.** se debe crear una base de datos con el sisgiente nombre
  ``` 
    prueba_exam 
  ```
  **3.** La conexión a la base de datos se establecio con las siguientes credenciales:
  ``` 
    user: postsgres
    password: postgres-exam
  ```
  en caso de querer **modificar** estos datos de **conexión** se debe dirigir al archvo **application-dev.yml**
  ````
    src/main/resources/application-dev.yml
  ````
  
Una vez se tenga ***inicializado*** el **docker** y posteriormente se haya creado la base de datos para trabajar se procede a inicializar el proyecto el cual esta desarrollo con ***spring boot 2.3.0***   

