# build environment
FROM node:14-alpine AS builder

WORKDIR /app

COPY package.json .
COPY package-lock.json .

RUN npm install && npm cache clean --force

COPY . .

EXPOSE 9001

CMD ["npm", "run", "watch:portal"]

