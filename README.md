# SimpleCrawler
Простой интернет-crawler. В текущей реализации поддерживается только скрапинг title'ов страниц.
### Отправка запроса на скрапинг title'ов
В тело запроса помещается json в формате: {"urls": ["<url1>",...]}
Ответом будет json:
[{"url":"<url1>","result":{"title":"<url1_title>"},"code":<url1_status_code>, "error_msg": "<url1_error_msg>"}]
##### Пример
###### Запрос:
curl -i -X POST -H "Content-Type: application/json" -d "{\"urls\": [\\"https://www.google.com\\", \\"invalid_url\\"]}" http://127.0.0.1:8080/titles
###### Ответ:
[{"url":"https://www.google.com","result":{"title":"Google"},"code":0},{"url":"invalid_url","code":-1,"error_msg":"Malformed URL: invalid_url"}]