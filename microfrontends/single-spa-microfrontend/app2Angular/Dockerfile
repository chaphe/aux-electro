# build environment
FROM node:8.9 AS builder

WORKDIR /app

COPY package.json .
COPY package-lock.json .

RUN npm install && npm cache clean --force

COPY . .

EXPOSE 9002

CMD ["npm", "run", "watch:portal"]

