const eventBus = new EventBus(); // Crea una instancia del objeto eventBus

const addToCart = (e) => eventBus.emit("productToCart", e.target.value);
// Define una función llamada addToCart que se ejecuta cuando se hace clic en un botón.
// La función toma un evento como argumento (e) y utiliza el método emit del eventBus para enviar un mensaje con el tipo "productToCart" y el valor del botón como dato.

document
  .querySelectorAll("button") // Selecciona todos los elementos de botón en el documento
  .forEach((button) => button.addEventListener("click", addToCart));
// Para cada botón seleccionado, agrega un event listener para el evento 'click' que ejecuta la función addToCart cuando se hace clic en el botón.
