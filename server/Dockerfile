FROM node:lts-alpine as builder
WORKDIR /usr/app/
COPY package.json /usr/app/
RUN npm install --only=production


FROM node:lts-alpine
ENV NODE_ENV production
WORKDIR /usr/app/
COPY --from=builder /usr/app/node_modules /usr/app/node_modules
COPY --from=builder /usr/app/package.json /usr/app/
COPY config /usr/app/config
COPY src /usr/app/src
EXPOSE 5000
ENTRYPOINT ["node"]
CMD ["src/server.js"]
