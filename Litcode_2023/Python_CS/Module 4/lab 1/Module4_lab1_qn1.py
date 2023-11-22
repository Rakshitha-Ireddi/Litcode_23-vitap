def clumsy_factorial(n):
    if n <= 2:
        return n

    result = n * (n - 1) // (n - 2) + (n - 3)
    n -= 4

    while n >= 4:
        result -= n * (n - 1) // (n - 2) - (n - 3)
        n -= 4

    if n > 0:
        result -= n

    return result

n=int(input())
print(clumsy_factorial(n))
