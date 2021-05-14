import requests
import pandas
from bs4 import BeautifulSoup
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
print(reform)

