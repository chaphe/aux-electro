function EventBus() {
  this.listeners = {}; // Objeto para almacenar las funciones suscritas a cada tipo de evento

  // Método para enviar un mensaje al iframe padre con el tipo y los datos especificados
  this.emit = (type, data) => {
    window.parent.postMessage({ type, data }, "*");
  };

  // Método para suscribir una función a un tipo de evento
  this.subscribe = (type, fn) => {
    // Si ya hay funciones suscritas a este tipo de evento, se agrega la nueva función al arreglo
    // de funciones. De lo contrario, se crea un nuevo arreglo con la función.
    this.listeners[type]
      ? this.listeners[type].push(fn)
      : (this.listeners[type] = [fn]);
  };

  // Método para cancelar la suscripción de una función a un tipo de evento
  this.unsubscribe = (type, fn) => {
    // Se filtran las funciones suscritas a este tipo de evento para excluir la función especificada
    this.listeners[type] = this.listeners[type].filter(
      (listener) => listener !== fn
    );
  };

  // Método que se ejecuta cada vez que se recibe un mensaje del iframe padre
  this.run = (event) => {
    const {
      data: { type, data },
    } = event;

    // Si hay funciones suscritas a este tipo de evento, se ejecutan con los datos del mensaje recibido
    if (this.listeners[type]) {
      this.listeners[type].forEach((listener) => {
        listener(data);
      });
    }
  };

  // Se agrega un escucha de eventos al objeto `window` para escuchar mensajes entrantes del iframe padre
  window.addEventListener("message", this.run);
}
