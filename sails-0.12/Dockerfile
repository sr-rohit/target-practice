FROM node:6.12.0-alpine

WORKDIR /app

ADD . /app

RUN npm install /app

EXPOSE 1337

ENV NAME test

CMD ["node", "/app"]
