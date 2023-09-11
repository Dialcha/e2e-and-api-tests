# SAUCEDEMO E2E WITH WEBDRIVER

## Español:
- Descargar una version de Chromedriver acorde al sistema operativo y la versión de Chrome del siguiente sitio: https://chromedriver.chromium.org/downloads
- Descomprimir el archivo .zip y renombrarlo chromedriver.exe (ya que esta prueba fué desarrollada usando Windows) - En caso de usar Linux, ir al archivo test/java/base/BaseTests y renombrar chromedriver (remover el .exe)
- Crear una carpeta resources en la raiz del proyecto y allí se pega el archivo chromedriver.exe
- Refrescar las dependencias de maven del proyecto
- Ejecutar la prueba con el comando <pre><code> mvn test </code></pre>
- También dependiendo del IDE, puede ejecutar manualmente la prueba "BuyProductsTests"

## English:
- Download a Chromedriver version that matches your operating system and Chrome version from the following site: https://chromedriver.chromium.org/downloads
- Unzip the .zip file and rename it to chromedriver.exe (since this test was developed using Windows) - In case of using Linux, go to the test/java/base/BaseTests file and rename it to chromedriver (remove the .exe).
- Create a resources folder at the project's root and paste the chromedriver.exe file there.
- Refresh the project's Maven dependencies.
- Run the test using the command <pre><code> mvn test </code></pre>
- Depending on your IDE, you can also manually execute the "BuyProductsTests" test.