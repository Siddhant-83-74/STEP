import requests
from bs4 import BeautifulSoup


def decode_message(url:str):
    response=requests.get(url)
    # print(response)
    soup = BeautifulSoup(response.text,"html.parser")

    grid_data={}
    max_x=0
    max_y=0

    rows=soup.find_all("tr")
    # print(rows)
    for row in rows[1:]:
        # print("11")
        cols=row.find_all(["td","th"])
        # print(cols)
        if len(cols)<3:
            continue

        x_val=cols[0].get_text(strip=True)
        char=cols[1].get_text(strip=True)
        y_val=cols[2].get_text(strip=True)

        # print(x_val)

        x=int(x_val)
        y=int(y_val)

        if char:
            grid_data[(x,y)]=char[0]
            max_x=max(x,max_x)
            max_y=max(y,max_y)
            

    for y in range(max_y+1):
        for x in range(max_x+1):
            print(grid_data.get((x,y)," "),end="")
            # print(x,y)
        print()

url="https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub"
if __name__=="__main__":
    decode_message(url)
