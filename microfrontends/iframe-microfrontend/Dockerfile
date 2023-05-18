# Establecer la imagen base
FROM node:14-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos de la aplicación
COPY package*.json ./
COPY . .

# Instalar las dependencias
RUN npm install

# Exponer el puerto en el que se ejecutará la aplicación Angular
EXPOSE 5000

# Ejecutar los comandos npm run watch y npm start
CMD ["npm", "run", "start:express"]
