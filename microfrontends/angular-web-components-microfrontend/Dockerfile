# Establecer la imagen base para la construcción
FROM node:16-alpine3.17 AS builder

# Establecer el directorio de trabajo para la construcción
WORKDIR /app

# Copiar los archivos de la aplicación
COPY package*.json ./
COPY . .

# Instalar las dependencias
RUN npm install

# Copiar el código fuente y compilar la aplicación
COPY projects ./projects
# Se crean los componentes web y se copian dentro del proyecto angular
RUN npm run build:elements

# Se elimina los componentes copiados de la carpeta dist
RUN rm -rf dist

# Se contruye el proyecto angular con los componentes web incorporados
RUN npm run build

# ------------------------------------

# Establecer la imagen base para el servidor web
FROM nginx:alpine

COPY --from=builder /app/dist /usr/share/nginx/html

EXPOSE 80

# Ejecutar el servidor web
CMD ["nginx", "-g", "daemon off;"]