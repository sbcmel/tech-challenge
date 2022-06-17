FROM nginx
EXPOSE 80
EXPOSE 8080
RUN rm -r /usr/share/nginx/html*
COPY default.conf /etc/nginx/conf.d/default.conf
CMD ["nginx", "-g", "daemon off;"]
