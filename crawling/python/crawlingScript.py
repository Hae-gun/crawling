import requests
import pandas
from bs4 import BeautifulSoup
import json
def crawling(url):
    req = requests.get(url,verify=False)
    print('Crawling Finish')
    print('parsing')
    soup = BeautifulSoup(req.text,'html.parser')
    return soup
    
url=str(input())
result=crawling(url)
reform=result.select(
    '#problemset > tbody > tr > td:nth-child(2) > a'
    )

myDict=dict()
for data in reform:
    sub=str(data)
    start=sub.find('>')
    #print(start)
    end=sub.rfind('<')
    name=sub[start+1:end]
    url=sub[1:start]
    myDict[name]=url

json_val=json.dumps(myDict,ensure_ascii=False,indent='\t')
print(json_val)

with open('result.json','w',encoding='utf-8') as make_file:
    json.dump(myDict,make_file,ensure_ascii=False,indent='\t')

