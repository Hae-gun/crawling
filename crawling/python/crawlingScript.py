import requests
import pandas
from bs4 import BeautifulSoup
import json
import time
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
print('url>>> ',url)
def allCrawling(url,lastnumber):
    myDict=dict()
    for i in range(1,lastnumber):
        reformUrl=url+'/'+str(i)
        req = requests.get(reformUrl,verify=False)
        soup = BeautifulSoup(req.text,'html.parser')
        reform=soup.select(
            '#problemset > tbody > tr > td:nth-child(2) > a'
            )
        level=soup.select(
            '#problemset > tbody > tr > td:nth-child(2) > a > span'
            )
        print(level)
        print(reform)
        for data in reform:
            sub=str(data)
            start=sub.find('>')
            #print(start)
            end=sub.rfind('<')
            name=sub[start+1:end]
            subUrl=sub[1:start]
            myDict[name]=subUrl
        time.sleep(1)
    return myDict

#lastNumber=result.select(
#    '/html/body/div[2]/div[2]/div[6]/div[2]/div/ul/li[208]/a'
#    )
#print(lastNumber)
result=allCrawling(url,2)

print('result>>> ',result)
#myDict=dict()
#for data in reform:
#    sub=str(data)
#    start=sub.find('>')
#    #print(start)
#    end=sub.rfind('<')
#    name=sub[start+1:end]
#    url=sub[1:start]
#    myDict[name]=url
##
#json_val=json.dumps(myDict,ensure_ascii=False,indent='\t')
#print(json_val)
#
#with open('result.json','w',encoding='utf-8') as make_file:
#    json.dump(result,make_file,ensure_ascii=False,indent='\t')

