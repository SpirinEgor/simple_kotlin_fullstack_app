FROM nginx:latest

COPY client/build/distributions /usr/share/nginx/html
