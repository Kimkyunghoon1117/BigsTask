### 1. SyncApplication(port8000), InquireApplication(port8001) 을 실행시킵니다.

![image](https://github.com/Kimkyunghoon1117/BigsTask/assets/136357654/0fe42cee-a4c7-4c48-9341-bb5d7920246f)

### 2. 단기 예보를 DB에 저장하게 하는 API(http://localhost:8000/) - 경기도 의정부시 문충로74 지역(nx:61, ny:130) 전날 데이터를 DB에 저장합니다.
![image](https://github.com/Kimkyunghoon1117/BigsTask/assets/136357654/0541e503-e727-4eb7-9c50-4564089fabcb)

![image](https://github.com/Kimkyunghoon1117/BigsTask/assets/136357654/f87311d8-6425-4ef7-a4ab-da3ba9208ebd)

### 3. 단기 예보를 조회 하는 API(http://localhost:8001/) 데이터가 없을 경우 Http status 204 오류를 응답합니다.

![image](https://github.com/Kimkyunghoon1117/BigsTask/assets/136357654/ec145358-775b-4fc9-aa36-3588811b7296)

### 4. 단기 예보를 조회 하는 API(http://localhost:8001/) 데이터가 있을 경우 테이블에 데이터를 보여줍니다.

![image](https://github.com/Kimkyunghoon1117/BigsTask/assets/136357654/d3e36096-623c-44dc-8d72-99eaf3a9a7e2)

![image](https://github.com/Kimkyunghoon1117/BigsTask/assets/136357654/71bfbe30-5a71-4860-81e1-064ed03399ef)
