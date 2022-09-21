FROM nginx:latest

COPY default.conf /etc/nginx/conf.d/default.conf
ADD index.html /usr/share/nginx/html
ADD error.html /usr/share/nginx/html

CMD nginx -g "daemon off;"