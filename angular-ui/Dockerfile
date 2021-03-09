FROM node:14.15.4

RUN mkdir /usr/src/app
WORKDIR /usr/src/app

RUN npm install -g @angular/cli

COPY . /usr/src/app

CMD ng serve --host 0.0.0.0 --port 4200