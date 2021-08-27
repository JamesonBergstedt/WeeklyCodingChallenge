# Python:
# Create a function that, when given two positive integers a b, returns the string "a" if integer a took fewer steps to reach 1 than b when passed through the Collatz sequence, or "b" if integer b took fewer steps to reach 1 than a.
#
# Examples
# collatz(10, 15) --> "a"
# # Because 10.0 - 5.0 - 16.0 - 8.0 - 4.0 - 2.0 - 1.0: 6 steps
# # 15.0 - 46.0 - 23.0 - 70.0 - 35.0 - 106.0 - 53.0 - 160.0 - 80.0 - 40.0 - 20.0 - 10.0 - 5.0 - 16.0 - 8.0 - 4.0 - 2.0 - 1.0: 17 steps
#
# collatz(13, 16) --> "b"
#
# collatz(53782, 72534) --> "b"


def collatz(a, b):
    while a != 1 and b != 1:
        if a%2 == 0:
            a = int(a/2)
        else:
            a = (3*a) + 1
        if b%2 == 0:
            b = int(b/2)
        else:
            b = (3*b) + 1

    if a == 1:
        return 'a'
    else:
        return 'b'


print(collatz(10,15))

