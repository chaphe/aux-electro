const eventBus = new EventBus();
// Se crea una instancia de Vue
new Vue({
  el: "#main", // Selecciona el elemento con el id "main" como el contenedor principal de la aplicación Vue

  data: {
    products: {
      apple: 0, // Inicializa el contador de manzanas en 0
      banana: 0, // Inicializa el contador de plátanos en 0
      orange: 0, // Inicializa el contador de naranjas en 0
    },
  },

  methods: {
    add: function (product) {
      this.products[product]++; // Incrementa el contador del producto especificado en 1
    },
  },

  beforeMount() {
    eventBus.subscribe("productToCart", this.add); // Suscribe el método "add" al evento "productToCart" del bus de eventos antes de que se monte la instancia de Vue
  },

  beforeDestroy() {
    eventBus.unsubscribe("productToCart", this.add); // Cancela la suscripción del método "add" al evento "productToCart" del bus de eventos antes de destruir la instancia de Vue
  },
});
