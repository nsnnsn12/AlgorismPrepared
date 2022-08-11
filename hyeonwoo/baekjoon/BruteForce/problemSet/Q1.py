# 백준 4673 셀프넘버

natural_nums = set(range(1, 10001))
generate_nums = set()

for i in range(1, 10001):
    for j in str(i):
        i += int(j)
    generate_nums.add(i)

answers = sorted(natural_nums - generate_nums)

for answer in answers:
    print(answer)

    