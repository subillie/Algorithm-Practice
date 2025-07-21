arr = ['a', 'b', 'c', 'd', 'e']

print("[::2]", *arr[::2])  # a c e
print("[::-1]", *arr[::-1])  # e d c b a
print("[3::-1]", *arr[3::-1])  # d c b a
print("[-3::-1]", *arr[-3::-1])  # c b a
print("[-3::2]", *arr[-3::2])  # c e
print("[-5::3]", *arr[-5::3])  # a d
print("[-6:6:3]", *arr[-6:6:3])  # a d