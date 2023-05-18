const express = require("express"); // Importa el módulo Express
const path = require("path"); // Importa el módulo Path

const app = express(); // Crea una nueva instancia de la aplicación Express

const publicDirectoryPath = path.join(__dirname, "/"); // Obtiene la ruta absoluta del directorio público

app.use(express.static(publicDirectoryPath));
// Configura Express para servir archivos estáticos desde el directorio público.
// Esto permite que los archivos HTML, CSS, JavaScript u otros recursos sean accesibles desde el cliente.

app.use((_req, res, _next) => {
  // Define un middleware para manejar todas las solicitudes que no coincidan con las rutas definidas anteriormente.
  // En este caso, redirige todas las solicitudes a "/composition.html".
  res.redirect("/composition.html");
});

app.listen(5000, () => {
  console.log("Server is running on port 5000");
});
// Inicia el servidor Express en el puerto 5000.
// Cuando el servidor se inicia con éxito, se muestra un mensaje en la consola.
