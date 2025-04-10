FROM node:18-alpine AS builder

WORKDIR /app

COPY package*.json ./

RUN npm install && npm install -g @angular/cli

COPY . .

RUN npm run build --prod

FROM nginx:alpine

RUN rm -rf /etc/nginx/conf.d/default.conf

COPY nginx.conf /etc/nginx/conf.d/default.conf

COPY --from=builder /app/dist/frontend /usr/share/nginx/html

EXPOSE 80


CMD ["nginx", "-g", "daemon off;"]