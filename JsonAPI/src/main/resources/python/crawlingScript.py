import requests
from bs4 import BeautifulSoup
import pandas
import time

def crawling(url):
    response = requests.get(url,verify=False)
    print(response.status_code)
    return response.text

#url=str(input())
url = 'https://www.acmicpc.net/problemset'
html=crawling(url)
soup=BeautifulSoup(html,'html.parser')

lnum=str(soup.select('body > div.wrapper > div.container.content > div:nth-child(6) > div:nth-child(2) > div > ul > li:last-child > a'))
lastNum = lnum[lnum.index('>')+1:lnum.rindex('<')]
result = list()
for page in range(1,int(lastNum)+1):
    turl = url + '/' + str(page)
    print(turl)
    html2=crawling(turl)
    soup2=BeautifulSoup(html,'html.parser')
    nameNurl=soup2.select('#problemset > tbody > tr > td:nth-child(2)')
    for s in nameNurl:
        cont = dict()
        tmp = str(s).replace('<td>','').replace('</td>','')
        link = tmp[tmp.index('=')+1:tmp.index('>')]
        name = tmp[tmp.index('>')+1:tmp.rindex('<')]
        cont['id']=link[link.rindex('/')+1:-1]
        cont['name']=name
        cont['url']=link[1:-1]
        #print(cont)
        result.append(cont)
    #contents = str(nameNurl).split('>')
    if page == 3:break
    time.sleep(1)
print(result)
#category=soup.select('#problemset > tbody > tr > td:nth-child(3)')
#for i in range(len(nameNurl)):
#    print(nameNurl[i])

