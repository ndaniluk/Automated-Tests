[![N|Solid](https://www.chrome666.com/wp-content/uploads/2020/04/unnamed-1.jpg)](https://chrome.google.com/webstore/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm)

**Talend API Tester** służy do testowania REST API. Jest to wtyczka do przeglądarki Google Chrome. Oznacza to, że nie potrzebna jest żadna dedykowana aplikacja do działania, lecz jedyna działająca z nią przeglądarka to Google Chrome.
Za pomocą bardzo prostego w użyciu (bardzo przypominającego POSTMANa) interfejsu możemy testować dowolne rządania (REST, hypermedia, SOAP, OData).

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/9GZCgsp44sJmIm~wPuM4EQ/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8&nocache=1612100286321)

Po wysłaniu rządania, możemy analizować odpowiedzi z API za pomocą:
- Pretty Print obsługujący różne formaty (np. JSON lub XML)
- Podlgądanie obrazków i innych zasobów HTTP, które zostaną zwrócone
- Podążanie za hiperłączami

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/DGf7sn3B751M~yk9wGODFg/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8)

Po całej operacji możesz zapisywać, organizować i udostępniać swoje rządania do API.

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/DlwEjBdYXTqLjnsOOVNP2g/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8&nocache=1612100669134)



**Tworzenie scenariuszy**

Za pomocą Talend API Tester możliwe jest tworzenie kompleksowych scenariuszy testowych, które będą odzwierciedlały rzeczywiste przypadki użycia. Przykładowo można używać ponownie tych samych rządań lub przenosić odpowiedź HTTP do następnego rządania.

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/HyNRmUcHEpoALiaHuYTtpw/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8)

Testować można niemal wszystko co udostępnia nam HTTP - od zawartości ciała odpowiedzi, przez wartości w nagłówkach, aź po czas odpowiedzi.



**Debugowanie API**

Tworząc rządanie możemy wyspecyfikować
- HTTP Method
- URL
- Header
- Body



**HTTP**

Lista metod HTTP jest predefiniowana. Nie znajdziemy tam metody TRACE ponieważ Talend API Tester polega na XmlHttpRequest API i jego implementacja w Google Chrome nie obsługuje metody TRACE.
Nie możesz edytować ciała rządania, jeśli wybierzesz metodę nie obsługującą ciała np. GET.
![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/LdGkD7MULVJPyI1V~uxYsA/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8)



**URL**

Składa się z:
- Protokół używany do interakcji z serverem np. HTTP/HTTPS
- Nazwa hosta i opcjonalnie port
- Ścieżka do zasobów, które ma obsłużyć rządzanie HTTP

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/V5HcD65W1UikNg2y2X8ixw/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8)



**Header**

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/JRhWL5l0r0uBJG5XCGUN9Q/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8)

Auto uzupełnianie jest dostępne dla nazw nagłówków i dla wartości następujących nagłówków:
Accept, Accept-Charset, Accept-Encoding, Accept-Language, Accept-Ranges
Allow
Expect
Cache-Control
Content-Encoding, Content-Language, Content-Type
Transfer-Encoding

Nagłówek Content-Type jest automatycznie dobierany ze względu na wybrany format w edytorze ciała rządania. Możemy jednak nadpisać tą wartość
Nagłówek Authorization ma dedykowaną zakładkę, która wspiera BASIC Authentication. Pozwala to na wpisanie loginu i hasła, które będą potem zhashowane.



**Body**

Można edytować:
- Czysty tekst
- JSON, XML i HTML z kolorowaniem składni

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/5nXtLtmPo4r8X6ZpsUMT4A/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8)

Można również wysyłać pliki z dysku

![N|Solid](https://help.talend.com/internal/api/webapp/maps/HujBrzfhc9BvOeZxdRW3_A/resources/f1O~pDHOY9aZ4gh43xzk8A/content?Ft-Calling-App=ft%2Fturnkey-portal&Ft-Calling-App-Version=3.9.8)





