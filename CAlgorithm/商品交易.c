#include<stdio.h>
long long a[100000];
int main (){
    long long n, i, result = 0, time = 0, pre = 0, flag = 1;
    scanf("%lld", &n);
    for(i = 0; i < n; i++){
        scanf("%lld", &a[i]);
    }
    for(i = 1; i < n; i ++){
        if(a[i] > a[i - 1]){
            result += a[i] - a[i - 1];
            if(flag) {
                flag = 0;
                time ++;
            }
        } else if (a[i] < a[i - 1]){
            if(!flag){
                flag = 1;
                time ++;
            }
        }
    }
    if(!flag){
        flag = 1;
        time ++;
    }
    printf("%lld %lld\n", result, time);
}

