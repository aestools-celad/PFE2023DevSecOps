#Build stage 
FROM node:alpine as node 
WORKDIR /src 
COPY ./package*.json ./
RUN npm install
COPY . .
RUN npm run build 
RUN rm -rf node_modules
RUN npm install --production




#run stage 

FROM nginx:alpine 
COPY ./conf/default.conf /etc/nginx/conf.d/default.conf

RUN rm -rf /usr/share/nginx/html/*
#COPY ./nginx.conf /etc/nginx/nginx.conf
COPY --from=node /src/dist/renault-application /usr/share/nginx/html/

EXPOSE 80