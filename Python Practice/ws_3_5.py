# 함수와 제어문
"""
create_user 함수와 decrease_book 함수는 이전 실습 문제와 동일하다.
- many_user 변수에 create_user 함수의 반환값인
    모든 신규 고객 정보 딕셔너리를 요소로 갖는 리스트를 할당한다.
rental_book 함수는 info 인자 하나만 할당 받을 수 있다.
- info 인자는 신규 고객의 이름과 나이를 담은 딕셔너리이다.
- 신규 고객의 나이를 10으로 나눈 몫을 대여할 책의 수로 활용한다. (decrease_book 함수의 인자)
- info 인자에 사용될 딕셔너리는 many_user와 map을 사용해 새로운 딕셔너리를 생성한다.
    - 이 때, map에 사용될 함수는 lambda로 구현한다.
    - 그 결과를 rental_book 함수에 각각 전달하여 호출한다. 이 때 역시 map 함수를 사용한다.
"""

def create_user(*args: tuple) -> list:
    """
    return 모든 신규 고객 정보 딕셔너리를 요소로 갖는 리스트
    """
    for name in args[0]:
        print(f"{name}님 환영합니다!")

    return list(map(
            lambda x: {'name': x[0], 'age': x[1], 'address': x[2]},
            zip(*args)
        ))

def decrease_book(number: int) -> None:
    """
    대여 후 남은 책의 수를 수정 및 출력
    Args:
        number: 대여한 책의 수
    """
    global number_of_book
    number_of_book -= number
    print("남은 책의 수:", number_of_book)

def rental_book(**info: dict) -> None:
    """
    책 대여 처리 (재고 반영, 대여 멘트 출력)
    Args:
        info: {name: <str>, age: <int>} 형태의 딕셔너리
    """
    name = info["name"]
    rental_number = info["age"] // 10
    decrease_book(rental_number)
    print(f"{name}님이 {rental_number}권의 책을 대여하였습니다.")



name = ['김시습', '허균', '남영로', '임제', '박지원']
age = [20, 16, 52, 36, 60]
address = ['서울', '강릉', '조선', '나주', '한성부']

many_user = create_user(name, age, address)
number_of_book = 100
# print(many_user)

# {user["name"], user["age"]}가 안 되는 이유
# dict()는 여러 개의 dict를 못 받음 => (key, value) tuple을 만들어야 함
info = dict(map(lambda user: (user["name"], user["age"]), many_user))
list(map(lambda x: rental_book(name=x[0], age=x[1]), info.items()))
