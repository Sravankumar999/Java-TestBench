#include<bits/stdc++.h>
using namespace std;

vector<int> v[1000];
set<int> visited;
queue<int> q;
void ins(int a,int b){
    v[a].push_back(b);
    v[b].push_back(a);
}

void print(){
    for(int i=0;i<10;i++){
        for(auto e:v[i]){
            cout<<e<<" ";
        }
        cout<<endl;
    }
}

void bfs(int n){
    visited.insert(n);
    q.pop();
    for(int r:v[n]){
        if(visited.find(r)==visited.end()){
            q.push(r);
            visited.insert(r);
            cout<<r<<"-";
        }
    }
    int ele=q.front();
    bfs(ele);
}

int main(){
    int a,b;
    ins(0,1);
    ins(0,3);
    ins(1,2);
    ins(1,3);
    ins(1,5);
    ins(1,6);
    ins(2,3);
    ins(2,4);
    ins(2,5);
    ins(3,4);
    ins(4,6);
    q.push(0);
    bfs(0);
    //print();
}