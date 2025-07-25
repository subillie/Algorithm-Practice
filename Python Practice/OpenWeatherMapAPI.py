# OpenWeather
# API Specification: https://openweathermap.org/current

import requests, json
from pprint import pprint

def get_weather_by_location(lat: float, lon: float) -> json:
    """
    위도, 경도로 해당 지역 날씨를 받아오는 함수
    - API key가 포함되어 있으니 주의
    """
    api_key="ed075917fca82f068759a3f480081748"
    url = f"https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={api_key}"
    response = requests.get(url).json()
    return response

def get_weather_by_city(city_name: str) -> json:
    """
    해당 도시의 날씨를 받아오는 함수
    - API key가 포함되어 있으니 주의
    """
    api_key="ed075917fca82f068759a3f480081748"
    url = f"https://api.openweathermap.org/data/2.5/weather?q={city_name}&appid={api_key}"
    response = requests.get(url).json()
    return response

DEFAULT = "\033[0m"
YELLOW = "\033[93m"
CYAN = "\033[96m"

lat = 37.56  # 서울 위도
lon = 126.97  # 서울 경도
print(f"\n{CYAN}[ WEATHER OF LAT {YELLOW}{lat}{CYAN}, LON {YELLOW}{lon}{CYAN} ]{DEFAULT}\n")
response = get_weather_by_location(lat, lon)
pprint(response)

city_name = "Seoul,KR"  # "Tokyo,JP", "New Yorks,US" 등
print(f"\n{CYAN}[ WEATHER OF THE CITY {YELLOW}{city_name}{CYAN} ]{DEFAULT}\n")
response = get_weather_by_city(city_name)
pprint(response)