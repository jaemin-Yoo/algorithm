import re

answer = ''

new_id = "=.="

new_id = new_id.lower()
new_id = re.sub(r"[^a-z0-9-_.]", "", new_id)
new_id = re.sub(r"[.]{1,}", ".", new_id)

print(new_id[0])
print(new_id[-1])

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

print(new_id)