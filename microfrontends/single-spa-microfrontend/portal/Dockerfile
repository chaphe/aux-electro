# build environment
FROM node:16-alpine3.17 AS builder

WORKDIR /app

COPY package.json .
COPY package-lock.json .

RUN npm install && npm cache clean --force

COPY . .

EXPOSE 9000

CMD ["npm", "run", "watch"]

