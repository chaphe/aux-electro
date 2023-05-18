const sendReceivedMessageToAllIframes = (event) => {
  // Función para enviar un mensaje recibido a todos los iframes

  document
    .querySelectorAll("iframe") // Selecciona todos los elementos iframe en el documento
    .forEach((iframe) => iframe.contentWindow.postMessage(event.data, "*"));
  // Para cada iframe seleccionado, utiliza la propiedad contentWindow para obtener su ventana interna.
  // Luego, llama a postMessage en esa ventana interna, enviando el mensaje recibido (event.data) a todos los iframes.
};

window.addEventListener("message", sendReceivedMessageToAllIframes);
// Agrega un event listener para el evento 'message' en la ventana actual.
// Cuando se reciba un mensaje, se ejecutará la función sendReceivedMessageToAllIframes.
