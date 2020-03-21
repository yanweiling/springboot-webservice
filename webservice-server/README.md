postman中 post请求 http://127.0.0.1:8090/ws
body raw xml(text/xml)
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gs="http://www.springboot.example.cn/webservice">
 <soapenv:Header/>
 <soapenv:Body>
   <gs:authorRequest>
     <gs:name>张三</gs:name>
   </gs:authorRequest>
 </soapenv:Body>
</soapenv:Envelope>

返回：
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:authorResponse xmlns:ns2="http://www.springboot.example.cn/webservice">
            <ns2:author>
                <ns2:name>姓名：张三</ns2:name>
                <ns2:hobby>电影</ns2:hobby>
                <ns2:hobby>旅游</ns2:hobby>
                <ns2:sex>female</ns2:sex>
                <ns2:birthday>1990-01-23</ns2:birthday>
                <ns2:description>描述：一枚趔趄的猿。现在时间：1584783181231</ns2:description>
            </ns2:author>
        </ns2:authorResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>