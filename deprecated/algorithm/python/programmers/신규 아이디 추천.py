import re

def solution(new_id):
    answer = ''

    new_id = new_id.lower()
    new_id = re.sub(r"[^a-z0-9-_.]", "", new_id)
    new_id = re.sub(r"[.]{1,}", ".", new_id)

    if new_id[0] == ".":
        if len(new_id) > 1:
            new_id = new_id[1:]
        else:
            new_id = ""

    if new_id != "" and new_id[-1] == ".":
        if len(new_id) > 1:
            new_id = new_id[:-1]
        else:
            new_id = ""

    if new_id == "":
        new_id = "a"

    if len(new_id) >= 16:
        new_id = new_id[:15]

    if new_id[-1] == ".":
        new_id = new_id[:14]

    if len(new_id) <= 2:
        for i in range(3):
            new_id += new_id[-1]
            if len(new_id) == 3:
                break

    answer = new_id

    return answer