FROM java8.base
COPY build/installShadow /home
#RUN sh -c 'touch /app.jar'
RUN sh -c 'chmod u+x start.sh'
ENTRYPOINT ["./start.sh"]